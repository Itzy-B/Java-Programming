import java.util.Arrays;

    public class ILoveArrays {
        public static void main(String[] args) {
      
         int[] array = { 1, 4, 3, 6, 8, 2, 5};
         int what = array[0];
         
          
         for (int i=0; i < array.length; i++ )
         { 
             if ( array[i] > what )   
               what = array[i];  
         }
         System.out.println(what); 
      
      
      }
   }
 
   


