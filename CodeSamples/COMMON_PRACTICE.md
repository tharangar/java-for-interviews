
# COMMON PRACTICE TO DEVELOP SPRING BOOT APPLICATIONS


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

# Date time format configuration
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=Asia/Kolkata



## 6. Reffernce.

Always reffer  Java Design document, ISD and FRS before you start the work.


## 7. Your own time table

Have a own planner .  Other wise we will miss our important tasks and we dont have any understanding on our effort. Allocate at least 1h for learning process.


![Alt text](calender.PNG?raw=true "Simple Planner")


