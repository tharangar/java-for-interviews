
# COMMON PRACTICE TO DEVELOP SPRING BOOT SERVICES


## 1. Regular comments

All method should have a understandable comment regarding the funciton doing inside.

Ex : 

```
	// ==================================================================================================
	// Following service will Modify the exising group and Modify Requests made by
	// the same user.
	// ==================================================================================================

	public ResponseEntity<Object> groupOrRequestCreationModification(GroupsDTO groupDTO, String createdUser,
			String groupID, String requestParty) {

		/**
		 * validate the user and the update or modigy the group request.
		 * 
		 */

		ResponseEntity<Object> result;

		CommonResponse commonRes = new CommonResponse();

		/**
		 * Group New Creation When Group ID is null it is always a new Group creation.
		 * Need to submit to approval or workflow. If workflow response is approved save
		 * the group.
		 */
		if (groupDTO.getGroupId() == null) { // New Creation


```


## 2. Update the readme.md file with final input and outputs (according to swagger).

Once development done as a part of dev testing all request and responses should be updated in the README.md or PAYLOADS.md file in the same project root.

Ex :

***

Initial Group Creation Request (Now There is no any workflow configuraiton for group creation ) .

(It should be approved once submit from customer  )

/v3/groups/client

Request :

adminUserId :nable

companyId : nable

```json

// Defferent tags to be used for defferent content

//```
//    normal codes
//```

//```json
//   json payload
//```

//```xml
//    xml payloads
//```

// Finaly out put will be seen as follows.

{
     
      "groupName": "DEV11",
      "companyId": "nable",

      "users": [
        {
          "userId": "tharanga",
          "userName": "tharanga",
          "status": "ACTIVE"

         
        },
        {
          "userId": "nable",
          "userName": "nable",
          "status": "ACTIVE"

         
        },
        {
          "userId": "sahan",
          "userName":"sahan",
          "status": "ACTIVE"

        
        }
      ]
    
}

```


Response :


```json

{
  "statusCode": "Workflow Submitted and request pending.",
  "statusCodeValue": 202,
  "approvedID": null,
  "errorCode": "PROCESSING"
}

```
***

## 3. Loggin configuration

Place following log configuraiton in  the resource folder for each service in logback-spring.xml  file
Required dependencies

```json
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>
		<!--  Add slf4j with logback. exclution should be commented from spring-boot-starter -->
		<dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </dependency>
```
configuration

```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!--
  ~ /*******************************************************************************
  ~  * logback configurtion goes hear
  ~  *******************************************************************************/
  -->

