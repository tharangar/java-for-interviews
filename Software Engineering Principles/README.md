
# Evolution of Programming

1.  Procedural Programming

2.  Object Oriented Programming (OOP)

3.  Service Oriented Programming (SOP)


### Proecudural Programming

Function is everything. There were many difficulties in code reusability and code management.

### Object Oriented Programming

Classes and objects are everything. Main principles are Abstraction, Encapsulation, Inheritance and polymorphism. OOP increased code reusability and code managment. But the weekness is the communication between applications specially when they are written in different languages.

### Service Oriented Programming

Service is a well defined function and it does not depends on the context or state of other services. Services are communicating with other services using messages which every service can understand.

SOA can accommodate rapid changes tot he IT industry and reuse of services across multiple business process automations.
Further services can be discovered and interfaces can be changed without major changes to applications.

Real-time applictions are less suitable to SOA architecutre like telco real-time rating and call control.

Loose coupling, resuability and easy access pioritized by SOA but security comes next. So confidential informaiton is better kept isolated from common access through SOA.

There is no advantage using SOA for less resusble and non-hub applications.

If bussiness logic change frequently and highly reusable is more eligible for SOA. EX : payment requsts, balance inqueries, ldap requests, customer authentication.


### Basic Principles of SOA

1.  Technology neutral
2.  Statelessness
3.  Loose couling
4.  Reusability
5.  Abstracted
6.  Published
7.  Formal contract


### SOA can be implemented using following technologies.

1.  Web services
2. RPC
3.  CORBA (Common Object Request Broker Architecture)
4.  RMI (Remote Mthod Invocaiton)
5.  DCOM
6. SOAP (Simple object Access Protocol)


![SOA](soa.png?raw=true "SOA")

### Web Services

This is the most widely used concept for SOA implementation.
web services are functional blocks or services exposed to the Internet using internet protocols. Further it is independent form platforms and programming languages.

### UDDI

UDDI (Universal Description Discovery and Integration ) describe and publish the srevices in the web to be inquired by the service requesters.
UDDI is a XML based registry for businesses worldwide to listh themselves on the internet and UDDI is a web service standard.
It is designed to be interrogated by SOAP messages and to provide access to tweb Services Description language (WSDL)

In the micro services architecture the service definistion becomes further granular. Monolithic applications represent the single tired  software application consists of interfaces and data access codes are combined as a one single program.


### SOA Governance

1.  Compliance to standards and laws.
2.  Change managment.
3.   Using policies to retrict behaviours.
4.  Monitor performance of services.


### SOA change management guidelines.

1.  Introduce interface version to sustain the proactive nature of services.
2.  Adopt a clear version support ploicy.

3.  Spend considerable time and effort on designing interfaces.

4.   Adpt a SOA governance framework.


### IT platforms for SOA

Desired preformance and availability should be reflected int he plat forms. Fault tolerant clustered platforms are requred for higher availability srvices. Disaster recovery is also required.


### Restful Web Services

ReprEsentation State Transfer (REST)

As a solution for web srvices heavyweight standards that are inefficient restfull came to the arena.

REST styple is simpler than SOAP/WSDL for implementing web services.

RESTful services involve a lover overhead. REST unlike SAOP. It is not web service standard or  protocol but an architectural style and it uses web standards like URL, XML, JSON, MimE, types.

Rest is scalable and simple . Main intention of rest is if web is good enough for humans it should be dhould enough for mechine to machine interaction. 

So REST run on http protocol and it could make web services that uses the same principles that made the www such a success.

Rest architectue is also client server paradigm and it also stateless like http.

** Remember due to http is stateless some techniques like session, cookies are used to keep some prefferences for client side from servers.

REST uses different URLs to address resources and it maps the type of access to http methods.


### ROA (Resouce Oriented Architectur)

Due to Restfull technology all resouces in a system could be accessed with a seperate urls. Then this architecture was called Resource Oriented Architecture.

In REST , everything on the network is a resource

 - Resources are addressable via URIs.
 
 - Resources are self descriptive
 
 - Resources are stateless
 
 - Resources are manipulated via HTTP verbs and the uniform interface.


### Web Oriented Architecture (WOA)

We consider after 2010 it is web oriented era. With the concept of web 2.0 this idea was began. Following characteristics are found.

*   Creating Applications as platforms.
*   Simple Models :REST, Syndication, Widgets, OpenAPIs.
*   Interoperability and Reuse.
*   Driven by Network Effects and Viral Adoption.
*   Mashups and Rich Internet Applications.
*   Peer Production and Social Dynamics.


