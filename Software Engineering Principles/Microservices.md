# Microservices 

https://auth0.com/blog/introduction-to-microservices-part-4-dependencies/

## DEPENDENCY AND DATA SHARING

## DEPENDENCY


### The problem of dependencies.
As we have discussed in previous posts, one of the biggest enemies of distributed architectures are dependencies. In a microservice-based architecture, services are modeled as isolated units that manage a reduced set of problems. However, fully functional systems rely on the cooperation and integration of its parts, and microservice architectures are not an exception.


al monolithic application, dependencies usually appear as method calls. It is usually a matter of importing the right parts of the project to access their functionality. In esence, doing so creates a dependency between the different parts of the application. With microservices, each microservice is meant to operate on its own. However, sometimes one may find that to provide certain functionality, access to some other part of the system is necessary. In concrete, some part of the system needs access to data managed by other part of the system.

This is what is commonly known as data sharing: two separate parts of a system share the same data. If you are familiar with multithreaded programming you have a taste of how hard data sharing can get. However, in contrast to multithreaded applications, data sharing in a distributed architecture has its own sets of problems:



* Can we share a single database? Does this scale as we add services?
* Can we handle big volumes of data?
* Can we provide consistency guarantees while reducing data-access contention using simple locks?
* What happens when a service developed by a team requires a change of schema in a database shared by other services?


![Microservices](ms1.png?raw=true "Microservices db sharing")

We will now study how some of these questions are answered in practice.

### Separating concerns
Before going back to our problem of shared data and calls between services we need to take a step back and ask ourselves the obvious question: if we have these problems, could it be that we made a mistake while modeling our data or APIs? Certainly. This is why we need to talk about what we mean by separate concerns in greater detail. This can be described with the help of two concepts:


* Loose coupling: which means microservices should be able to be modified without requiring changes in other microservices.
* Problem locality: which means related problems should be grouped together (in other words, if a change requires an update in another part of the system, those parts should be close to each other).

In concrete, loose coupling means microservices should provide clear interfaces that model the data and access patterns related to the data sitting behind them, and they should stick to those interfaces (when changes are necessary, versioning, which we will discuss later, comes into play). Problem locality means concerns and microservices should be grouped according to their problem domain. If an important change is required in a microservice related to billing, it is much more likely other microservices in the same problem domain (billing) will require changes, rather than microservices related to, say, product information. 

<B>In a sense, developing microservices means drawing clear boundaries between different problem domains, then splitting those problem domains into independent units of work that can be easily managed. </B>

It makes much more sense to share data inside a domain boundary if required than share data between unrelated domains.


![Microservices](ms2.png?raw=true "Microservices db sharing")


### The case for merging services into one
One important question you should ask yourself when working with separate microservices inside a problem domain is: are these services talking too much with eachother? If so, consider the impact of making them a single service. Microservices should be small, but no smaller than necessary to be convenient. Bam! Data sharing and dependency problems are gone. Of course, the opposite applies: if you find your services getting bigger and bigger to reduce chattiness, then perhaps you should rethink how your data is modeled, or how your problem domains are split. Trying to keep balance is the key.


![Microservices](ms3.png?raw=true "Microservices db sharing")


By the way, remember improving your solutions through iteration is part of the benefits of the microservices approach. Do your best effort to get things right from the beginning, but know you can make changes if things don't work out.


## DATA SHARING

Now that we understand that data sharing may not be the only answer, we will focus on what to do when it is. We will split shared data in two groups: static data and mutable data.

### Static data
Static data is data that is usually read but rarely (if ever) modified. Sometimes it is necessary to study access patterns after the system goes live before finding out what data can be considered static. The nice thing about static data is that even if it is shared, no locks or consistency algorithms are necessary. All services can read the data concurrently and not care about any other readers. However you can choose different approaches to store this data according to your needs:


* Keep it in a database: this may or may not be a good approach according to the database you have picked. Two things to keep in mind: 

1) Is it sensible to have each service query this database through the wire each time this data is required? 

2) Can transactional updates to the data be performed whenever this data needs to be updated (even if it is once in a while)?

* Embed it in the code or share it as a file: if the data is small enough, it may make sense to embed it in the code or distribute it as part of a file to be deployed with each service. Things to keep in mind: 1) How easy is it to atomically restart all services sharing this data? 2) Is it small enough to not cause performance issues when loading each service?
* Make it into a service: similar to the database approach with the added benefit of being able to make arbitrarily complex decisions about how the data is sent over the wire and who can access it.


### Mutable data
As we have mentioned before, the biggest problem with shared data is what to do when it changes. Suppose our microservice architecture is the heart of an online game distribution service. One of our microservices handles the game list of a customer. Other microservice handles the purchase of a game. When a customer purchases a game, that game is added to the list of games he or she owns. Our purchase microservice needs to tell our game-list microservice of the games that are added to a customer's list. How can we approach this problem? What follows is a list of common approaches to the problem. We will describe each and their advantages and disadvantages (note this is not an exhaustive list).