<!DOCTYPE xml>
<configuration debug="true">
    <appender name="STDOUT"
              class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
            [%-5p] [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] REQUEST.ID=%X{REQUEST.ID} REQUEST.PARTY=%X{REQUEST.PARTY}  REQUEST.OWNER=%X{REQUEST.OWNER} [%C] [%t] [%L]  
            %m%n
            </pattern>
        </encoder>
    </appender>
    <appender name="FILE"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <springProfile name="local">
            <!--            <file>/opt/PROJECT/NBL/log/SBOCMXLOG/transfer.log</file>-->
            <file>C:\Users\tharanga\Documents\logs\epf_etf.log</file>
            <!--            <Property name="log-path">C:\Users\tharanga\Documents\logs\epf_etf.log</Property>-->
            <rollingPolicy
                    class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- daily rollover -->
                <fileNamePattern>/opt/PROJECT/NBL/log/SBOCMXLOG/transfer-%d{yyyy-MM-dd-HH-mm}.log</fileNamePattern>
                <maxHistory>30</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>[%-5p] [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] REQUEST.ID=%X{REQUEST.ID} REQUEST.PARTY=%X{REQUEST.PARTY}  REQUEST.OWNER=%X{REQUEST.OWNER} [%C] [%t] [%L]  %m%n
                </pattern>
            </encoder>
        </springProfile>
          <springProfile name="test">
            <!--            <file>/opt/PROJECT/NBL/log/SBOCMXLOG/transfer.log</file>-->
            <file>C:\Users\tharanga\Documents\logs\workflow.log</file>
            <!--            <Property name="log-path">/home/suneth/loges/transfer.log</Property>-->
            <rollingPolicy
                    class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- daily rollover -->
                <fileNamePattern>/opt/PROJECT/NBL/log/SBOCMXLOG/transfer-%d{yyyy-MM-dd-HH-mm}.log</fileNamePattern>
                <maxHistory>30</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>[%-5p] [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] REQUEST.ID=%X{REQUEST.ID} REQUEST.PARTY=%X{REQUEST.PARTY}  REQUEST.OWNER=%X{REQUEST.OWNER} [%C] [%t] [%L]  %m%n
                </pattern>
            </encoder>
        </springProfile>
        <springProfile name="dev">
            <!--   <File>/opt/IBM/WebSphere/AppServer/profiles/ESB_DEV/logs/core/workflow.log</File> -->
            <file>C:\Users\tharanga\Documents\logs\workflow.log</file>
            <rollingPolicy
                    class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- daily rollover -->
                <fileNamePattern>
                    /opt/IBM/WebSphere/AppServer/profiles/ESB_DEV/logs/core/transfer-%d{yyyy-MM-dd-HH-mm}.log
                </fileNamePattern>
                <maxHistory>30</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>[%-5p] [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] REQUEST.ID=%X{REQUEST.ID} REQUEST.PARTY=%X{REQUEST.PARTY}  REQUEST.OWNER=%X{REQUEST.OWNER} [%C] [%t] [%L]  %m%n
                </pattern>
            </encoder>
        </springProfile>
        <springProfile name="production">
            <File>/opt/IBM/WebSphere/AppServer/profiles/ESB_DEV/logs/core/workflow.log</File>
            <rollingPolicy
                    class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- daily rollover -->
                <fileNamePattern>
                    /opt/IBM/WebSphere/AppServer/profiles/ESB_DEV/logs/core/workflow-%d{yyyy-MM-dd-HH-mm}.log
                </fileNamePattern>
                <maxHistory>30</maxHistory>
            </rollingPolicy>
            <encoder>
                <pattern>[%-5p] [%d{yyyy-MM-dd'T'HH:mm:ss.sss'Z'}] REQUEST.ID=%X{REQUEST.ID} REQUEST.PARTY=%X{REQUEST.PARTY}  REQUEST.OWNER=%X{REQUEST.OWNER} [%C] [%t] [%L]  %m%n
                </pattern>
            </encoder>
        </springProfile>
    </appender>
    <root level="INFO">
        <appender-ref ref="FILE"/>
        <appender-ref ref="STDOUT"/>
    </root>
    


</configuration>

```



## 4. REST CONTROLLER structure.

Rest controller better to be structured to support above logging mechanism as follows.
In a world of complex and distributed application, logging plays a very crucial role in auditing and debugging. I have been working on spring boot rest applications for a good amount of time now. And with multiple instances running and increased traffic, I quickly understood that I need a better way to track the logs of specific API requests.

The solution was pretty easy and simple with MDC (Mapped Diagnostic Context). This is what MDC is for.

The idea here is to stamp each request with a unique id using SLF4J’s MDC. And then passing that same unique id in the response headers. Doing this will print the generated UUID in all your logs for that particular request. 



```
    // =======================================================================================
	// AUTHPENDING : APPROVER VIEW (USED FOR AUTHPENDING APIs MODULE VISE )
	// - For Getting Pending requests
	//
	// This API has developed for Workflow_Common Util to provide assigns.
	// =======================================================================================
	// For list of workflow types.
	// Userlist will be proviced along with Assign details.
	// Later updated as Assign count as gravity instead providing all assigns for
	// same level in one option.
	// And filteration for List of domain wise
	// =======================================================================================
	@ApiOperation(value = "List of workflow Assigns for list of types for approval Users", nickname = "Pending workflows Assings for many types", notes = "List workflows Assings pending by user", httpMethod = "GET")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successfull", response = WorkflowAssignWithUserListResponse.class),
			@ApiResponse(code = 404, message = "resource not found"),
			@ApiResponse(code = 400, message = "Input parameters are not valid"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value = "/workflow/getAssignDetailsForTypeList")
	public ResponseEntity<WorkflowAssignWithUserListResponse> retrieveWorkflowAssignmentsForTypeList(
			@RequestHeader(name = "userId", required = true) String userId,
			@RequestHeader(name = REQUEST_ID_HEADER, required = true) String requestId,
			@RequestHeader(name = "companyId", required = true) String companyId,
			@RequestHeader(name = "domain", required = false) String domain, // Added under v 0.14 domain implementation
																				// to workflow will call this.
			@RequestParam(value = "type", required = true) List<String> types) {

		MDC.put("REQUEST.ID", requestId);
		MDC.put("REQUEST.OWNER", userId);
		MDC.put("REQUEST.PARTY", "CLIENTS");
		long startTime = System.currentTimeMillis();

		logger.info("Start execute method retrieveWorkflowDetails");


        // bla bla.. bla...

        long endTime = System.currentTimeMillis();
		logger.info("retrieveWorkflowDetails rate: avg_resp={}", (endTime - startTime));
		MDC.clear();
		return ResponseEntity.status(HttpStatus.resolve(workflowAssignResponse.getReturnCode()))
				.body(workflowAssignResponse);
	}

