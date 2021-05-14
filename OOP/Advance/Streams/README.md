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