
## Java String

https://www.javatpoint.com/java-string


In Java, string is basically an object that represents sequence of char values. An array of characters works same as Java string. For example:

    char[] ch={'j','a','v','a','t','p','o','i','n','t'};  
    String s=new String(ch);  

is same as:

        String s="javatpoint";  

Java String class provides a lot of methods to perform operations on string such as compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring() etc.

The java.lang.String class implements Serializable, Comparable and CharSequence interfaces.

Java String class provides a lot of methods to perform operations on string such as compare(), concat(), equals(), split(), length(), replace(), compareTo(), intern(), substring() etc.

The java.lang.String class implements Serializable, Comparable and CharSequence interfaces.


### CharSequence Interface

The CharSequence interface is used to represent the sequence of characters. String, StringBuffer and StringBuilder classes implement it. It means, we can create strings in java by using these three classes.

#### *******************************

The Java String is immutable which means it cannot be changed. Whenever we change any string, a new instance is created. For mutable strings, you can use StringBuffer and StringBuilder classes.

#### *******************************

We will discuss immutable string later. Let's first understand what is String in Java and how to create the String object.

### What is String in java

Generally, String is a sequence of characters. But in Java, string is an object that represents a sequence of characters. The java.lang.String class is used to create a string object.
How to create a string object?

There are two ways to create String object:

    By string literal
    By new keyword

### 1) String Literal

Java String literal is created by using double quotes. For Example:

        String s="welcome";  

Each time you create a string literal, the JVM checks the "string constant pool" first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string doesn't exist in the pool, a new string instance is created and placed in the pool. For example: 

    String s1="Welcome";  
    String s2="Welcome";//It doesn't create a new instance  

![String heap](heap.png?raw=true "String heap")

Note: String objects are stored in a special memory area known as the "string constant pool".

In the above example, only one object will be created. Firstly, JVM will not find any string object with the value "Welcome" in string constant pool, that is why it will create a new object. After that it will find the string with the value "Welcome" in the pool, it will not create a new object but will return the reference to the same instance. 

### Why Java uses the concept of String literal?

To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool). 

### 2) By new keyword

        String s=new String("Welcome");//creates two objects and one reference variable  

In such case, JVM will create a new string object in normal (non-pool) heap memory, and the literal "Welcome" will be placed in the string constant pool. The variable s will refer to the object in a heap (non-pool). 

### Java String Example

```
    public class StringExample{  
    public static void main(String args[]){  
    String s1="java";//creating string by java string literal  
    char ch[]={'s','t','r','i','n','g','s'};  
    String s2=new String(ch);//converting char array to string  
    String s3=new String("example");//creating java string by new keyword  
    System.out.println(s1);  
    System.out.println(s2);  
    System.out.println(s3);  
    }}  

```

output

```
java
strings
example
```

### Java String class methods

The java.lang.String class provides many useful methods to perform operations on sequence of char values.

| No.	| Method	| Description |
| ------------- | ------------- | ------------- |
|1	| char charAt(int index)	returns char value for the particular index |
| 2	| int length()	| returns string length |
|3	| static String format(String format, Object... args)	| returns a formatted string. |
| 4	| static String format(Locale l, String format, Object... args)	| returns formatted string with given locale. |
| 5	| String substring(int beginIndex)	| returns substring for given begin index. |
| 6	| String substring(int beginIndex, int endIndex)	| returns substring for given begin index and end index. |
| 7	| boolean contains(CharSequence s)	| returns true or false after matching the sequence of char value. |
| 8	| static String join(CharSequence delimiter, CharSequence... elements)	| returns a joined string. |
| 9	| static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements)	| returns a joined string. |
| 10	| boolean equals(Object another)	| checks the equality of string with the given object. |
| 11	| boolean isEmpty()	| checks if string is empty. |
| 12	| String concat(String str)	| concatenates the specified string. |
| 13	| String replace(char old, char new)	| replaces all occurrences of the specified char value. |
| 14	| String replace(CharSequence old, CharSequence new)	| replaces all occurrences of the specified CharSequence. |
| 15	| static String equalsIgnoreCase(String another)	| compares another string. It doesn't check case. |
| 16	| String[] split(String regex)	| returns a split string matching regex. |
| 17	| String[] split(String regex, int limit)	| returns a split string matching regex and limit. |
| 18	| String intern()	| returns an interned string. |
| 19	| int indexOf(int ch)	| returns the specified char value index. |
| 20	| int indexOf(int ch, int fromIndex)	| returns the specified char value index starting with given index. |
| 21	| int indexOf(String substring)	| returns the specified substring index. |
| 22	| int indexOf(String substring, int fromIndex)	| returns the specified substring index starting with given index. |
| 23	| String toLowerCase()	| returns a string in lowercase. |
| 24	| String toLowerCase(Locale l)	| returns a string in lowercase using specified locale. |
| 25	| String toUpperCase()	| returns a string in uppercase. |
| 26	| String toUpperCase(Locale l)	| returns a string in uppercase using specified locale. |
| 27	| String trim()	| removes beginning and ending spaces of this string. |
| 28	| static String valueOf(int value)	| converts given type into string. It is an overloaded method. |


