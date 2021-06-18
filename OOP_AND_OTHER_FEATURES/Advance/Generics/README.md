
## Generics


Java Generic methods and generic classes enable programmers to specify, with a single method declaration, a set of related methods, or with a single class declaration, a set of related tpes, respectively.

Generics also provide compile-time type safety that allows programmers to catch invali types at compile time.

Using java Generic concept, we might write a generic mehtod for sorting an array of objects, then invoke the generic method with integer arrays, Double arrays, String arrays and so on, to sort the array elements.


### Generic Methods

1.  All generic method declarations have a type parameter section delimited by angle brackets (<and >) that precedes the method's return type ( < E > in the next example).

2.  Each type parameter section contains one or more type parameters seperated by commas. A type parameter, also known as a type variable, is an identifier that specifies a generic type name.

3.  The type parameters can be used declare the return tpe and act as placeholders for the tpes of the arguments passed to the generic method, which are known as actual type arguments.

4.  A generic method's body is declared like that of any other method. Note that type parameters can represent only refernce types, not primitive types (like int, double and char).


### Example

Following example illustrates how we can print an array of different type using a single Generic method −

```
Live Demo

public class GenericMethodTest {
   // generic method printArray
   public static < E > void printArray( E[] inputArray ) {
      // Display array elements
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
   }

   public static void main(String args[]) {
      // Create arrays of Integer, Double and Character
      Integer[] intArray = { 1, 2, 3, 4, 5 };
      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
      Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

      System.out.println("Array integerArray contains:");
      printArray(intArray);   // pass an Integer array

      System.out.println("\nArray doubleArray contains:");
      printArray(doubleArray);   // pass a Double array

      System.out.println("\nArray characterArray contains:");
      printArray(charArray);   // pass a Character array
   }
}

```