```

## 5. Make date format common for all projects.

https://www.baeldung.com/spring-boot-formatting-json-dates

We'll explore various ways of formatting dates using Jackson, which is used by Spring Boot as its default JSON processor.

If we do it DTO field wise , just anotate as follows.

@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Kolkata")
private Date insertionTime;


But recomanded way in our services is to configure property file as follows.

```
# Date time format configuration
# Issues came when there are defferent time format used early when retrive data 
# spring.jackson.date-format=yyyy-MM-dd HH:mm:ss   
spring.jackson.time-zone=Asia/Kolkata
```

## 6. Collection Iteration

Collection Iterations are requried for performin various operationsin . But useing a for loop is the basic and simplest method but it's performance is poor. Using stream is the latest technics and lets check possible solutions for colleciton iteration.

Available methods to Iterating list of object 

1. For loop  : Simple but performance is poor

```
int maxNumber = 10
ArrayList<Integer> list = new ArrayList<Integer>(maxNumber);
for (int item =1; item  <= maxNumber ; item++){
    list.add (item);
}

```

2. collection forEach loop

```
List<Integer> numberList = getListOfNumbers(100000000);
Long forEachSum = 0L;
LongAdder sequen 

```

Stream

![Streams ](stream.PNG?raw=true "Stream")



3. Sequenctial Stream

Above images has taken 4 core system.
Sequencial stream takes one core and do iterations one after another. Permonce is poor with respect to parallel strams. It execute maintaining the order.

```
    LongAdder sequentialStreamSum = new LongAdder();
    List<Integer> numberList = getListOfNumbers(100000000);
    numberList.stream().forEach()(sequenctialStramSum::add); // this add is add metod in LongAdder class

```

4. Parallel Stream
Parallel stram uses multiple cores when resources available. So performance wise parallel strams is ahead.
Ex : if you want to send email 10000 users. in such cases parallel strams is better than sequencial strams.
No any order is maintained. So the order of items is not imporatant for operations we can use parallelStrams.

```
    LongAdder parallaStreamSum = new LongAdder();
    List<Integer> numberList = getListOfNumbers(100000000);
    numberList.parallelStream().forEach()(parallaStreamSum::add); // this add is add metod in LongAdder class

