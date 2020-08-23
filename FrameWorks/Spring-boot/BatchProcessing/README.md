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



    *  step - A Step that delegates to a Job to do its work. This is a great tool for managing dependencies between jobs, and also to modularise complex step logic into something that is testable in isolation. The job is executed with parameters that can be extracted from the step execution, hence this step can also be usefully used as the worker in a parallel or partitioned execution.

    ItemReader - Strategy interface for providing the data. Implementations are expected to be stateful and will be called multiple times for each batch, with each call to read() returning a different value and finally returning null when all input data is exhausted. Implementations need not be thread-safe and clients of a ItemReader need to be aware that this is the case. A richer interface (e.g. with a look ahead or peek) is not feasible because we need to support transactions in an asynchronous batch.

    ItemProcessor - Interface for item transformation. Given an item as input, this interface provides an extension point which allows for the application of business logic in an item oriented processing scenario. It should be noted that while it's possible to return a different type than the one provided, it's not strictly necessary. Furthermore, returning null indicates that the item should not be continued to be processed.
    
    ItemStreamWriter - Basic interface for generic output operations. Class implementing this interface will be responsible for serializing objects as necessary. Generally, it is responsibility of implementing class to decide which technology to use for mapping and how it should be configured. The write method is responsible for making sure that any internal buffers are flushed. If a transaction is active it will also usually be necessary to discard the output on a subsequent rollback. The resource to which the writer is sending data should normally be able to handle this itself.