### Lets learn more

    Concept of String
    Immutable String
    String Comparison
    String Concatenation
    Concept of Substring
    String class methods and its usage
    StringBuffer class
    StringBuilder class
    Creating Immutable class
    toString() method
    StringTokenizer class


## Immutable String in Java

In java, string objects are immutable. Immutable simply means unmodifiable or unchangeable.

Once string object is created its data or state can't be changed but a new string object is created.

Let's try to understand the immutability concept by the example given below:

```
    class Testimmutablestring{  
     public static void main(String args[]){  
       String s="Sachin";  
       s.concat(" Tendulkar");//concat() method appends the string at the end  
       System.out.println(s);//will print Sachin because strings are immutable objects  
     }  
    }  
```

Output:Sachin

Now it can be understood by the diagram given below. Here Sachin is not changed but a new object is created with sachintendulkar. That is why string is known as immutable.


![String Immutability](immutable.png?raw=true "String Immutability")


 As you can see in the above figure that two objects are created but s reference variable still refers to "Sachin" not to "Sachin Tendulkar".

But if we explicitely assign it to the reference variable, it will refer to "Sachin Tendulkar" object.For example: 

```
    class Testimmutablestring1{  
     public static void main(String args[]){  
       String s="Sachin";  
       s=s.concat(" Tendulkar");  
       System.out.println(s);  
     }  
    }  
```

Output:Sachin Tendulkar

In such case, s points to the "Sachin Tendulkar". Please notice that still sachin object is not modified.

### Why string objects are immutable in java?
Because java uses the concept of string literal.Suppose there are 5 reference variables,all referes to one object "sachin".If one reference variable changes the value of the object, it will be affected to all the reference variables. That is why string objects are immutable in java. 

## Java String compare

We can compare string in java on the basis of content and reference.

It is used in authentication (by equals() method), sorting (by compareTo() method), reference matching (by == operator) etc.

There are three ways to compare string in java:

    By equals() method
    By = = operator
    By compareTo() method

### 1) String compare by equals() method

The String equals() method compares the original content of the string. It compares values of string for equality. String class provides two methods:

    public boolean equals(Object another) compares this string to the specified object.
    public boolean equalsIgnoreCase(String another) compares this String to another string, ignoring case.

```
    class Teststringcomparison1{  
     public static void main(String args[]){  
       String s1="Sachin";  
       String s2="Sachin";  
       String s3=new String("Sachin");  
       String s4="Saurav";  
       System.out.println(s1.equals(s2));//true  
       System.out.println(s1.equals(s3));//true  
       System.out.println(s1.equals(s4));//false  
     }  
    }  
```

Example 2

```
    class Teststringcomparison2{  
     public static void main(String args[]){  
       String s1="Sachin";  
       String s2="SACHIN";  
      
       System.out.println(s1.equals(s2));//false  
       System.out.println(s1.equalsIgnoreCase(s2));//true  
     }  
    }  
```

### 2) String compare by == operator

The = = operator compares references not values.

```
    class Teststringcomparison3{  
     public static void main(String args[]){  
       String s1="Sachin";  
       String s2="Sachin";  
       String s3=new String("Sachin");  
       System.out.println(s1==s2);//true (because both refer to same instance)  
       System.out.println(s1==s3);//false(because s3 refers to instance created in nonpool)  
     }  
    }  
```

