import java.util.Arrays;

public class FindClosestFromTwoSortedArrays {

	public static int[] findtheClosestPair(int[] arr1,int[] arr2, int target){
		int[] result = new int[2];
		if(arr1 ==null || arr2 ==null ||arr1.length==0||arr2.length==0) return result;
		int min  = Integer.MAX_VALUE;
		
		int i =0;
		int j= arr2.length-1;
		
		while(i<arr1.length && j>=0){ // and ki jagah or lagaya tha
			int sum = arr1[i] +arr2[j];
			int diff = target-sum;
			if(Math.abs(diff)<min){
				result[0] = arr1[i];
				result[1] = arr2[j];
				min = Math.abs(diff); //min reset hi nai kia
			}
			if(diff>0) i++;else j--;     // else lagana bhul gai
		}
		
		return result;
	}
	
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {1, 4, 5, 7};
		int[] arr2 =  new int[] {10, 20, 30, 40};
		int target =  32;
		int[] result = findtheClosestPair(arr1,arr2,target);
		System.out.println(Arrays.toString(result));
	}
}
