import java.util.Arrays;

public class ProductArrayPuzzle {
       public static int[] product(int[] arr){
    	   if(arr == null || arr.length <2) return new int[]{0};
    	   int[] prod = new int[arr.length];
    	   if(arr.length ==2 ) {
    		   prod[0] = arr[1];
    		   prod[1] = arr[0];
    		   return prod;
    	   }
    	   
    	   int[] left = new int[arr.length];
    	   int[] right = new int[arr.length];
    	   
    	   left[0] = 1;
    	   right[arr.length-1] = 1; 
    	   
    	   for(int i=1;i<arr.length;i++)
    		   left[i] = left[i-1]*arr[i-1];
    	   
    	   for(int i=arr.length-2;i>=0;i--)
    		   right[i] = right[i+1]*arr[i+1];
    	   
    	   prod[0] = right[0];
    	   prod[arr.length-1] = left[arr.length-1];
    	   
    	   for(int i=1;i<arr.length-1;i++)
    		   prod[i] = left[i]*right[i];
    	   
    	   return prod;
       }
       
   	public static void main(String[] arg){
    	int[] arr = new int[]{10, 3, 5, 6, 2};
    	
    	int[] result = product(arr);
    	System.out.println(Arrays.toString(result));
    }
}
