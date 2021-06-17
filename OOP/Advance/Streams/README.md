## JAVA STREAM

Ref : https://www.tutorialspoint.com/java8/java8_streams.htm

java Stream is a new abstract layer introduced in java8. 

Useing stram, you can process data in a declarative way similar to SQL statements. 

For esample, consider the following SQL statement.

```
SELECT max(salary), employee_id, employee_name FROM Employee
```

The above SQL expression automatically returns the maximum salaried employee's details, without doing any computation on the developer's end. Using collections framework in Java, a developer has to use loops and make repeated checks. Another concern is efficiency; as multi-core processors are available at ease, a Java developer has to write parallel code processing that can be pretty error-prone.

To resolve such issues, Java 8 introduced the concept of stream that lets the developer to process data declaratively and leverage multicore architecture without the need to write any specific code for it.


#### What is Stream

Stream represents a sequence of objects from a source, which supports aggregate operations. Following are the characteristics of a Stream −

Sequence of elements - 
A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.

Source -
Stream takes Collections, Arrays, or I/O resources as input source.

Aggregate Operations - 
Stream supports aggregate opertions like filter, map, limit, reduce, find, match, and so on.

Pipelining -
Most of the stream opeatons return stream itself so that their result can be pipelined.  These operations are called intermediate operations and their function is to take input, process them, and return output to the target. collect() method is a terminal operation which 





### My sample in the program


```
public CommonSearchBean getAuthPending(CommonSearchBean commonSearchBean) {
		String searchBy = commonSearchBean.getHashTags();
		String requestType = commonSearchBean.getRequestType();
		List<TempDto> list = new ArrayList<>();
		logger.info("Start getAuthPending record requestType: {}, status: {}, searchBy: {}", requestType,
				ApprovalStatus.PENDING, searchBy);
		String userId = commonSearchBean.getUserId();
		commonSearchBean.setUserId(null);
		commonSearchBean.setStatus(ApprovalStatus.PENDING);
		List<CommonTemp> commonTemps = tempCustomRepository.findTempRecordList(commonSearchBean);

		if (!commonTemps.isEmpty()) {
			logger.info("{} Temp records found", commonTemps.size());
			commonSearchBean.setUserId(userId);

			ApprovalResponse approvalResponse = getMyApprovals(commonSearchBean);

			for (CommonTemp commonTemp : commonTemps) {
				try {
		
					if (approvalResponse !=null && approvalResponse.getApprovals().stream()
							.anyMatch(o -> o.getApprovalId().equals(commonTemp.getApprovalId()))) {
						TempDto dto = new TempDto();
						BeanUtils.copyProperties(dto, commonTemp);
						dto.setSignature(signatureComponent.genarateSignature(commonTemp));
						list.add(dto);
					}
				

				} catch (Exception e) {
					throw new InvalidRequestException(
							messageSource.getMessage(ErrorCode.DATA_COPY_ERROR, null, LocaleContextHolder.getLocale()),
							ErrorCode.DATA_COPY_ERROR);
				}
			}
		} else {
			String msg = messageSource.getMessage(ErrorCode.NO_TEMP_RECORD_FOUND, null,
					LocaleContextHolder.getLocale());
			logger.error(msg);
			throw new RecordNotFoundException(msg, ErrorCode.NO_TEMP_RECORD_FOUND);
		}
		commonSearchBean.setTempList(list);
		return commonSearchBean;
	}


```

There are many ways to create a stream instance of different sources. Once created, the instance will not modify its source, therefore allowing the creation of multiple instances from a single source.

We should use the empty() method in case of the creation of an empty stream:

```
Stream<String> streamEmpty = Stream.empty();

```

We can also create a stream of any type of Collection (Collection, List, Set):

```
Collection<String> collection = Arrays.asList("a", "b", "c");
Stream<String> streamOfCollection = collection.stream();

```

An array can also be the source of a stream:

```
Stream<String> streamOfArray = Stream.of("a", "b", "c");

```

We can also create a stream out of an existing array or of part of an array:

```
String[] arr = new String[]{"a", "b", "c"};
Stream<String> streamOfArrayFull = Arrays.stream(arr);
Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
```

### Stream.builder()

When builder is used, the desired type should be additionally specified in the right part of the statement, otherwise the build() method will create an instance of the Stream<Object>:


```

Stream<String> streamBuilder =
  Stream.<String>builder().add("a").add("b").add("c").build();

```


The generate() method accepts a Supplier<T> for element generation. As the resulting stream is infinite, the developer should specify the desired size, or the generate() method will work until it reaches the memory limit:

```
Stream<String> streamGenerated =
  Stream.generate(() -> "element").limit(10);
```

The code above creates a sequence of ten strings with the value “element.”


### Stram.iterate()

Another way of creating an infinite stream is by using the iterate() method:

```
Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
```

The first element of the resulting stream is the first parameter of the iterate() method. When creating every following element, the specified function is applied to the previous element. In the example above the second element will be 42.


### Stream of Primitives

Java 8 offers the possibility to create streams out of three primitive types: int, long and double. As Stream<T> is a generic interface, and there is no way to use primitives as a type parameter with generics, three new special interfaces were created: IntStream, LongStream, DoubleStream.


Using the new interfaces alleviates unnecessary auto-boxing, which allows for increased productivity:

```
IntStream intStream = IntStream.range(1, 3);
LongStream longStream = LongStream.rangeClosed(1, 3);
```

The range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to the second parameter. It increments the value of subsequent elements with the step equal to 1. The result doesn't include the last parameter, it is just an upper bound of the sequence.

The rangeClosed(int startInclusive, int endInclusive) method does the same thing with only one difference, the second element is included. We can use these two methods to generate any of the three types of streams of primitives.