```

We can measure time taken for each of cases by using java callender option

Calendar startTime = Calendar.getInstance();

// doing codes

Calendar endTime = Calendar.getInstance();

System.out.println(endtTime.getTimeInMillies() - startTime.getTimeInMillies());




## 7. Corporate Approval Process

### Auth pending

When looking at Auth pending objects there should be a current object and modified object and audit details along with required parameter for approval process (Dual authenticaiton approval data or  Workflow side Assign data). Current or modified objects can be taken from the temp tables which all module has , from  ORIGINAL_PAYLOADS and REQIEST_PAYLOADS.
This API is provided for approvers to approve corporate requests.

#### NEW_PENDING

current object : null for new request. but if it is a new_request modificaiton by the enterer then current object is not null and it has the master data value.

modified object : only requried parameters should be exposed through ESB. ( Audit details not shown under modified object even though audit details are added to the payload before save. )

audit details : To be taken from modified object in ESB .


#### MODIFY_PENDING, DELETE_PENDING

current object : currently active object in master tables

modified object : submited changes by user . ( Do not expose audit details through ESB even though those are updated in the modified payload)

audit details :  In ESB audit details of modified object should be exposed in this section. .


### GET APIs.

Other normal get APIs will provide only active object or deleted object.  New Pending  - > Rejected data should be removed from master data hence can not be shown in this API. (Enterer view will provided rejected New pending requests due to data will be taken from temp table).


### Entere view

Enterer view is provided to request submitted users to view submitted requests. It should have the changes he requested clearly .

It also should have current and modified object as we considered in auth pending. Further it should have a parameter to retrive audit details from audit trail. (Ex, workflow ID and approval Id).

Workflow and Approval modules have provided common APIs to get Audit details from workflowId and approvalId.

Hence enterers can view Rejected requests from Enterer APIs.





## 8. Using lombok.

Lombok libry will add Getters, Setters , builder, constructior , hashcode and toString methods to model classes.
https://www.youtube.com/watch?v=GBNZMvaHHOk


@Getter : create all getters. we cna define access level also
Ex : @Getter(AccessLevel.PRIVATE);
If we put AccessLevel.NONE then field will not be accessible.

Reffer above video to get good understanding how it works.

But we found issues when we use @ToString anotation from lombok and use it from logs in cases which we have
parenet and child model classes and both are having lombok @ToString  anotations. (Due to a infinite loop).

In such cases we have to override toStirng in such cases.


## 9. Java 8 New Features.

1.  Lambda Expression

Suppose you need to change this method to lambda expressin

 ```
    public void m1(){
        sop("Hello");
    }

```
Lambda expression are annonimus ( no name), no return type , no modified.

    () -> {
        sop("Hello);
    }


or  

    () - > sop("Hellow");

EX  :2

```
    public void sum(int a, int b){
        sop(a+b);
    }
```

    (int a, int b) -> {sop(a+b);}

OR

input types will be automatically set by the compiler

    (a, b ) - > sop(a+b);

Ex : 3

```
    public int m1(String s){
        return  s.length();
    }
```

    (String s) -> {return s.length();}

Defferent ways to optimize lambda expressions

if we have only single line we can represt it as follows with input type removal and when only one input available.

    s - > s.length();



2. Java 8 double colon (::) operator.

The double colon (::) operator is known as the method reference in Java 8. Method references are expressions which have the same treatment as a lambda expression, but instead of providing a lambda body, they refer to an existing method by name. This can make your code more readable and concise.

Read more: https://www.java67.com/2018/06/what-is-double-colon-operator-in-java-8.html#ixzz6yVNruv00

For example, to print all elements of the list, you can use the forEach() method as follows

list.stream.forEach( s-> System.out.println(s));


but here you can replace lambda expression with method reference to improve readability as shown below:

list.stream.forEach( System.out::println);

You can use method reference or double colon operator to refer to a static method, an instance method, or a constructor. For referring a static method, you can either use className or instanceRef, but to refer to an instance method of a particular object, you need to use instanceRef.


Where can you use the double colon operator in Java?
You can use the double colon operator (::) wherever you need to use the method reference.  Here are some examples of a method reference in Java 8:
A static method (ClassName::methodName) like Person::getAge
An instance method of a particular object (instanceRef::methodName) like System.out::println
A super method of a particular object (super::methodName)
An instance method of an arbitrary object of a particular type (ClassName::methodName)
A class constructor reference (ClassName::new) like ArrayList::new
An array constructor reference (TypeName[]::new) like String[]::new 

The idea is that if you are passing a lambda expression, like a function that takes a value and prints in the console then instead of giving lambda expression, just pass the println() method of PrintStream class which you can access as System.out::println.

Remember, there is no parenthesis when you refer to a method using method reference or lambda expression in Java 8. 

Here is a real-world example of method reference using a double colon operator in Java 8. In this example, we are creating a Comparator which compares person by their age. In the first example, we have used a lambda expression to pass the logic to compare age, while in the second line of code, we have used a double colon operator or method reference.

You can see that the second example is much more readable and clean:


![Double colon lambda comparison ](dc.JPEG?raw=true "dc")




3. Functional Interface

The interface who contains only one abstract method but can have multiple default and static method is called functioanl interface.

ex : 

Runnable    --- >  run()
Callable    --- >  call()
Comparable  --- >  compareTo()
Comparator  --- >  compare()

Those interfaces have only one abstract method. So those interfaces are called funcation interfaces.
Ex : runnable interface

![Functional Interface ](runnable.PNG?raw=true "Runnable")


We can write our own functional interfaces.

Ex :

```


