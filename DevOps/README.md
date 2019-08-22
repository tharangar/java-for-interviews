
# DevOps

Refference : ntelliPaat youtube video.

## What is DevOps

Developper develops the code
Operation team test the code and deploy systems.

When operation guy received the code from developper there may be some issues between those parties due to lack of understanding developed codes.

This issue was solved using devops. DevOps is an idea of working in the way to solve above problem.
Expected enhance productivity with frequent releases.


### Definition

![DevOps](devops.png?raw=true "DevOps")

In present senario Dev guys dont handover just code to operation team . Now they build docker images and push it can be operated by opration team without having any overhead.

### Devops Lifecycle

![DevOps - LifeCycle](lifecycle.png?raw=true "DevOps Life Cycle")


### How DevOps works

![How DevOps works](cicd.png?raw=true "CICD")

Developer pushes code to Version Control system. 
Continuous integration will identify that programmer has pushed new codes to Vertion control system and then it test the code from testing server. If test succeeds code will be pushed to production server. 

### Life Cycle stages in DevOps


* Continous Development
    Git isa distributed version-control system for tracking changes in computer files and coordination work on those files among multiple people.

* Continous Integration
    Jenkins is an open source automation server written in Java. Jenkins helps to auomate non human part.

*   Continous Deployment
    Configuration management  and Virtualization and containerziation are the main tasks in this stage.
    puppet , Ansible used for configuration mangement and docker is used for virtualization and containerzation.

*   Continous Testing
    Selenium is a portable software-testing framework used for web applications. It is open source tool which is used for testing automation.

*   Continous Monitoring
    Nagios is a monitoring system, network and infrastructure. It also offer monitoring and alerting services .


![How DevOps works with tools](tools.png?raw=true "Tools")


Lets start with quick introduction with those tools.

## Git

Git is the most popular tool among all the DVCS tools.
It is primaraly used for source-code management in software development, but it can be used to keep track of changes.


### Create a repository

    $ git init

### Check the status

    $ git status

This command will shows the status and status of the repositor. Not added or modified files will be shown in red. Already added and un changed files will be shown in green.

### Adding a file to the repository.

    $ git add test.txt

    Adding all changed or availabe files to the repostory

    $ git add .

    $ git commit -m "First commit "

### Add remote repository

Once everything is ready on our local, we can start pushing our changes to the remote repository. copy your repository link and paste it in the command.

    $ git remote add origin "https://github.com/tharangar/centercore.git"

### Push command to remote repository

    $ git push origin master

### How to get existing repository to local

    $ git clone "URL"

When you clone git repository whole repository will be coppied to your local pc with repository configuration.


### Pullin the latest changes from the repository

    $ git pull <URL link>

The git pull command is also used for pullng the latest changes fromt he repository, unlike git clone, this command can only work inside an initialized git repository. This command is used when you are already working in the cloned repository, and want to pull the latest changes, that others might have pushed to the remote repository.


### Branch

Git branches are used to handle the workspace of multiple developpers.
Creating a branch is used bellow command and when we create the branch last commit of the master branch will be copy to it.

    $ git branch branch1

Delethe a branch

    $ git branch -D branch1

List the branches

    $ git branch

Pushing to remote branches.

    $ git push origin branch1


### To switch to the new bracn

    $ git checkout branch1


### Every commit dtails can be viewed by log command

    $ git log

History details has who has done it and commit id data and what is done. If you are in a feature branch you can see only brach commits.


### Save work without commit.

Want to save your work without committing the code ? Git has got you covered. This can be helful when you want to switch branches, but do not want to save your work to your git repository. To stash your staged files without committing just type in 

    $ git stash
If you want to stash your untracked files as well , type 

    $ git stassh -u

Once you are back and want to retrive working, type in 

    $ git stash pop


### git revert

This command helps you in reverting a commit, to a pervious version. commit ID can be taken from log

    $ git revert <commit id>

### Understanding difference between two file or two commits.

    git diff <commit id version x> <commit id version y>


# Docker

 If Dev guy want to give the appliction code to operation tema, ops guy has to know the all versions of os, libries, languages and all components used for development. So it is a painfull task. So the soluton is to use a container with the requied os, libries and language versions configured and application also contained. Docker comes as a good solution for this container creation. When we docker with traditional vm, vm has whole os in the container and it runs on hypervisor run top op the host operating system but docker runs on container engine.

 Docker has many os images from vary light weight like alpine to any other os you want.


