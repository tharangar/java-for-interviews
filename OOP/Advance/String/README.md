
## Java String

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

![Objects class](heap.png?raw=true "Objects class")

Note: String objects are stored in a special memory area known as the "string constant pool".

In the above example, only one object will be created. Firstly, JVM will not find any string object with the value "Welcome" in string constant pool, that is why it will create a new object. After that it will find the string with the value "Welcome" in the pool, it will not create a new object but will return the reference to the same instance. 

### Why Java uses the concept of String literal?

To make Java more memory efficient (because no new objects are created if it exists already in the string constant pool). 

### 2) By new keyword

        String s=new String("Welcome");//creates two objects and one reference variable  