### 3) String compare by compareTo() method

The String compareTo() method compares values lexicographically and returns an integer value that describes if first string is less than, equal to or greater than second string.

Suppose s1 and s2 are two string variables. If:

    s1 == s2 :0
    s1 > s2   :positive value
    s1 < s2   :negative value


```
    class Teststringcomparison4{  
     public static void main(String args[]){  
       String s1="Sachin";  
       String s2="Sachin";  
       String s3="Ratan";  
       System.out.println(s1.compareTo(s2));//0  
       System.out.println(s1.compareTo(s3));//1(because s1>s3)  
       System.out.println(s3.compareTo(s1));//-1(because s3 < s1 )  
     }  
    }  
```

## String Concatenation in Java

In java, string concatenation forms a new string that is the combination of multiple strings. There are two ways to concat string in java:

    By + (string concatenation) operator
    By concat() method


### 1) String Concatenation by + (string concatenation) operator

Java string concatenation operator (+) is used to add strings. For Example:

```
    class TestStringConcatenation1{  
     public static void main(String args[]){  
       String s="Sachin"+" Tendulkar";  
       System.out.println(s);//Sachin Tendulkar  
     }  
    }  
```

Output:Sachin Tendulkar

The Java compiler transforms above code to this:

    String s=(new StringBuilder()).append("Sachin").append(" Tendulkar).toString();  

In java, String concatenation is implemented through the StringBuilder (or StringBuffer) class and its append method. String concatenation operator produces a new string by appending the second operand onto the end of the first operand. The string concatenation operator can concat not only string but primitive values also. For Example:


```
class TestStringConcatenation2{  
 public static void main(String args[]){  
   String s=50+30+"Sachin"+40+40;  
   System.out.println(s);//80Sachin4040  
 }  
} 
```

output : 80Sachin4040


Note: After a string literal, all the + will be treated as string concatenation operator.

### 2) String Concatenation by concat() method

The String concat() method concatenates the specified string to the end of current string. Syntax: 

        public String concat(String another)  

Let's see the example of String concat() method.

```
    class TestStringConcatenation3{  
     public static void main(String args[]){  
       String s1="Sachin ";  
       String s2="Tendulkar";  
       String s3=s1.concat(s2);  
       System.out.println(s3);//Sachin Tendulkar  
      }  
    }  
```

output :  Sachin Tendulkar


## Substring in Java

A part of string is called substring. In other words, substring is a subset of another string. In case of substring startIndex is inclusive and endIndex is exclusive.

Note: Index starts from 0.

You can get substring from the given string object by one of the two methods:

    public String substring(int startIndex): This method returns new String object containing the substring of the given string from specified startIndex (inclusive).
    public String substring(int startIndex, int endIndex): This method returns new String object containing the substring of the given string from specified startIndex to endIndex.

In case of string:

    startIndex: inclusive
    endIndex: exclusive

Let's understand the startIndex and endIndex by the code given below.

```
    String s="hello";  
    System.out.println(s.substring(0,2));//he  
```

In the above substring, 0 points to h but 2 points to e (because end index is exclusive). 

### Example of java substring

```
    public class TestSubstring{  
     public static void main(String args[]){  
       String s="SachinTendulkar";  
       System.out.println(s.substring(6));//Tendulkar  
       System.out.println(s.substring(0,6));//Sachin  
     }  
    }  
```

output

```
Tendulkar
Sachin
```

## Java String class methods

The java.lang.String class provides a lot of methods to work on string. By the help of these methods, we can perform operations on string such as trimming, concatenating, converting, comparing, replacing strings etc.

Java String is a powerful concept because everything is treated as a string if you submit any form in window based, web based or mobile application.

Let's see the important methods of String class.

### Java String toUpperCase() and toLowerCase() method

The java string toUpperCase() method converts this string into uppercase letter and string toLowerCase() method into lowercase letter.

```
    String s="Sachin";  
    System.out.println(s.toUpperCase());//SACHIN  
    System.out.println(s.toLowerCase());//sachin  
    System.out.println(s);//Sachin(no change in original)  
```

### Java String trim() method

The string trim() method eliminates white spaces before and after string.

```
    String s="  Sachin  ";  
    System.out.println(s);//  Sachin    
    System.out.println(s.trim());//Sachin  
```

### Java String startsWith() and endsWith() method

```
    String s="Sachin";  
     System.out.println(s.startsWith("Sa"));//true  
     System.out.println(s.endsWith("n"));//true  
```

### Java String charAt() method

The string charAt() method returns a character at specified index.

```
    String s="Sachin";  
    System.out.println(s.charAt(0));//S  
    System.out.println(s.charAt(3));//h  
```

### Java String length() method

The string length() method returns length of the string.

```
    String s="Sachin";  
    System.out.println(s.length());//6  
```

### Java String intern() method

A pool of strings, initially empty, is maintained privately by the class String.

When the intern method is invoked, if the pool already contains a string equal to this String object as determined by the equals(Object) method, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.

```
    String s=new String("Sachin");  
    String s2=s.intern();  
    System.out.println(s2);//Sachin  
```

output : Sachin

### Java String valueOf() method

The string valueOf() method coverts given type such as int, long, float, double, boolean, char and char array into string.

```
    int a=10;  
    String s=String.valueOf(a);  
    System.out.println(s+10);  

```

output : 1010

### Java String replace() method

The string replace() method replaces all occurrence of first sequence of character with second sequence of character.

```
    String s1="Java is a programming language. Java is a platform. Java is an Island.";    
    String replaceString=s1.replace("Java","Kava");//replaces all occurrences of "Java" to "Kava"    
    System.out.println(replaceString);    
```

output : Kava is a programming language. Kava is a platform. Kava is an Island.


## Java StringBuffer class

Java StringBuffer class is used to create mutable (modifiable) string. The StringBuffer class in java is same as String class except it is mutable i.e. it can be changed.

Note: Java StringBuffer class is thread-safe i.e. multiple threads cannot access it simultaneously. So it is safe and will result in an order.

### Important Constructors of StringBuffer class

| Constructor	| Description |
| ------------- | ------------- |
| StringBuffer()	| creates an empty string buffer with the initial capacity of 16. |
| StringBuffer(String str)	| creates a string buffer with the specified string. |
| StringBuffer(int capacity)	| creates an empty string buffer with the specified capacity as length. |


### Important methods in StringBuffer class

There are many methods which is usefull for developments as describe in the javapoint tutorials.

https://www.javatpoint.com/StringBuffer-class

We will discuss some as follows.

### What is mutable string

A string that can be modified or changed is known as mutable string. StringBuffer and StringBuilder classes are used for creating mutable string.


### 1) StringBuffer append() method

The append() method concatenates the given argument with this string.

```
    class StringBufferExample{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer("Hello ");  
    sb.append("Java");//now original string is changed  
    System.out.println(sb);//prints Hello Java  
    }  
    }  
```

### 2) StringBuffer insert() method

The insert() method inserts the given string with this string at the given position.

```
class StringBufferExample2{  
public static void main(String args[]){  
StringBuffer sb=new StringBuffer("Hello ");  
sb.insert(1,"Java");//now original string is changed  
System.out.println(sb);//prints HJavaello  
}  
} 
```

### 3) StringBuffer replace() method

The replace() method replaces the given string from the specified beginIndex and endIndex.

```
    class StringBufferExample3{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer("Hello");  
    sb.replace(1,3,"Java");  
    System.out.println(sb);//prints HJavalo  
    }  
    }  
```

### 4) StringBuffer delete() method

The delete() method of StringBuffer class deletes the string from the specified beginIndex to endIndex.

```
    class StringBufferExample4{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer("Hello");  
    sb.delete(1,3);  
    System.out.println(sb);//prints Hlo  
    }  
    }  
```

5) StringBuffer reverse() method