### Docker installation.

MAC, Windows and Dabian has different installtion methods. It is very easy with ubuntu.

    $ sudo apt-get update
    $ sudo apt-get install docker.io



### Docker Lifecycle

![Docker life cycle](docker-lifecycle.png?raw=true "Docker Lifecycle")

### Docker Comands

    Check docker version

    $ docker -version

    Download docker images from docker hub

    $ docker pull ubuntu

    Check downloaded images

    $ docker images

    Run the image

    $ docker run -it -d

    -d : run the container in the back ground (deamon)
    -it : make container interactive

    Opening port to access from your host when container up

    $ docker run -it -p 82:80 -d tharangar/testserver

    List of currently running containers

    $ docker ps
    
    stoping the container

    $ docker stop <container id>

    Accessing the container

    $ docker exec -it <image id> 

    -it : to be interractive

    Killing the container will stop and remove the container.

    $ docker rm <container id>

    Deleting a already running container

    $ docker rm -f <container id>

    Remove images from your local docker repository

    $ docker rmi <image id> 

you can use docker hub to keep your personal docker images. go to https://hub.docker.com and create your own account.

### Creating custom containers (Saving changes to container) and push them to docker hub.

    First run a container

    $ docker run -it -d ubuntu

    Do the changes first

    Save the image

    $ docker commit <container id> <your docker username/new image name>

    This step will ceate a new image with given name and it include your changes too. This is how we can create custom containers.

    Push your customer image to docker hub

    $ docker login

    Provide docker hub username and password and after succesfull login message received you can push your image.

    $ docker push tharangar/testserver 

### Removing all containers in the system

    $ docker rmi (docker ps -aq)



### Dockerfile

We can use dockerfile for customization docker images. Using docker build users can create an automated build of container images.

### Main key words in dockerfile

FROM : define the base image

ADD : Add files to the container being build.
    Ex : ADD <source directory> <container directory>
    Ex : Add . /var/www

RUN : this command add a layer in container by installing and exicuting commands.

CMD : This is running command at the start of the contariner.This command running only when there is no argument specified while running the container.
    EX : CMD apachectl -D FOREGROUND

ENTRYPOINT : Better to use Entripoint instead of cmd

ENV : we can set any environment variable by theis command.
    EX : ENV name Devops

### Sample docker file

```
FROM ubuntu
RUN apt-get update
RUN apt-get install apache2
ADD . /var/www/html
ENTRYPOINT apachectl -D FOREGROUND
ENV name new_dockerfile
```
Save above file as Dockerfile and run following command to build image called new_dockerfile

    $ docker build . -t new_dockerfile


Then list the images you may see the new image has created you container and check using the browser.

    $ docker run -it -p 82:80 -d new_dockerfile


### Docker Volumes.

First method is bind-mount which enables us to map internal folder to host machine folder. There are some drowback with this setting due to different os and file path changes will not work this solution.

    $ docker run -it -v /home/ubuntu/test: /app -d ubuntu

The solution for above issue is docker volume
Docker volumes are used to persist data across the docker life cycle.

    $ docker volume create test

    View present volumes

    $ docker volume ls

    Run the application with created volume test

    $ docker run -it --mount source=test,target=/app -d ubuntu

This method will alow you to protect your data eventhough container removed. Furthe it will be shared by all containers which use the same volume name and data can be accessed from any container.

    Coppying files to container volume

    $ docker cp ./test.txt <containerid>:/app

Another imporatant thing what ever we put to the volume can be accessed only from volume mounted container. You cant access any file without mounting the volume.

### Microservices

Monolithic application is single-tiered software application in which different components are combined into a single program which rsides in a single platform.

But this is hard to do maintenance and all components are dependent eachother and each components impact to others. So updating or bug fixing in one componenet will couased for entire system down time.

Such application is large and complex to understand. 

Has a barrier to adopting new technologies.

Solution is microservic architecture.

Microservices are a software development architectural style that structures an a application development as components are loosly couplecd. We can use any technology for any components but there communication happens over apis.

### Docker compose

Docker compse is the tool for defining and running milti-container Docker applications. With compose, you use a ymal file to intrograte many containers as one file.

### Installing docker compose

    $ docker-compose --version

You have to check whether it is already available if not you have to install it manually.


