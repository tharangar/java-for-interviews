
//public class fizzbuzz {

    public class App {
    // Static references for parameter  name changes
    static String fizz = "Fizz";
    static String buzz = "Buzz";
    
    static int fizzNo = 3;
    static int buzzNo = 5;

    static String[] names ;
    static int[] values;


    public static void main(String args[]) {
        //System.out.println(args[0]);
        //System.out.println(args[1]);
      int value = 0;

      

      for (int i = 0, l = args.length; i < l; i++) {
        //String output = String.format("argv[%s]: %s", i, args[i]);
        //System.out.println(output);

        // Extract the fizz parameters
        if(i == 0){

            fizz(args[i]);

        }
        // Extract the buzz parameters
        if(i == 1){

            buzz(args[i]);

        }

        // Extract the value 
        if(i == args.length-1){

            value = Integer.parseInt(args[i]);

        } else{

            duzz(args[i],i);
        }
        
      }

 
        // Extracting the final values and print it out
        //String tem = fizzbuzz(value);
        String tem = fizzbuzzAll(value);
        System.out.println(tem);

   

    }
    /** 
    static String fizzbuzz(int num) {
        if (num % 15 == 0) return "FizzBuzz";
        if (num % 5 == 0) return "Buzz";
        if (num % 3 == 0) return "Fizz";
        return String.valueOf(num);
      }
    **/


     // Assigingin fizz name and value to static reffernces 
      static void fizz(String tem){

         // initiate fizz and buzz values and strings
         String[] parts = tem.split(":");
         fizzNo = Integer.parseInt(parts[0]); // 004
         fizz = parts[1]; // 034556
 
      }

      // Assigining buzz names and values to static refferences
      static void buzz(String tem){

        // initiate fizz and buzz values and strings
        String[] parts = tem.split(":");
        buzzNo = Integer.parseInt(parts[0]); // 004
        buzz = parts[1]; // 034556

     }

      // Assigining buzz names and values to static refferences
      static void duzz(String tem, int val){

        // initiate fizz and buzz values and strings
        String[] parts = tem.split(":");
        //buzzNo = Integer.parseInt(parts[0]); // 004
        values[val] = Integer.parseInt(parts[0]); 
        //buzz = parts[1]; // 034556
        names[val] = parts[1];
     }


     // fizzbuzz mentod to work with dynamic static reffernces
      static String fizzbuzz(int num) {
        String fizzbuzz = fizz+""+buzz;
        int fizzbuzzNo = fizzNo * buzzNo;
        
        if (num % fizzbuzzNo == 0) return fizzbuzz;
        if (num % buzzNo == 0) return buzz;
        if (num % fizzNo == 0) return fizz;
        return String.valueOf(num);
      }

           // fizzbuzz mentod to work with dynamic static reffernces
           static String fizzbuzzAll(int num) {
            String fizzbuzz ="";
            int fizzbuzzNo = 1;
            String resultNo="";
            
            for (int i = 0, l = names.length; i < l; i++) {
                
                fizzbuzz = fizzbuzz+names[i];
                fizzbuzzNo = fizzbuzzNo * values[i];

            }  

            for (int i = 0, l = names.length; i < l; i++) {
                if (num % fizzbuzzNo == 0) resultNo = fizzbuzz;
                if (num % values[i] == 0) resultNo = names[i];
                //if (num % buzzNo == 0) return buzz;
                //if (num % fizzNo == 0) return fizz;
                

            }   

            return String.valueOf(resultNo);

          }

  }