The reverse() method of StringBuilder class reverses the current string.

```
    class StringBufferExample5{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer("Hello");  
    sb.reverse();  
    System.out.println(sb);//prints olleH  
    }  
    }  
```

### 6) StringBuffer capacity() method

The capacity() method of StringBuffer class returns the current capacity of the buffer. The default capacity of the buffer is 16. If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34. 

```
    class StringBufferExample6{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer();  
    System.out.println(sb.capacity());//default 16  
    sb.append("Hello");  
    System.out.println(sb.capacity());//now 16  
    sb.append("java is my favourite language");  
    System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    }  
    }  
```

### 7) StringBuffer ensureCapacity() method

The ensureCapacity() method of StringBuffer class ensures that the given capacity is the minimum to the current capacity. If it is greater than the current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34. 

```
    class StringBufferExample7{  
    public static void main(String args[]){  
    StringBuffer sb=new StringBuffer();  
    System.out.println(sb.capacity());//default 16  
    sb.append("Hello");  
    System.out.println(sb.capacity());//now 16  
    sb.append("java is my favourite language");  
    System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    sb.ensureCapacity(10);//now no change  
    System.out.println(sb.capacity());//now 34  
    sb.ensureCapacity(50);//now (34*2)+2  
    System.out.println(sb.capacity());//now 70  
    }  
    }  
```


