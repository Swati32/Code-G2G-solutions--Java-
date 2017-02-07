import java.util.Arrays;

public class TwoRepeating {
	public static int FindTwoRepeating(int[] arr){
		if(arr == null || arr.length <2) return 0;
		 
		                       
		 int next_index =0;
		 
		 while(arr[next_index] != 0){
			 int temp = arr[next_index];
			 arr[next_index]=0;
			 next_index =temp;
		 }
		
		return next_index;
	}

	public static void main(String[] arg){
    	int[] arr = new int[]{4, 2, 5, 5, 2, 3, 1};
    	
    	int result = FindTwoRepeating(arr);
    	System.out.println(result);
    }
}
