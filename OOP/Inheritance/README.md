Inheritance

<P>
Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another. With the use of inheritance the information is made manageable in a hierarchical order.

The class which inherits the properties of other is known as subclass (derived class, child class) and the class whose properties are inherited is known as superclass (base class, parent class).
</p>

extends is the keyword used to inherit the properties of a class. Following is the syntax of extends keyword.

```
class Super {
   .....
   .....
}
class Sub extends Super {
   .....
   .....
}


```

<h3>
Sample Code

Following is an example demonstrating Java inheritance. In this example, you can observe two classes namely Calculation and My_Calculation.

Using extends keyword, the My_Calculation inherits the methods addition() and Subtraction() of Calculation class.

Copy and paste the following program in a file with name My_Calculation.java
</h3>