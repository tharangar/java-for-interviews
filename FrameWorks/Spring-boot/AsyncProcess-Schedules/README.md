## Spring Boot Async Processes

Spring boot Asynchronous Processes allow developers to user parallel thread from main thread.
This project describe how to do it.

https://www.youtube.com/watch?v=106WWFvgNW0

I will use the same example taken in the above sample to send email asynchronously.


https://github.com/leanstacks/spring-boot-fundamentals/blob/async/src/main/java/org/example/ws/Application.java

### Starter Class.

@EnableAsync

above anotation requied in the starter class to mention parallel processing going to be used in the application.

### Asyn service implementation.

There are 3 method in this service class.

#### send()
This is a normal synchronous send method. It will send an email and return the status.

#### sendAsynchy()

This method will send an email Asnycronously parallaly but it is not returning any data.


#### sendAsyncWithResult()

Hear email will be sent parallaly and it will reutn the response using Future interface.

```

package org.example.ws.service;

import java.util.concurrent.Future;

import org.example.ws.model.Greeting;

/**
 * The EmailService interface defines all public business behaviors for
 * composing and transmitting email messages.
 * 
 * This interface should be injected into EmailService clients, not the
 * implementation bean.
 * 
 * @author Matt Warman
 */
public interface EmailService {

    /**
     * Send a Greeting via email synchronously.
     * @param greeting A Greeting to send.
     * @return A Boolean whose value is TRUE if sent successfully; otherwise
     *         FALSE.
     */
    Boolean send(Greeting greeting);

    /**
     * Send a Greeting via email asynchronously.
     * @param greeting A Greeting to send.
     */
    void sendAsync(Greeting greeting);

    /**
     * Send a Greeting via email asynchronously. Returns a Future&lt;Boolean&gt;
     * response allowing the client to obtain the status of the operation once
     * it is completed.
     * @param greeting A Greeting to send.
     * @return A Future&lt;Boolean&gt; whose value is TRUE if sent successfully;
     *         otherwise, FALSE.
     */
    Future<Boolean> sendAsyncWithResult(Greeting greeting);

}

```

 A Java Future, java.util.concurrent.Future, represents the result of an asynchronous computation. When the asynchronous task is created, a Java Future object is returned. This Future object functions as a handle to the result of the asynchronous task. Once the asynchronous task completes, the result can be accessed via the Future object returned when the task was started.

Some of Java's built-in concurrency utilities, like e.g. the Java ExecutorService, return a Java Future object from some of their methods. In the case of the ExecutorService, it returns a Future when you submit a Callable for it to execute concurrently (asynchronously). 
Future interface is provided since java 1.8. 

http://tutorials.jenkov.com/java-util-concurrent/java-future.html


Implementation of the java EmailService interface.

@Async anotation indicate taskmanger to initiate new Thread for this method.



```
package org.example.ws.service;

import java.util.concurrent.Future;

import org.example.ws.model.Greeting;
import org.example.ws.util.AsyncResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * The EmailServiceBean implements all business behaviors defined by the
 * EmailService interface.
 * 
 * @author Matt Warman
 */
@Service
public class EmailServiceBean implements EmailService {

    /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Boolean send(Greeting greeting) {
        logger.info("> send");

        Boolean success = Boolean.FALSE;

        // Simulate method execution time
        long pause = 5000;
        try {
            Thread.sleep(pause);
        } catch (Exception e) {
            // do nothing
        }
        logger.info("Processing time was {} seconds.", pause / 1000);

        success = Boolean.TRUE;

        logger.info("< send");
        return success;
    }

    @Async
    @Override
    public void sendAsync(Greeting greeting) {
        logger.info("> sendAsync");

        try {
            send(greeting);
        } catch (Exception e) {
            logger.warn("Exception caught sending asynchronous mail.", e);
        }

        logger.info("< sendAsync");
    }

    @Async
    @Override
    public Future<Boolean> sendAsyncWithResult(Greeting greeting) {
        logger.info("> sendAsyncWithResult");

        AsyncResponse<Boolean> response = new AsyncResponse<Boolean>();

        try {
            Boolean success = send(greeting);
            response.complete(success);
        } catch (Exception e) {
            logger.warn("Exception caught sending asynchronous mail.", e);
            response.completeExceptionally(e);
        }

        logger.info("< sendAsyncWithResult");
        return response;
    }

}

```


AsyncResponse  is the class which is used to get Future object from Async methods.
Since java 1.8 completableFuture class also doing this same tasks.

