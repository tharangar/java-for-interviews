




public class SpringDemo {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class){

            Alean a1 = context.getBean(Alien.class);
            a1.show();
        }
    }
}