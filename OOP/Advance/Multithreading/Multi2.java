class Multi2 implements Runnable{  
public void run(){  
System.out.println("Runnable implemented thread is running...");  
}  
  
public static void main(String args[]){  
Multi2 m1=new Multi2();  
Thread t1 =new Thread(m1);  
t1.start();  
 }  
} 