```
package org.example.ws.util;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The AsyncResponse class implements the Future interface. This class
 * facilitates the normal and exceptional completion of asynchronous tasks (or
 * methods) and wraps their response.
 * 
 * The AsyncResponse class seeks to mimic some behaviors defined in the
 * CompletableFuture class provided in JDK version 8. If using JDK 7 or earlier,
 * the AsyncResponse class is a suitable substitute for CompletableFuture.
 * 
 * @author Matt Warman
 *
 * @param <V> The type of Value object wrapped and returned by the
 *        AsyncResponse.
 */
public class AsyncResponse<V> implements Future<V> {

    /**
     * Indicates the block operation should run indefinitely until the
     * AsyncResponse state changes.
     */
    private static final long BLOCK_INDEFINITELY = 0;

    /**
     * The value returned from the task.
     */
    private V value;
    /**
     * The exception, if any, thrown by the task.
     */
    private Exception executionException;
    /**
     * TRUE if the task throws an Exception. Otherwise FALSE.
     */
    private boolean isCompletedExceptionally = false;
    /**
     * TRUE when the task is cancelled or interrupted. Otherwise FALSE.
     */
    private boolean isCancelled = false;
    /**
     * TRUE when the task is complete. Otherwise FALSE.
     */
    private boolean isDone = false;
    /**
     * The interval, in milliseconds, which any <code>get</code> method checks
     * if the task is complete. Default: 100 milliseconds.
     */
    private long checkCompletedInterval = 100;

    /**
     * Create a new AsyncResponse which has no value and is not complete.
     */
    public AsyncResponse() {

    }

    /**
     * Create a new, completed AsyncResponse with the supplied value.
     * @param val An object of type V used as the task response value.
     */
    public AsyncResponse(V val) {
        this.value = val;
        this.isDone = true;
    }

    /**
     * Create a new, completed AsyncResponse with the supplied Exception. The
     * AsyncResponse is marked as completed exceptionally. When the client
     * invokes one of the <code>get</code> methods, an ExecutionException will
     * be thrown using the supplied Exception as the cause of the
     * ExecutionException.
     * 
     * @param ex A Throwable.
     */
    public AsyncResponse(Throwable ex) {
        this.executionException = new ExecutionException(ex);
        this.isCompletedExceptionally = true;
        this.isDone = true;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        this.isCancelled = true;
        this.isDone = true;

        return false;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    public boolean isCompletedExceptionally() {
        return this.isCompletedExceptionally;
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {

        block(BLOCK_INDEFINITELY);

        if (isCancelled()) {
            throw new CancellationException();
        }
        if (isCompletedExceptionally()) {
            throw new ExecutionException(this.executionException);
        }
        if (isDone()) {
            return this.value;
        }

        throw new InterruptedException();
    }

    @Override
    public V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {

        long timeoutInMillis = unit.toMillis(timeout);
        block(timeoutInMillis);

        if (isCancelled()) {
            throw new CancellationException();
        }
        if (isCompletedExceptionally()) {
            throw new ExecutionException(this.executionException);
        }
        if (isDone()) {
            return this.value;
        }

        throw new InterruptedException();
    }

    /**
     * Mark this AsyncResponse as finished (completed) and set the supplied
     * value V as the task return value.
     * @param val An object of type V.
     * @return A boolean that when TRUE indicates the AsyncResponse state was
     *         successfully updated. A response of FALSE indicates the
     *         AsyncResponse state could not be set correctly.
     */
    public boolean complete(V val) {
        this.value = val;
        this.isDone = true;

        return true;
    }

    /**
     * Mark this AsyncResposne as finished (completed) with an exception. The
     * AsyncResponse value (V) is set to null. The supplied Throwable will be
     * used as the Cause of an ExceptionException thrown when any
     * <code>get</code> method is called.
     * 
     * @param ex A Throwable.
     * @return A boolean that when TRUE indicates the AsyncResponse state was
     *         successfully updated. A response of FALSE indicates the
     *         AsyncResponse state could not be set correctly.
     */
    public boolean completeExceptionally(Throwable ex) {
        this.value = null;
        this.executionException = new ExecutionException(ex);
        this.isCompletedExceptionally = true;
        this.isDone = true;

        return true;
    }

    /**
     * Set the interval at which any <code>get</code> method evaluates if the
     * AsyncResponse is complete or cancelled.
     * @param millis A long number of milliseconds.
     */
    public void setCheckCompletedInterval(long millis) {
        this.checkCompletedInterval = millis;
    }

    /**
     * Pauses the current thread until the AsyncResponse is in a completed or
     * cancelled status OR the specified timeout (in milliseconds) has elapsed.
     * If the timeout value is zero (0), then wait indefinitely for the
     * AsyncResponse to be completed or cancelled.
     * 
     * @param timeout A long number of milliseconds after which the process
     *        ceases to wait for state change.
     * @throws InterruptedException Thrown when the blocking operation is
     *         interrupted.
     */
    private void block(long timeout) throws InterruptedException {
        long start = System.currentTimeMillis();

        // Block until done, cancelled, or the timeout is exceeded
        while (!isDone() && !isCancelled()) {
            if (timeout > BLOCK_INDEFINITELY) {
                long now = System.currentTimeMillis();
                if (now > start + timeout) {
                    break;
                }
            }
            Thread.sleep(checkCompletedInterval);
        }
    }

}
```