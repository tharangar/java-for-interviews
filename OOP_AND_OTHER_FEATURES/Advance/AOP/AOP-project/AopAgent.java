
@Compoenent
@Aspect
@EnableAspectJAutoProxy
public class AopAgent{

    @Before("execution(public void show())")
    public void log(){
        System.out.println("logging the task")
    }
}