## Java StringBuilder class

Java StringBuilder class is used to create mutable (modifiable) string. The Java StringBuilder class is same as StringBuffer class except that it is non-synchronized. It is available since JDK 1.5. 


### Important Constructors of StringBuilder class

| Constructor	| Description |
| ------------- | ------------- |
| StringBuilder()	| creates an empty string Builder with the initial capacity of 16. |
| StringBuilder(String str)	| creates a string Builder with the specified string. |
| StringBuilder(int length)	| creates an empty string Builder with the specified capacity as length. |

### Important methods of StringBuilder class


### 1) StringBuilder append() method

The StringBuilder append() method concatenates the given argument with this string. 

```
    class StringBuilderExample{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder("Hello ");  
    sb.append("Java");//now original string is changed  
    System.out.println(sb);//prints Hello Java  
    }  
    }  
```

### 2) StringBuilder insert() method

The StringBuilder insert() method inserts the given string with this string at the given position.

```
    class StringBuilderExample2{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder("Hello ");  
    sb.insert(1,"Java");//now original string is changed  
    System.out.println(sb);//prints HJavaello  
    }  
    }  
```

### 3) StringBuilder replace() method

The StringBuilder replace() method replaces the given string from the specified beginIndex and endIndex.

```
    class StringBuilderExample3{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder("Hello");  
    sb.replace(1,3,"Java");  
    System.out.println(sb);//prints HJavalo  
    }  
    }  
```

4) StringBuilder delete() method

The delete() method of StringBuilder class deletes the string from the specified beginIndex to endIndex.

```
    class StringBuilderExample4{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder("Hello");  
    sb.delete(1,3);  
    System.out.println(sb);//prints Hlo  
    }  
    }  
```

### 5) StringBuilder reverse() method

The reverse() method of StringBuilder class reverses the current string.

```
    class StringBuilderExample5{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder("Hello");  
    sb.reverse();  
    System.out.println(sb);//prints olleH  
    }  
    }  
```



### 6) StringBuilder capacity() method

The capacity() method of StringBuilder class returns the current capacity of the Builder. The default capacity of the Builder is 16. If the number of character increases from its current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34. 

```
    class StringBuilderExample6{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder();  
    System.out.println(sb.capacity());//default 16  
    sb.append("Hello");  
    System.out.println(sb.capacity());//now 16  
    sb.append("java is my favourite language");  
    System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    }  
    }  
```


### 7) StringBuilder ensureCapacity() method

The ensureCapacity() method of StringBuilder class ensures that the given capacity is the minimum to the current capacity. If it is greater than the current capacity, it increases the capacity by (oldcapacity*2)+2. For example if your current capacity is 16, it will be (16*2)+2=34. 

```
    class StringBuilderExample7{  
    public static void main(String args[]){  
    StringBuilder sb=new StringBuilder();  
    System.out.println(sb.capacity());//default 16  
    sb.append("Hello");  
    System.out.println(sb.capacity());//now 16  
    sb.append("java is my favourite language");  
    System.out.println(sb.capacity());//now (16*2)+2=34 i.e (oldcapacity*2)+2  
    sb.ensureCapacity(10);//now no change  
    System.out.println(sb.capacity());//now 34  
    sb.ensureCapacity(50);//now (34*2)+2  
    System.out.println(sb.capacity());//now 70  
    }  
    }  
```

## Difference between String and StringBuffer

