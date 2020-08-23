## Spring Boot Batch Processing

Simple sample example by Mkyong.com
https://mkyong.com/spring-batch/spring-batch-hello-world-example/

Spring boot Batch processin by pivotal
https://www.youtube.com/watch?v=bhFBtNiZYYY
https://github.com/mminella/Batch-In-2019

Consider an environment where users have to do a lot of batch processing. This will be quite different from a typical web application which has to work 24/7. But in classic environments it's not unusual to do the heavy lifting for example during the night when there are no regular users using your system. Batch processing includes typical tasks like reading and writing to files, transforming data, reading from or writing to databases, create reports, import and export data and things like that. Often these steps have to be chained together or you have to create more complex workflows where you have to define which job steps can be run in parallel or have to be run sequentially etc. That's where a framework like Spring Batch can be very handy.
Spring Boot Batch provides reusable functions that are essential in processing large volumes of records, including logging/tracing, transaction management, job processing statistics, job restart, skip, and resource management. It also provides more advanced technical services and features that will enable extremely high-volume and high performance batch jobs though optimization and partitioning techniques.Simple as well as complex, high-volume batch jobs can leverage the framework in a highly scalable manner to process significant volumes of information.



## What is Batch process

Batch processing is defined as the processing of a finite amount of data without interaction or interruption..

Spring Batch is a framework for batch processing – execution of a series of jobs. In Spring Batch, A job consists of many steps and each step consists of a READ-PROCESS-WRITE task or single operation task (tasklet).

Batch doesn't wait for anything. it start and do until completes.


    1. For “READ-PROCESS-WRITE” process, it means “read” data from the resources (csv, xml or database), “process” it and “write” it to other resources (csv, xml and database). For example, a step may read data from a CSV file, process it and write it into the database. Spring Batch provides many made Classes to read/write CSV, XML and database.

    2. For “single” operation task (tasklet), it means doing single task only, like clean up the resources after or before a step is started or completed.

    3. And the steps can be chained together to run as a job.


* 1 Job = Many Steps.
* 1 Step = 1 READ-PROCESS-WRITE or 1 Tasklet.
* Job = {Step 1 -> Step 2 -> Step 3} (Chained together)


### Spring Batch Examples

Consider following batch jobs :

    Step 1 – Read CSV files from folder A, process, write it to folder B. “READ-PROCESS-WRITE”
    Step 2 – Read CSV files from folder B, process, write it to the database. “READ-PROCESS-WRITE”
    Step 3 – Delete the CSB files from folder B. “Tasklet”
    Step 4 – Read data from a database, process and generate statistic report in XML format, write it to folder C. “READ-PROCESS-WRITE”
    Step 5 – Read the report and send it to manager email. “Tasklet”




### job
job is finite process. job consists of some steps.

### step
step is a selef contained unit of work.


### chunk based step
looping some amount of process.
Spring batch can break up whole processes as many chunks.

![Spring Boot patch processing](chunk.PNG?raw=true "Spring boot batch chunk")


### tasklet based step


![Spring Boot patch processing](jobrepository.PNG?raw=true "Spring boot batch jobrepository")


In this lesson we are using bellow sample project which nicely explain everything.

https://www.javainuse.com/spring/bootbatch
https://youtu.be/RseVNuNKjoY


![Spring Boot patch processing](how.PNG?raw=true "How spring boot batch processing works")



    step - A Step that delegates to a Job to do its work. This is a great tool for managing dependencies between jobs, and also to modularise complex step logic into something that is testable in isolation. The job is executed with parameters that can be extracted from the step execution, hence this step can also be usefully used as the worker in a parallel or partitioned execution.

    ItemReader - Strategy interface for providing the data. Implementations are expected to be stateful and will be called multiple times for each batch, with each call to read() returning a different value and finally returning null when all input data is exhausted. Implementations need not be thread-safe and clients of a ItemReader need to be aware that this is the case. A richer interface (e.g. with a look ahead or peek) is not feasible because we need to support transactions in an asynchronous batch.

    ItemProcessor - Interface for item transformation. Given an item as input, this interface provides an extension point which allows for the application of business logic in an item oriented processing scenario. It should be noted that while it's possible to return a different type than the one provided, it's not strictly necessary. Furthermore, returning null indicates that the item should not be continued to be processed.

    ItemStreamWriter - Basic interface for generic output operations. Class implementing this interface will be responsible for serializing objects as necessary. Generally, it is responsibility of implementing class to decide which technology to use for mapping and how it should be configured. The write method is responsible for making sure that any internal buffers are flushed. If a transaction is active it will also usually be necessary to discard the output on a subsequent rollback. The resource to which the writer is sending data should normally be able to handle this itself.

***

### how this is implemented in the coding

which si in the attached project.

### POM.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.javainuse</groupId>
	<artifactId>springboot-batch</artifactId>
	<version>0.0.1</version>
	<packaging>jar</packaging>

	<name>SpringBatch</name>
	<description>Spring Batch-Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.3.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-batch</artifactId>
		</dependency>
		
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>

		

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

### Create a batch configuration class as below.

```
package com.javainuse.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.listener.JobCompletionListener;
import com.javainuse.step.Processor;
import com.javainuse.step.Reader;
import com.javainuse.step.Writer;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
				.reader(new Reader()).processor(new Processor())
				.writer(new Writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
```

Define the class implementing the spring batch ItemReader interface as follows-


```
package com.javainuse.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

	private String[] messages = { "javainuse.com",
			"Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}

```

Define the class implementing the spring batch ItemProcessor interface as follows-

```
package com.javainuse.step;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String data) throws Exception {
		return data.toUpperCase();
	}

}
```

Define the class implementing the spring batch ItemWriter interface as follows-

```
package com.javainuse.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> messages) throws Exception {
		for (String msg : messages) {
			System.out.println("Writing the data " + msg);
		}
	}

}
```


Define the Listener class that is executed when the job is finished. 

```
package com.javainuse.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}

}

```

Expose an API using the controller to invoke the Spring Batch Job. 

```
package com.javainuse.controller;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class JobInvokerController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job processJob;
 
    @RequestMapping("/invokejob")
    public String handle() throws Exception {
 
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(processJob, jobParameters);
 
        return "Batch job has been invoked";
    }
}

```

In the properties file define the h2 database as follows-

```
spring.datasource.url=jdbc:h2:file:./DB
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.batch.job.enabled=false

```


Run the following Spring Boot class to start our application 

```
package com.javainuse;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}
}

```

Go to url http://localhost:8080/invokejob, this will start the Batch Job.

It should print in the web browser as "Batch job has been invoked".

The you may check the IDE console.

![Spring Boot patch processing](console.PNG?raw=true "How spring boot batch processing works")


We now use the H2-console to see data in H2 database. Go to localhost:8080/h2-console/login.do.
In the JDBC url use jdbc:h2:mem:testdb. Keep the password blank.Click on Connect. 

We can see the spring batch meta data tables created here. 