@FunctionalInterface   // This anotation is not mandatory. we can remove it
public interface MyFunctionalInterface{

// abstract method there can be only one abstract method this is equal to  public abstract void m1();

void m1();


// default methods  ( multiple default methods may have)
default void m2(){
    System.out.println("Default method 2");
}

default void m3(){
    System.out.println("Default method 3");
}


// static method ( can have many static methods)
static void m4(){
    System.out.println("Static method");
}


}

```


Functional Interface with lambda expressions.


Traditional Approach

```
interface Calculator{

    void swithOn();
}



public class CalculatorImpl implements Calculator{

    @Override
    public void switchOn(){
        System.out.println("Switch On");
    }

    public static void main(String args[]){

    }

}


```


Lambda expression based new apporch

```
interface Calculator{

    void swithOn();
}


//  We can do it without implementing Calculator interface
public class CalculatorImpl {


    public static void main(String args[]){

        Calculator calculator = () - > {
            System.out.println("Swtich on");
        };

        calculator.switchOn();
        
    }

}


// We can simplify this due to method has only one line.

public class CalculatorImpl2 {


    public static void main(String args[]){

        Calculator calculator = () - > System.out.println("Swtich on");

        calculator.switchOn();
        
    }

}

```

Advantage on lambda expression on Functional interface we can use less code.

Another example with input.


```
interface Calculator{

    void sum(int input);
}

public class CalculatorImpl {


    public static void main(String args[]){

        Calculator calculator = (input) - > System.out.println("sum :"+input);

        calculator.sum(10);
        
    }

}

```


If abstract method has return type


```
interface Calculator{

    int subtract(int i1, int i2);
}

public class CalculatorImpl {


    public static void main(String args[]){
        // When there is no aditional bussiness logic
        Calculator calculator = (i1,i2) - > i2-i1;

        System.out.println(calculator.subtract(8,20));
        
    }

}


public class CalculatorImpl3 {


    public static void main(String args[]){

        Calculator calculator = (i1,i2) - > {
            // When there is bussiness logic.
            if(id2 > i1){
            return i2-i1;
            }
        };
        System.out.println(calculator.subtract(8,20));
        
    }

}

```


4. Sorting

Using the comparator is the eaiest method in sorting.

Traditional Approach. -----------------------------------------------------------------------------

```
import java.util.Collections;
import java.util.Comparator;
import java.util.List:

public class BookService(){

    public List<Book> getBooksinSort(){
        List<Book> books = new BookDAO().getBooks();
        Collections.sort(books, new MyComparator());
        return books;
    }
}

public static void main(String[] args ){
    System.out.println(new BookService().getBooksinSort());
}


// use one from bellow two class according to your requirment

// if we want to get it from assending order
class MyComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2){
        return o1.getName().compareTo(o2.getName());
    }
}


// if we want to get it from decending order
class MyComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2){
        return o2.getName().compareTo(o1.getName());
    }
}



```



Nested Comparator approach (Anonymous implementaion)  -------------------------------------------------


```
import java.util.Collections;
import java.util.Comparator;
import java.util.List:

public class BookService(){

    public List<Book> getBooksinSort(){
        List<Book> books = new BookDAO().getBooks();


        Collections.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2){
                return o2.getName().compareTo(o1.getName());
            }


        });


        return books;
    }