| No.	| String	| StringBuffer |
| ------------- | ------------- | ------------- |
| 1)	| String class is immutable.	| StringBuffer class is mutable. |
| 2)	| String is slow and consumes more memory when you concat too many strings because every time it creates new instance.	| StringBuffer is fast and consumes less memory when you cancat strings. |
| 3)	| String class overrides the equals() method of Object class. So you can compare the contents of two strings by equals() method.	| StringBuffer class doesn't override the equals() method of Object class. |


### Performance Test of String and StringBuffer


```
    public class ConcatTest{  
        public static String concatWithString()    {  
            String t = "Java";  
            for (int i=0; i<10000; i++){  
                t = t + "Tpoint";  
            }  
            return t;  
        }  
        public static String concatWithStringBuffer(){  
            StringBuffer sb = new StringBuffer("Java");  
            for (int i=0; i<10000; i++){  
                sb.append("Tpoint");  
            }  
            return sb.toString();  
        }  
        public static void main(String[] args){  
            long startTime = System.currentTimeMillis();  
            concatWithString();  
            System.out.println("Time taken by Concating with String: "+(System.currentTimeMillis()-startTime)+"ms");  
            startTime = System.currentTimeMillis();  
            concatWithStringBuffer();  
            System.out.println("Time taken by Concating with  StringBuffer: "+(System.currentTimeMillis()-startTime)+"ms");  
        }  
    }  
```


output
    Time taken by Concating with String: 578ms
    Time taken by Concating with  StringBuffer: 0ms


### String and StringBuffer HashCode Test

As you can see in the program given below, String returns new hashcode value when you concat string but StringBuffer returns same.

```
    public class InstanceTest{  
        public static void main(String args[]){  
            System.out.println("Hashcode test of String:");  
            String str="java";  
            System.out.println(str.hashCode());  
            str=str+"tpoint";  
            System.out.println(str.hashCode());  
       
            System.out.println("Hashcode test of StringBuffer:");  
            StringBuffer sb=new StringBuffer("java");  
            System.out.println(sb.hashCode());  
            sb.append("tpoint");  
            System.out.println(sb.hashCode());  
        }  
    }  
```
Sample output:
```
Hashcode test of String:
3254818
229541438
Hashcode test of StringBuffer:
118352462
118352462
```

## Difference between StringBuffer and StringBuilder

Java provides three classes to represent a sequence of characters: String, StringBuffer, and StringBuilder. The String class is an immutable class whereas StringBuffer and StringBuilder classes are mutable. There are many differences between StringBuffer and StringBuilder. The StringBuilder class is introduced since JDK 1.5.

A list of differences between StringBuffer and StringBuilder are given below:


| No.	| StringBuffer	| StringBuilder |
| ------------- | ------------- | ------------- |
| 1)	| StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously.	| StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously. |
| 2)	| StringBuffer is less efficient than StringBuilder.	| StringBuilder is more efficient than StringBuffer. |

### Performance Test of StringBuffer and StringBuilder


```
    //Java Program to demonstrate the performance of StringBuffer and StringBuilder classes.  
    public class ConcatTest{  
        public static void main(String[] args){  
            long startTime = System.currentTimeMillis();  
            StringBuffer sb = new StringBuffer("Java");  
            for (int i=0; i<10000; i++){  
                sb.append("Tpoint");  
            }  
            System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");  
            startTime = System.currentTimeMillis();  
            StringBuilder sb2 = new StringBuilder("Java");  
            for (int i=0; i<10000; i++){  
                sb2.append("Tpoint");  
            }  
            System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");  
        }  
    }  
```

Sample output
    Time taken by StringBuffer: 16ms
    Time taken by StringBuilder: 0ms


## How to create Immutable class?  ******************

There are many immutable classes like String, Boolean, Byte, Short, Integer, Long, Float, Double etc. In short, all the wrapper classes and String class is immutable. We can also create immutable class by creating final class that have final data members as the example given below:

### Example to create Immutable class
In this example, we have created a final class named Employee. It have one final datamember, a parameterized constructor and getter method. 

```
    public final class Employee{  
    final String pancardNumber;  
      
    public Employee(String pancardNumber){  
    this.pancardNumber=pancardNumber;  
    }  
      
    public String getPancardNumber(){  
    return pancardNumber;  
    }  
      
    }  
```