Anyway the central goal of SOA being turning appplications into open platforms. The increasing realization that there is limited business value in single applications. Businessses connecting to each other over the internet via web services. Many companies have opened their SOA to the web.


Finaly WOA also SOA.Basic tenets of SOA including the 8 princoples are follewed by WOA too. So best SOA can be implemented with WOA.

SOA uses WS-Security and other sophisticated standards for security, while WOA tends to just use HTTPS, OAuth, and HMAC-SHA-1.

### What is a "mashup"?

A mashup is a web site or web application that seamlessly combines content from more than one source into an integrated experiance. Content used in mashups is usually sourced from a 3 rd party via a public interface (API).
Other methods of sourcing content for mashups include web feeds (e.g. RSS or Atom), and  JavaScript/Flash "widgets".


** So applications are converting to WOA and open ended services with the support of cloud infrastructures.







## SOLID Principle

https://howtodoinjava.com/best-practices/5-class-design-principles-solid-in-java/


By Lokesh Gupta | Filed Under: Java Best practices

Classes are the building blocks of any java application. If these blocks are not strong, the building (i.e. application) is going to face the tough time in future. This essentially means that not so well-written can lead to very difficult situations when the application scope goes up or application faces certain design issues either in production or maintenance.

On the other hand, set of well designed and written classes can speed up the coding process by leaps and bounds, while reducing the number of bugs in comparison.

In this tutorial, We will discuss SOLID principles in Java with examples which are 5 most recommended design principles, we should keep in mind while writing our classes. They also form the best practices to be followed for designing our application classes.


    1.  S    Single Responsibility Principle
    2.  O    Open Closed Principle
    3.  L    Liskov's Substitution Principle
    4.  I    Interface Segregation Principle
    5.  D    Dependency Inversion Principle


### 1. Single Responsibility Principle

    One class should have one and only one responsibility

In other words, we should write, change and maintain a class for only one purpose. If it is model class then it should strictly represent only one actor/ entity. This will give us the flexibility to make changes in future without worrying the impacts of changes for another entity.

In given example, we have two classes Person and Account. Both have single responsibility to store their specific information. If we want to change state of Person then we do not need to modify the class Account and vice-versa.

Person.java

```
public class Person
{
    private Long personId;
    private String firstName;
    private String lastName;
    private String age;
    private List<Account> accounts;
}
```

Account.java

```
public class Account
{
    private Long guid;
    private String accountNumber;
    private String accountName;
    private String status;
    private String type;
}
```

### 2. Open Closed Principle

    Software components should be open for extension, but closed for modification

What does this mean?? This means that our classes should be designed such a way that whenever fellow developers wants to change the flow of control in specific conditions in application, all they need to extend our class and override some functions and that’s it.

For example, spring framework has class DispatcherServlet. This class acts as front controller for String based web applications. To use this class, we are not required to modify this class. All we need is to pass initialization parameters and we can extend it’s functionality the way we want.

```
public class HelloWorldAction extends Action
{
    @Override
    public ActionForward execute(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
                                throws Exception
    {
         
        //Process the request
 
    }
}
```

### 3. Liskov’s Substitution Principle

This principle is a variation of previously discussed open closed principle. It says:

    Derived types must be completely substitutable for their base types

It means that the classes fellow developer created by extending our class should be able to fit in application without failure. This requires the objects of your subclasses to behave in the same way as the objects of your superclass. This is mostly seen in places where we do run time type identification and then cast it to appropriate reference type.

For example, every book has an ISBN number which is in always a fixed display format. You can have separate representations of ISBN in database and UI. For this requirement, we may write property editor in such a way –

IsbnEditor.java

```
import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
import com.howtodoinjava.app.model.Isbn;
  
public class IsbnEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new Isbn(text.trim()));
        } else {
            setValue(null);
        }
    }
  
    @Override
    public String getAsText() {
        Isbn isbn = (Isbn) getValue();
        if (isbn != null) {http://localhost/
            return isbn.getIsbn();
        } else {
            return "";
        }
    }
}
```


### 4. Interface Segregation Principle

    Clients should not be forced to implement unnecessary methods which they will not use

Take an example. Developer Alex created an interface Reportable and added two methods generateExcel() and generatedPdf(). Now client ‘A’ wants to use this interface but he intend to use reports only in PDF format and not in excel. Will he be able to use the functionality easily?



### 5. Dependency Inversion Principle

    Depend on abstractions, not on concretions

In other words. we should design our software in such a way that various modules can be separated from each other using an abstract layer to bind them together.

The classical use of this principle of bean configuration in Spring framework.

In spring framework, all modules are provided as separate components which can work together by simply injected dependencies in other module. This dependency is managed externally in XML files.