![Docker Compose](docker-compose.png?raw=true "Docker Compose")


Above file can be found in dockr.doc for wordpress.

    $ docker-compose up -d

To find the file automatically it's name should be docker-compose.yaml or docker-compose.yml

When you run above program you may find workpress systme over port 8000.

### Container Orchestration tools (Swarn)

All container health will monitored by docker itself. What Swarn do orchestraion automatically monitoring health and keep containers up and running.

Docker container should have more than one machine to be a distributed type architecture to manage high availability for docker swarm. Docker swarm will be installed when docker is installed.

It manage many worker with leader in cluster.

This will create the leader node for cluster

    $ docker swarm init --advertise-addr:<ip of the leader>

It will create the command which is requied other worker nodes to join this cluster.

View available nodes.

    $ docker nodes ls

Use bellow command to leave the cluster.

    $ docker swarm leave








# AWS 


In Application deploymnet we are having follwoing drowbacks.

    This setup is expensive.
    Troubleshooting conflict with bussiness goals.
    When traffic is varying, hardware wasted if optimized to maximum traffic.

How it happen now.

    Dont buy expensive servers. Just put your data in cloud servers.
    Scalability. Your server capacity will vary according to traffic.
    Cloud provider will mange your server, hence no warries about the infrastructure.


Amazon Web services (AWS), Google Cloud Platform (GCP) , Microsoft Azure are common cloud server providers.

What is the cloud computing.

It is the use of remote servers on the internet to store, mange and process data rather than a locl server or your personal computer.

AWS has 31% market share in the cloud computing market. AWS has 6x times server capacity if all other provide x.
 AWS has flexible pricing also. If we want to activate a server only 3 hours it will cost only for 3 hours. That much of flexibility in cloud computing.

 Amazon Web Services (AWS) is a secure cloud services platform, offering compute power, databases, storage, content delivery etc.

 Defferent Daomains in AWS.

    EC2 (Elastic Computer cloud)
    It is a computer cloud . it just like new pc with fresh operating system.

    Migration
    When we want to transport data to AWS like peta byte scale. There is a service called snowball for data transport with physical hard drive.

    Security and Identity Compliance
    For this service AWS has IAM.
    This is the permission arrangement for various users.

    Storage
    This is a object based file system. It's a file system not a database. Database cant save image file or exicutable files. S3 is the AWS storage services.

    Networking and Content Delivery.
    Route 53 is the Network service in AWS.
    It has a simple domain name systme and many IP configuration.

    Messaging
    This is the email service, We can use this service to send bulk emails to customers

    Database.
    This is a RDBS (Relational Database service).
    
    Management Tools.
    Managing all services.


## AWS Computer servcies
### EC2
EC2 is the base for the all AWS computer services. 

![AWS EC2](ec2.png?raw=true "EC2")

It just like a row server. We can configure any services according to our requirments. It can be resized according to our need. We can launch multiple servers for same configuration. Hear we have to configure our application environment and configure firewall too.

### Lambda

It is Advanced version of EC2. Lambda cant be used for hosting application. It is used to execute backgroud tasks. Ex : AWS lambda can trigger some functions.

### Elastic  Beanstalk

The different between lambda and beanstalk is Elastic beanstalk is automated configuration for differnt deployments. Ex : If we want to deploy php application Elastic Beanstalk has php environment configured instances. We just have to upload our code to the server. Ex : php, java, python environments can be found in Elastic Beanstalk. Overhead works like installing php and firewall configuration in EC2 has removed in this service.


### Elasti Load Balancer

Distributes the workload on the deployed instances.

### AutoScaling

Scale up and down automatically. 
It works with Elastic Load Balancer.


### Practical 

Sign in to AWS console

Got to dashbord select EC2.

Click on  Launch Instance button.

Select AMI (Amazon Machine Image) which is the planed operating system.

Then chose instance Type Ex : t2.micro

Add storage Ex 30 GB

Add Tags Ex Linux server

step 6 Security Group configuration.
It is configuration for inbouund and outbound traffic.

Then generate key pair or use existing one.
Hear you can download your private key but if you lose it you may not log in to it back your data is gone. To connect your server you should have this key file.

No you have completed the proces and then go back to EC2 dashbord and you may see running ec2 instances.


## AWS Storage Services

### S3

Object Oriented File System.
We have to create Bucket and all files are considered as object.


### Cloudfront

Content Delevery Network