### The above class is immutable because: ******

 1.   The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
    
 2.   The class is final so we cannot create the subclass.
    
 3.   There is no setter methods i.e. we have no option to change the value of the instance variable.

These points makes this class as immutable.


## Java toString() method 

If you want to represent any object as a string, toString() method comes into existence.

The toString() method returns the string representation of the object.

If you print any object, java compiler internally invokes the toString() method on the object. So overriding the toString() method, returns the desired output, it can be the state of an object etc. depends on your implementation.

### Advantage of Java toString() method

By overriding the toString() method of the Object class, we can return values of the object, so we don't need to write much code.


### Understanding problem without toString() method

Let's see the simple code that prints reference.

```
    class Student{  
     int rollno;  
     String name;  
     String city;  
      
     Student(int rollno, String name, String city){  
     this.rollno=rollno;  
     this.name=name;  
     this.city=city;  
     }  
      
     public static void main(String args[]){  
       Student s1=new Student(101,"Raj","lucknow");  
       Student s2=new Student(102,"Vijay","ghaziabad");  
         
       System.out.println(s1);//compiler writes here s1.toString()  
       System.out.println(s2);//compiler writes here s2.toString()  
     }  
    }  
```


Sample output :

Output:Student@1fee6fc
       Student@1eed786

As you can see in the above example, printing s1 and s2 prints the hashcode values of the objects but I want to print the values of these objects. Since java compiler internally calls toString() method, overriding this method will return the specified values. Let's understand it with the example given below:


### Example of Java toString() method

Now let's see the real example of toString() method.

```
    class Student{  
     int rollno;  
     String name;  
     String city;  
      
     Student(int rollno, String name, String city){  
     this.rollno=rollno;  
     this.name=name;  
     this.city=city;  
     }  
       
     public String toString(){//overriding the toString() method  
      return rollno+" "+name+" "+city;  
     }  
     public static void main(String args[]){  
       Student s1=new Student(101,"Raj","lucknow");  
       Student s2=new Student(102,"Vijay","ghaziabad");  
         
       System.out.println(s1);//compiler writes here s1.toString()  
       System.out.println(s2);//compiler writes here s2.toString()  
     }  
    }  
```
Output:101 Raj lucknow
       102 Vijay ghaziabad


## StringTokenizer in Java

The java.util.StringTokenizer class allows you to break a string into tokens. It is simple way to break string.

It doesn't provide the facility to differentiate numbers, quoted strings, identifiers etc. like StreamTokenizer class. We will discuss about the StreamTokenizer class in I/O chapter.
Constructors of StringTokenizer class

There are 3 constructors defined in the StringTokenizer class.

| Constructor	| Description |
| ------------- | ------------- | 
| StringTokenizer(String str)	| creates StringTokenizer with specified string. |
| StringTokenizer(String str, String delim)	| creates StringTokenizer with specified string and delimeter. |
| StringTokenizer(String str, String delim, boolean returnValue)	|creates StringTokenizer with specified string, delimeter and returnValue. If return value is true, delimiter characters are considered to be tokens. If it is false, delimiter characters serve to separate tokens. |


### Methods of StringTokenizer class

The 6 useful methods of StringTokenizer class are as follows:

| Public method	| Description |
| ------------- | ------------- | 
| boolean hasMoreTokens()	| checks if there is more tokens available. |
| String nextToken()	| returns the next token from the StringTokenizer object. |
| String nextToken(String delim)	| returns the next token based on the delimeter. |
| boolean hasMoreElements()	| same as hasMoreTokens() method. |
| Object nextElement()	| same as nextToken() but its return type is Object. |
| int countTokens()	| returns the total number of tokens. |


### Example of nextToken(String delim) method of StringTokenizer class

```
    import java.util.*;  
      
    public class Test {  
       public static void main(String[] args) {  
           StringTokenizer st = new StringTokenizer("my,name,is,khan");  
            
          // printing next token  
          System.out.println("Next token is : " + st.nextToken(","));  
       }      
    }  
```

Output:Next token is : my

StringTokenizer class is deprecated now. It is recommended to use split() method of String class or regex (Regular Expression).



## Java String FAQs or Interview Questions



