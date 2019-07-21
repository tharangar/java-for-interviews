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
