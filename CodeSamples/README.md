
### Base 64 conversion
```
import org.apache.commons.codec.binary.Base64;

// Encode data on your side using BASE64
byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
System.out.println("encoded value is " + new String(bytesEncoded));

// Decode data on other side, by processing encoded data
byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
System.out.println("Decoded value is " + new String(valueDecoded));
```

option 2



Java 8 now supports BASE64 Encoding and Decoding. You can use the following classes: java.util.Base64, java.util.Base64.Encoder and java.util.Base64.Decoder.

Example usage:
```
// encode with padding
String encoded = Base64.getEncoder().encodeToString(someByteArray);

// encode without padding
String encoded = Base64.getEncoder().withoutPadding().encodeToString(someByteArray);

// decode a String
byte [] barr = Base64.getDecoder().decode(encoded); 

```


## Customer Exception Hanling


Define it.

```

package biz.nable.sb.cor.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import biz.nable.sb.cor.common.utility.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public RecordNotFoundException(String message) {
		super(message);
		this.errorCode = ErrorCode.UNKNOWN_ERROR;
	}

	public RecordNotFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public RecordNotFoundException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

}

```


Then it can be thrown from other methods.


```

		} else {
			String msg = messageSource.getMessage(ErrorCode.NO_TEMP_RECORD_FOUND, null,
					LocaleContextHolder.getLocale());
			logger.error(msg);
			throw new RecordNotFoundException(msg, ErrorCode.NO_TEMP_RECORD_FOUND);
		}

```



## Beanutil copy object to another.

https://www.baeldung.com/apache-commons-beanutils


If you want to copy from searchContent to content, then code should be as follows

```
BeanUtils.copyProperties(content, searchContent);
```

You need to reverse the parameters as above in your code.

From API,

```
public static void copyProperties(Object dest, Object orig)
                           throws IllegalAccessException,
                                  InvocationTargetException)
```

Parameters


    dest - Destination bean whose properties are modified

    orig - Origin bean whose properties are retrieved

Just a note for sanity's sake... Apache and Spring both have a BeanUtils class with a copyProperties method and they accept their parameters in opposite order. Apache's is BeanUtils.copyProperties(target, source) and Spring's is BeanUtils.copyProperties(source,target).

You can also trace the method of copyProperties and it should show you the param order, source vs target. This is for spring, public static void copyProperties(java.lang.Object source, java.lang.Object target)


Sample :

```
	public EpfEtfRequestHistory convertToEPFETFRequestToHistory(EpfEtfRequest epfetfRequest) {

		EpfEtfRequestHistory epfetfHistoryEntity = new EpfEtfRequestHistory();

		// copy workflow selection basic data tothe history table.
		try {
			// if there is no this new converter registraion errors may occure when data
			// values are trying to convert to null.
			java.util.Date defaultValue = null;
			Converter converter = new DateConverter(defaultValue);
			BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
			beanUtilsBean.getConvertUtils().register(converter, java.util.Date.class);
			beanUtilsBean.copyProperties(epfetfHistoryEntity, epfetfRequest);
	
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		// create the full object to a map and set to the payloand.
		//groupHistory.setRequestPayload(commonConverter.pojoToMap(groups));

		return epfetfHistoryEntity;

	}

```

Further Refference : https://www.baeldung.com/apache-commons-beanutils



## Java String conversion to date in defferent formats


Java 8 update

If you happen to be on Java 8 or newer, then use DateTimeFormatter (also here, click the link to see all predefined formatters and available format patterns; the tutorial is available here). This new API is inspired by JodaTime.


```
String string = "January 2, 2010";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
LocalDate date = LocalDate.parse(string, formatter);
System.out.println(date); // 2010-01-02

```

Note: if your format pattern happens to contain the time part as well, then use LocalDateTime#parse(text, formatter) instead of LocalDate#parse(text, formatter). And, if your format pattern happens to contain the time zone as well, then use ZonedDateTime#parse(text, formatter) instead.

Here's an extract of relevance from the javadoc, listing all available format patterns:


