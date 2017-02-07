import java.util.ArrayList;

public class Leaders {
       public static ArrayList<Integer> FindLeaders(int[] arr){
    	   ArrayList<Integer> leaders =  new ArrayList<Integer>();
    	   int max_from_right = 0;
    	   for(int i=arr.length-1;i>=0;i--){
    		   
    		   if(arr[i]>max_from_right){
    			   leaders.add(arr[i]);
    			   max_from_right = arr[i];
    		   }
    	   }
    	   return leaders;
       }
       
       public static void main(String[] arg){
	    	int[] arr = new int[]{16, 17, 4, 3, 5, 2};
	    	ArrayList<Integer> result = FindLeaders(arr);
	    	System.out.println(result);
	 }
}
