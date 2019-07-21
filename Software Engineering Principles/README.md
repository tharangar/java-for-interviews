
## SOLID Principle

https://howtodoinjava.com/best-practices/5-class-design-principles-solid-in-java/


By Lokesh Gupta | Filed Under: Java Best practices

Classes are the building blocks of any java application. If these blocks are not strong, the building (i.e. application) is going to face the tough time in future. This essentially means that not so well-written can lead to very difficult situations when the application scope goes up or application faces certain design issues either in production or maintenance.

On the other hand, set of well designed and written classes can speed up the coding process by leaps and bounds, while reducing the number of bugs in comparison.

In this tutorial, We will discuss SOLID principles in Java with examples which are 5 most recommended design principles, we should keep in mind while writing our classes. They also form the best practices to be followed for designing our application classes.


    1.  S    Single Responsibility Principle
    2.  O    Open Closed Principle
    3.  L    Liskov's Substitution Principle
    4.  I    Interface Segregation Principle
    5.  D    Dependency Inversion Principle


### 1. Single Responsibility Principle

    One class should have one and only one responsibility

In other words, we should write, change and maintain a class for only one purpose. If it is model class then it should strictly represent only one actor/ entity. This will give us the flexibility to make changes in future without worrying the impacts of changes for another entity.

In given example, we have two classes Person and Account. Both have single responsibility to store their specific information. If we want to change state of Person then we do not need to modify the class Account and vice-versa.

Person.java

```
public class Person
{
    private Long personId;
    private String firstName;
    private String lastName;
    private String age;
    private List<Account> accounts;
}
```

Account.java

```
public class Account
{
    private Long guid;
    private String accountNumber;
    private String accountName;
    private String status;
    private String type;
}
```

### 2. Open Closed Principle

    Software components should be open for extension, but closed for modification

What does this mean?? This means that our classes should be designed such a way that whenever fellow developers wants to change the flow of control in specific conditions in application, all they need to extend our class and override some functions and that’s it.

For example, spring framework has class DispatcherServlet. This class acts as front controller for String based web applications. To use this class, we are not required to modify this class. All we need is to pass initialization parameters and we can extend it’s functionality the way we want.

```
public class HelloWorldAction extends Action
{
    @Override
    public ActionForward execute(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
                                throws Exception
    {
         
        //Process the request
 
    }
}
```

### 3. Liskov’s Substitution Principle

This principle is a variation of previously discussed open closed principle. It says:

    Derived types must be completely substitutable for their base types

It means that the classes fellow developer created by extending our class should be able to fit in application without failure. This requires the objects of your subclasses to behave in the same way as the objects of your superclass. This is mostly seen in places where we do run time type identification and then cast it to appropriate reference type.

For example, every book has an ISBN number which is in always a fixed display format. You can have separate representations of ISBN in database and UI. For this requirement, we may write property editor in such a way –

IsbnEditor.java

```
import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
import com.howtodoinjava.app.model.Isbn;
  
public class IsbnEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new Isbn(text.trim()));
        } else {
            setValue(null);
        }
    }
  
    @Override
    public String getAsText() {
        Isbn isbn = (Isbn) getValue();
        if (isbn != null) {
            return isbn.getIsbn();
        } else {
            return "";
        }
    }
}
```


### 4. Interface Segregation Principle

    Clients should not be forced to implement unnecessary methods which they will not use

Take an example. Developer Alex created an interface Reportable and added two methods generateExcel() and generatedPdf(). Now client ‘A’ wants to use this interface but he intend to use reports only in PDF format and not in excel. Will he be able to use the functionality easily?



### 5. Dependency Inversion Principle

    Depend on abstractions, not on concretions

In other words. we should design our software in such a way that various modules can be separated from each other using an abstract layer to bind them together.

The classical use of this principle of bean configuration in Spring framework.

In spring framework, all modules are provided as separate components which can work together by simply injected dependencies in other module. This dependency is managed externally in XML files.