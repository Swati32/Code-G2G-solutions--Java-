import java.util.Arrays;

public class TwoSumClosest {
	
	public static int[] FindTwoSumClosest(int[] arr,int target){
		int[] result =  new int[2];
		if(arr == null || arr.length==0) return result;
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		int min_diff = Integer.MAX_VALUE;
		while(i<j){
			int sum = arr[i]+arr[j];
			if(Math.abs(target-sum)<min_diff){
				result[0]=arr[i];
				result[1]=arr[j];
				min_diff = Math.abs(target-sum);
			}
			if(sum == target) return result;
			if(sum>target) j--;
			else i++;
		}
		
		return result;
	}
	
	public static void main(String[] arg){
    	int[] arr = new int[]{1,1,1,0,3,-3,1,1,1};
    	int d = 0;
    	int[] result = FindTwoSumClosest(arr,d);
    	System.out.println(Arrays.toString(result));
    }
	
	

}
