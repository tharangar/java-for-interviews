
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


Further Refference : https://www.baeldung.com/apache-commons-beanutils