import java.io.*;

public class myApp {

// Allocating static references
    static int k = 0;
    static int r = 0;
    static int c = 0;
    static int[][] array =new int[8][8];

    public static void main(String args[]) {



      for (int i = 0, l = args.length; i < l; i++) {
        String output = String.format("argv[%s]: %s", i, args[i]);
        System.out.println(output);
        try {
            File file = new File(args[i]);
            FileReader filereader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(filereader);
          
            String data;
            int rowcount = 0;
            while ((data = bufferedReader.readLine()) != null) {
              System.out.println(data);
              // get the file input to parameters and populate the array
              rowcount = rowcount +1;
              if(rowcount ==1){
                  k = Integer.parseInt(data);
              }else{

                getValue(data);
                
              }

              

            }
          
            filereader.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
          putOtherValue();
          printArray();
      }
    }

    static void getValue(String tem){

        // initiate fizz and buzz values and strings
        String[] parts = tem.split(" ");
        int no1 = Integer.parseInt(parts[0]); // 004
        int no2 = Integer.parseInt(parts[1]); // 034556
        putValue(no1, no2);
     }

    static void putValue(int r, int c){

        //Put the value to existing array
        /**
         Hear i have to develop the algorithem to search for existing element which is not 0
          
         */
        //array[r][c] = 1;

        // mark others an invalid
        for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
                //System.out.print(array[i][j] + ".");
                if(i==r && j ==c){
                    array[i][j] = 1;
                //if(array[i][j] != 3){
                //        array[r][c] = 1;
                }else{
                if(i==r){
                    array[i][j] = 3;
                    //System.out.println("inserted"+array[i][j]);
                }
                if(j==c){
                    array[i][j] = 3;
                }
                if((i-r) == (j-c)){
                    array[i][j] = 3;
                }
                
            }
			}
			//System.out.println("");
        }
        


    }

    static void putOtherValue(){

        //Put the value to existing array
        /**
         Hear i have to develop the algorithem to search for existing element which is not 0
          
         */
        //array[r][c] = 1;
          // mark others values
          for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
                //System.out.print(array[i][j] + ".");
                if(array[i][j] != 3){
                    //array[i][j] = 1;
                    putValue(i, j);
                }
            }
            
        }


    }

    static void printArray(){

        for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
                //System.out.print(array[i][j] + ".");
                if(array[i][j]==0){
                    System.out.print("."); 
                }else if(array[i][j]==1){
                    System.out.print("Q"); 
                }else{
                    System.out.print("."); 
                }
			}
			System.out.println("");
        }
        
        



    }


  }
  