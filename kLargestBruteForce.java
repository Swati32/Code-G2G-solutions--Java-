import java.util.Arrays;

public class kLargestBruteForce {
      public static int[] sortandreturn(int[] arr,int k){
    	  if(arr == null || arr.length<k) return arr;
    	  Arrays.sort(arr);
    	  int[] solution= new int[k];
    	  for(int i=0;i<k;i++) solution[i] = arr[arr.length-1-i];   //largest pucha tha smallest nahi
    	  return solution;
      }
      
      public static int[] bubblektimes(int[] arr,int k){
    	  if(arr == null || arr.length<k) return arr;
    	  
    	  for(int i=0;i<k;i++){
    		  int max = arr[i];
    		  int max_index =i;
    		  for(int j = i+1; j<arr.length;j++){ //braces bhul gai concentration kahan he ?
    			  if(arr[j]>max) {
    				  max=arr[j];
    				  max_index = j;
    			  }
    		  }  
    		  int temp = arr[i];
    		  arr[i] =max;
    		  arr[max_index]=temp;
    	  }
    	  
    	  int[] solution= new int[k];
    	  for(int i=0;i<k;i++) solution[i] = arr[i];
    	  return solution;
      }
      
  	public static void main(String[] arg){
    	int[] arr = new int[]{1,2,6,8,3,1};
    	
    	
    	int[] result = sortandreturn(arr,3);
    	System.out.println(Arrays.toString(result));
    	
    	result = bubblektimes(arr,3);
    	System.out.println(Arrays.toString(result));
 }
}