Symbol  Meaning                     Presentation  Examples
------  --------------------------  ------------  ----------------------------------------------
G       era                         text          AD; Anno Domini; A
u       year                        year          2004; 04
y       year-of-era                 year          2004; 04
D       day-of-year                 number        189
M/L     month-of-year               number/text   7; 07; Jul; July; J
d       day-of-month                number        10

Q/q     quarter-of-year             number/text   3; 03; Q3; 3rd quarter
Y       week-based-year             year          1996; 96
w       week-of-week-based-year     number        27
W       week-of-month               number        4
E       day-of-week                 text          Tue; Tuesday; T
e/c     localized day-of-week       number/text   2; 02; Tue; Tuesday; T
F       week-of-month               number        3

a       am-pm-of-day                text          PM
h       clock-hour-of-am-pm (1-12)  number        12
K       hour-of-am-pm (0-11)        number        0
k       clock-hour-of-am-pm (1-24)  number        0

H       hour-of-day (0-23)          number        0
m       minute-of-hour              number        30
s       second-of-minute            number        55
S       fraction-of-second          fraction      978
A       milli-of-day                number        1234
n       nano-of-second              number        987654321
N       nano-of-day                 number        1234000000

V       time-zone ID                zone-id       America/Los_Angeles; Z; -08:30
z       time-zone name              zone-name     Pacific Standard Time; PST
O       localized zone-offset       offset-O      GMT+8; GMT+08:00; UTC-08:00;
X       zone-offset 'Z' for zero    offset-X      Z; -08; -0830; -08:30; -083015; -08:30:15;
x       zone-offset                 offset-x      +0000; -08; -0830; -08:30; -083015; -08:30:15;
Z       zone-offset                 offset-Z      +0000; -0800; -08:00;


Do note that it has several predefined formatters for the more popular patterns. So instead of e.g. DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);, you could use DateTimeFormatter.RFC_1123_DATE_TIME. This is possible because they are, on the contrary to SimpleDateFormat, thread safe. You could thus also define your own, if necessary.

For a particular input string format, you don't need to use an explicit DateTimeFormatter: a standard ISO 8601 date, like 2016-09-26T17:44:57Z, can be parsed directly with LocalDateTime#parse(text) as it already uses the ISO_LOCAL_DATE_TIME formatter. Similarly, LocalDate#parse(text) parses an ISO date without the time component (see ISO_LOCAL_DATE), and ZonedDateTime#parse(text) parses an ISO date with an offset and time zone added (see ISO_ZONED_DATE_TIME).

-->  Answer 15 : 
https://stackoverflow.com/questions/4216745/java-string-to-date-conversion



## Hibernate and quering

### Criteria Builder 

Combining JPA And/Or Criteria Predicates.

The JPA Criteria API can be used to easily add multiple AND/OR conditions when querying records in a database.

With predicates

https://www.baeldung.com/jpa-and-or-criteria-predicates

In this tutorial, we used the JPA Criteria API to implement use cases where we needed to combine AND/OR predicates.

As usual, the complete source code used for this tutorial is over on GitHub.

1. Overview

The JPA Criteria API can be used to easily add multiple AND/OR conditions when querying records in a database. In this tutorial, we'll explore a quick example of JPA criteria queries that combine multiple AND/OR predicates.

If you're not familiar with predicates, we suggest reading about the basic JPA criteria queries first.

For our examples, we'll consider an inventory of Item entities, each having an id, name, color, and grade:

```
@Entity
public class Item {

    @Id
    private Long id;
    private String color;
    private String grade;
    private String name;
    
    // standard getters and setters
}
```

3. Combining Two OR Predicates Using an AND Predicate

Let's consider the use case where we need to find items having both:

    red or blue color
    AND
    A or B grade

We can easily do this using JPA Criteria API's and() and or() compound predicates.

To begin, let's set up our query:

```
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
Root<Item> itemRoot = criteriaQuery.from(Item.class);
```

Now, we'll need to build a Predicate to find items having a blue or a red color:

```
Predicate predicateForBlueColor
  = criteriaBuilder.equal(itemRoot.get("color"), "blue");
Predicate predicateForRedColor
  = criteriaBuilder.equal(itemRoot.get("color"), "red");
Predicate predicateForColor
  = criteriaBuilder.or(predicateForBlueColor, predicateForRedColor);
```


