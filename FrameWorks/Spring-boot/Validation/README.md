## Validation




1. Bean Validation API.

This method is used for specially for form validation. JSR03


@NotNull
@Email
@Min
@Future
@Past

anotations are come with ano


@NotNull(message="Pincode cant be null")
private Integer pincode;


@Min(value = 5 , message = "age cant be less than 5")
private int age;

@Past(message = "DOB shoudl be past date")
private Date dob;
alaways should be a past value

@Future
Allways should be a future value


@Email
for emails

But suppose you have to implement a validation like bellow. How to do this.
If you want a validation as phone number should be only 10 digits.

JSR 303/349/380  are already available anotation API.



There are many ways to validate Entities in Spring Boot projects.


https://www.baeldung.com/javax-bigdecimal-validation

In the tutorial Java Bean Validation Basics, we saw how to apply basic javax validation to various types, and in this tutorial, we'll focus on using javax validation with BigDecimal.

Unfortunately, with BigDecimal, we can't use the classic @Min or @Max javax annotations.

Luckily, we have a dedicated set of annotations for working with them:

    @DecimalMin

    @Digits
    @DecimalMax

BigDecimal is the first choice for financial calculation because of its high precision.

Let's see our Invoice class, which has a field of type BigDecimal:


```
public class Invoice {
	 
	    @DecimalMin(value = "0.0", inclusive = false)
	    @Digits(integer=3, fraction=2)
	    private BigDecimal price;
	    private String description;
	 
	    public Invoice(BigDecimal price, String description) {
	        this.price = price;
	        this.description = description;
	    }
	}

```

### @DecimalMin

The annotated element must be a number whose value is higher or equal to the specified minimum. @DecimalMin has an attribute inclusive that indicates whether the specified minimum value is inclusive or exclusive.


### @DecimalMax

@DecimalMax is the counterpart of @DecimalMin. The annotated element must be a number whose value is lower or equal to the specified maximum. @DecimalMax has an inclusive attribute that specifies whether the specified maximum value is inclusive or exclusive.

Also, @Min and @Max accept long values only. In @DecimalMin and @DecimalMax, we can specify the value in string format, which can be of any numeric type.


### @Digits

In many cases, we need to validate the number of digits in the integral part and fraction part of a decimal number.

The @Digit annotation has two attributes, integer and fraction, for specifying the number of allowed digits in the integral part and fraction part of the number.

As per the official documentation, integer allows us to specify the maximum number of integral digits accepted for this number. But this is true only for non-decimal numbers. For decimal numbers, it checks the exact number of digits in an integral part of the number. We will see this in our test case.

Similarly, the fraction attribute allows us to specify the maximum number of fractional digits accepted for this number.









## Hibernate Bean Validation API provide more anotaions like this.

@NotBlank(message = "Cant be nul")


But to do above matter we wants a custome validation anotation using Bean validation API.

phone no must be 10 digits.
only allow digits
do not allow nulls

above things can be done by customer validation or custom anotation.



Ex : You want to create age validator and share it among other developpers.
```
@AgeValidator(lower =30, upper =40, message = " Age should be between 30 and 40))
private int age;
```

First create anotation
When you have defined anotation default values those will apply when user has not introduce them.
@RETENTION means when this should work or retain. Actually Retention policy. if it is SOURCE it will be work only in compile time. If it is so it wil work only in compile time. Ex @OVERRIDE anotation has Retention policy SOURCE and it works only in compile time.

@TARGET anotation uses fro ElementType Enum it has many ENUMS like Contructor, Methods, PACKAGE, FIELD etc.
So you can use anotation defferennt classes, methods, and fielsds etc.

Now we have to write bussiness logic for this anotation. For that we have to write a class. Ex AgeValidaitonConstraints.java We provide this class name in @CONSTRAINT(VALIDATEDBY = AGEVALIDATIONCONSTRAINT.CLASS)

```
@CONSTRAINT(VALIDATEDBY = AGEVALIDATIONCONSTRAINT.CLASS)
@Target
@RETENTION(RUNTIME)
@interface AgeValidator
{

int lover() default 18;

int upper() default 60;

String message() default "age should be between 18 -60";

}



Class AgeValidatorConstaint
{
    // Write your validatin code

}

```

It is good to get good understanding on these items by looking at how those things are implemented in Hiberneate been validation and anotation apis. Sometime we can see using preperty files to store these values.




