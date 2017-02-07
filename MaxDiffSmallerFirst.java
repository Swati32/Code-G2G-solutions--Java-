import java.util.Arrays;

public class MaxDiffSmallerFirst {
	public static int findMaxDiff(int[] arr){
		if(arr == null || arr.length<2) return 0;
		if(arr.length == 2 ){
			if(arr[0]<arr[1]) return (Math.abs(arr[1]-arr[0])); else return 0;
		}
		
		
		int min_so_far = arr[0];
		int max_diff =  0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>min_so_far) {
				int diff = Math.abs(arr[i]-min_so_far);
				if(diff>max_diff) max_diff = diff;
			}
			if(arr[i]<min_so_far) min_so_far = arr[i];
		}
		return max_diff;
	}
	
	public static void main(String[] arg){
        int[] arr = new int[]{7, 9, 5, 6, 3, 2 };
    	
    	int result = findMaxDiff(arr);
    	System.out.println(result);
	}
}