Since Java 8, the Random class provides a wide range of methods for generating streams of primitives. For example, the following code creates a DoubleStream, which has three elements:


```
Random random = new Random();
DoubleStream doubleStream = random.doubles(3);
```

### Stream of String

We can also use String as a source for creating a stream with the help of the chars() method of the String class. Since there is no interface for CharStream in JDK, we use the IntStream to represent a stream of chars instead.

```
IntStream streamOfChars = "abc".chars();

```

The following example breaks a String into sub-strings according to specified RegEx:

```
Stream<String> streamOfString =
  Pattern.compile(", ").splitAsStream("a, b, c");
```


### Stream of File

Furthermore, Java NIO class Files allows us to generate a Stream<String> of a text file through the lines() method. Every line of the text becomes an element of the stream:


```
Path path = Paths.get("C:\\file.txt");
Stream<String> streamOfStrings = Files.lines(path);
Stream<String> streamWithCharset = 
  Files.lines(path, Charset.forName("UTF-8"));

```

The Charset can be specified as an argument of the lines() method.


#### Referencing a Stream

We can instantiate a stream, and have an accessible reference to it, as long as only intermediate operations are called. Executing a terminal operation makes a stream inaccessible.

To demonstrate this, we will forget for a while that the best practice is to chain the sequence of operation. Besides its unnecessary verbosity, technically the following code is valid:

```
Stream<String> stream = 
  Stream.of("a", "b", "c").filter(element -> element.contains("b"));
Optional<String> anyElement = stream.findAny();

```

However, an attempt to reuse the same reference after calling the terminal operation will trigger the IllegalStateException:

```
Optional<String> firstElement = stream.findFirst();
```

As the IllegalStateException is a RuntimeException, a compiler will not signalize about a problem. So it is very important to remember that Java 8 streams can't be reused.

This kind of behavior is logical. We designed streams to apply a finite sequence of operations to the source of elements in a functional style, not to store elements.

So to make the previous code work properly, some changes should be made:


```
List<String> elements =
  Stream.of("a", "b", "c").filter(element -> element.contains("b"))
    .collect(Collectors.toList());
Optional<String> anyElement = elements.stream().findAny();
Optional<String> firstElement = elements.stream().findFirst();

```

## Stream Pipeline

To perform a sequence of operations over the elements of the data source and aggregate their results, we need three parts: the source, intermediate operation(s) and a terminal operation.

Intermediate operations return a new modified stream. For example, to create a new stream of the existing one without few elements, the skip() method should be used:


```
Stream<String> onceModifiedStream =
  Stream.of("abcd", "bbcd", "cbcd").skip(1);
```

If we need more than one modification, we can chain intermediate operations. Let's assume that we also need to substitute every element of the current Stream<String> with a sub-string of the first few chars. We can do this by chaining the skip() and map() methods:

```
Stream<String> twiceModifiedStream =
  stream.skip(1).map(element -> element.substring(0, 3));

```

As we can see, the map() method takes a lambda expression as a parameter. If we want to learn more about lambdas, we can take a look at our tutorial Lambda Expressions and Functional Interfaces: Tips and Best Practices.

A stream by itself is worthless; the user is interested in the result of the terminal operation, which can be a value of some type or an action applied to every element of the stream. We can only use one terminal operation per stream.

The correct and most convenient way to use streams is by a stream pipeline, which is a chain of the stream source, intermediate operations, and a terminal operation:


```
List<String> list = Arrays.asList("abc1", "abc2", "abc3");
long size = list.stream().skip(1)
  .map(element -> element.substring(0, 3)).sorted().count();

```

As we can see, the map() method takes a lambda expression as a parameter. If we want to learn more about lambdas, we can take a look at our tutorial Lambda Expressions and Functional Interfaces: Tips and Best Practices.

A stream by itself is worthless; the user is interested in the result of the terminal operation, which can be a value of some type or an action applied to every element of the stream. We can only use one terminal operation per stream.

The correct and most convenient way to use streams is by a stream pipeline, which is a chain of the stream source, intermediate operations, and a terminal operation:

```
List<String> list = Arrays.asList("abc1", "abc2", "abc3");
long size = list.stream().skip(1)
  .map(element -> element.substring(0, 3)).sorted().count();
```


### Lazy invocation

Intermediate operations are lazy. This means that they will be invoked only if it is necessary for the terminal operation execution.

For example, let's call the method wasCalled(), which increments an inner counter every time it's called:

```
private long counter;
 
private void wasCalled() {
    counter++;
}
```

Now let's call the method wasCalled() from operation filter():


```
List<String> list = Arrays.asList(“abc1”, “abc2”, “abc3”);
counter = 0;
Stream<String> stream = list.stream().filter(element -> {
    wasCalled();
    return element.contains("2");
});

```

As we have a source of three elements, we can assume that the filter() method will be called three times, and the value of the counter variable will be 3. However, running this code doesn't change counter at all, it is still zero, so the filter() method wasn't even called once. The reason why is missing of the terminal operation.

Let's rewrite this code a little bit by adding a map() operation and a terminal operation, findFirst(). We will also add the ability to track the order of method calls with the help of logging:


```
Optional<String> stream = list.stream().filter(element -> {
    log.info("filter() was called");
    return element.contains("2");
}).map(element -> {
    log.info("map() was called");
    return element.toUpperCase();
}).findFirst();
```

The resulting log shows that we called the filter() method twice and the map() method once. This is because the pipeline executes vertically. In our example, the first element of the stream didn't satisfy the filter's predicate. Then we invoked the filter() method for the second element, which passed the filter. Without calling the filter() for the third element, we went down through the pipeline to the map() method.

The findFirst() operation satisfies by just one element. So in this particular example, the lazy invocation allowed us to avoid two method calls, one for the filter() and one for the map().


