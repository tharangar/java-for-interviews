
## AOP (Aspect Oriented Programming)




### Detailed AOP background.

https://www.javatpoint.com/spring-aop-aspectj-annotation-example



### Simple approach with spring AOP.

https://www.youtube.com/watch?v=Ft29HgsePfQ

https://www.youtube.com/watch?v=Og9Fyew8ltQ




AOP support OOP and above mentioned classes are coded as example in this lesson. It is not included all requied Spring libry classes. But essential source classes included hear.

![AOP- Approach](aop-2.PNG?raw=true "AOP- Approach")

Starter class is SpringDemo.java.


```

public class SpringDemo {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class){

            Alean a1 = context.getBean(Alien.class);
            a1.show();
        }
    }
}

```

Hear It has defined "AppConfig" for configuration and "Alean" for bussness logic.  So lets implement those two classes.

AppConfig.java
Spring can do configuration xml based, anotanation based or java based. Hear we are using java based configurations.
This AppConfig.java should have @Configuration anotanation and we should give which folder is used to find component
 @ComponentScan  anotanation. Rest of the configuration will do automatically by this file by Spring.

```

@Configuration
@ComponentScan("springdemo")
public class AppConfig{

    
}

```

Next is our busseness logic implementation class Alean.java . It just simpley printing Hellow World in the console.

```
@Component
public class Alien {
    public void show(){

        System.out.println("Hellow World");
        
    }
}
```

But suppose we want to print log before the method call .  You have to do it in the all methods in your applicaition. So it will diviate you from the bussness logic implementaiton. So AOP comes to sortout this issue. What AOP provide us is to 
we can just concentrate on bussness logic rest task will be done by the AOP mechanism. As a example we just want to consider only the " System.out.println("Hellow World");" line and rest befor or after the bussness logic can be handed over to AOP component.

As a example lets create new component "AopAgent" to handle these tasks which are not included in bussenss logic.

```


@Compoenent
@Aspect
@EnableAspectJAutoProxy
public class AopAgent{

    @Before("execution(public void show())")
    public void log(){
        System.out.println("logging the task")
    }
}

```

AspectJ will support to implement this concept. AOP is a supplement (Support) for OOP. @Aspect anotation will have all anotation requied for AOP. We call Aspect for all cross cutting concerns. 
Advice is another jargon which is used in AOP. sample Advices are Before and After. This means when it should be exicuted.
We can provide Advice with a pointcut. pointcut is when or where it should be exicuted. In our example it is show() mehtod.

So we provide the advice and pointcut as follows.

```
@Before("execution(public void show())")
```

By default AOP is not enabled so you have to use "@EnableAspectJAutoProxy" anotation also.


### Advance concepts of AOP

https://www.youtube.com/watch?v=Og9Fyew8ltQ

Hear we will disucuss some AOP jargons deeply and above viedo give better sample for AOP.

https://github.com/in28minutes/spring-master-class

https://github.com/in28minutes/spring-master-class/tree/master/03-spring-aop

https://github.com/in28minutes/spring-master-class/blob/master/03-spring-aop/Step03.md

Above sample has advance features of AOP. Some of jargons are described hear.

### Aspect
Aspect is the concernt that we are trying to implement generally. ex : logging (What we want to do).
Spring AOP is good enough to intercept method level programming. But if you want field level you have to program with 
AspectJ

// Follwing libries are requied :
spring-aop-4.1.6 ...
spring-aspects-4. ***
aspectjveaver-1.8 ***

### Pointcut
An expression which determines when and what and what are the method to be intercpeted.

```
//What kind of method calls I would intercept
//execution(* PACKAGE.*.*(..))
	
	@Before("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
```
Hear pointcut is all mehtods in following service.

"com.in28minutes.spring.aop.springaop.business.*.*(..)".

and before it start to exicute .

### Advice
What are the actions to be taken when the pointcut is met.

Above those terminologies are static or compile time parameters.

Now check matters related to runtime.

### joinpoint

Joinpoint is what receive when the method is excecuting. It is runtime what the aspect receive.


### Weaving

Entire process of above we discussed is called weaving.

![AOP](aop.PNG?raw=true "AOP")


![AOP](aop-core.PNG?raw=true "AOP")







### For a deepa understanding.

https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html