public static void main(String[] args ){
    System.out.println(new BookService().getBooksinSort());
}


}


```


Approach with lambda expression ---------------------------------------------------------------------

Lambda expression can be used to shorten the code as follows when we work with functiona interfaces
as shown bellow (Only one abstract method available interfaces)

```
import java.util.Collections;
import java.util.Comparator;
import java.util.List:

public class BookService(){

    public List<Book> getBooksinSort(){
        List<Book> books = new BookDAO().getBooks();

        Collections.sort(books, (o1,o2) -> o2.getName().compareTo(o1.getName()));
        return books;

    }


public static void main(String[] args ){
    System.out.println(new BookService().getBooksinSort());
}


}


```


5.  Predicates

Predicate is a interface present in Java.util.function package.
A predicate contains a function with a single arguemnt and returns boolean value. (Predicate have boolean vlaue function).

```
interface Predicate<T>
{
    public boolean test(T t);
}

```

Ex : 
Write a predicate to check whether the given integer is greater than 50 or not.
Write a predicate to check whether the length of given string is greater than 5 or not.

```

interface Predicate<T>
{
    public boolean test(T t);
}

public class Test {

    public static void main(String[] args){

        Predicate<Integer> p=I->I>50;
        Predicate<String> p1=s->s.length()>5;
        System.out.println(p.test(100));
        System.out.println(p1.test("Ashwini'));
    }
}

Result :

true
true



```

Predicate joining

We can join two or more predicate by using following methods.
1. 


```

psvm {

    int x[]={1,2,3,4,5,6};
    // Get even number
    Predicate<Integer> P1=I->I%2==0;

    //
    Predicate<Integer> P2=I->I>2;

    System.out.println("Print all even numbers :");
    m1(p1,x);

    System.out.println("Print all greater than 2 :");
    m1(p2.x);

    System.out.println("Print all greater than 2 and even : ");
    m1(p2.and(p1),x);

    System.out.println("Print all odd numbers : ");
    m1(p1.negate(),x);

    System.out.println('Print all greater than 2 or even : ");
    m1(p2.or(p1),x);


}


public static void m1(Predicate<Integer> p, int []x){

    for(int i:x){
        if(p.test(i)){
            System.out.println(i);
        }
    }

}


interface Predicate<T>
{
    public boolean test(T t);
}

```




###  Get distinct record from a list using lambda expression, comparator and predicates

https://howtodoinjava.com/java8/java-stream-distinct-examples/

```

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
 
public class JavaStreamDistinctExamples 
{
    public static void main(String[] args) 
    {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");
         
        //Add some random persons
        Collection<Person> list = Arrays.asList(lokesh,brian,alex,lokesh,brian,lokesh);
 
        // Get distinct objects by key
        List<Person> distinctElements = list.stream()
                    .filter( distinctByKey(p -> p.getId()) )
                    .collect( Collectors.toList() );
 
        // Let's verify distinct elements
        System.out.println( distinctElements );
    }
 
        //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
 
//Model class
class Person 
{
    public Person(Integer id, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }
 
    private Integer id;
    private String fname;
    private String lname;
 
    //Getters and Setters
 
    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }
}
```


6. Stream API

Java collection is a built in API for common data structures.
When we want to process object from the collection then we should go for stream.
Stream is a interface, present in java.util. stream

1. We got stream by incode stream() on top of collection object.

2. We can process a object in 2 ways.

    1. Congiguration



## 11. Get the latest branch for development and check with commited user and understandable branch name.





## 12. Reffernce.

Always reffer  Java Design document, ISD and FRS before you start the work.


## 13. Technical Writting

https://developers.google.com/tech-writing/overview

Samitha provided sample


## 14. monitory system development number types



## 15. Your own time planner

Have a own planner .  Other wise we will miss our important tasks and we dont have any understanding on our effort. Allocate at least 1h for learning process.

At least 0.5 h for your project managment . check remaining tasks and are you on track to complete the sprint.

At least 7 h of full focus working time periods for task completion.



![Alt text](calender.PNG?raw=true "Simple Planner")



