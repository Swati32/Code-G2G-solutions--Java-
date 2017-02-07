package Dynamic;

public class LongestIncreasingSubsequence {
    // Dynamic Relation
	// L[i] = max[L[j]+1] for all j from 0 to i-1
	//
	public static int findLIS(int[] arr){
		if(arr == null || arr.length==0 ){
			return 0;
		}else{
			int[] LIS = new int[arr.length];
			LIS[0] = 1;
			int maxLength = LIS[0];
			for(int i =1 ;i <arr.length ;i++){
				for(int j=i-1;j>=0;j--){
					if(arr[j]<arr[i] && LIS[j]+1>LIS[i]){
						LIS[i] = LIS[j]+1;
					}
				}
				maxLength = Math.max(maxLength, LIS[i]);
			}
			
			return maxLength;
		}	
	}
	public static void main(String[] arg){
		int[] arr ={3, 10, 2, 1, 20};
		System.out.println(findLIS(arr));
		int[] arr1 ={3, 2, 1, 0};
		System.out.println(findLIS(arr1));
		int[] arr2 ={50, 3, 10, 7, 40, 80};
		System.out.println(findLIS(arr2));
		int[] arr3 ={1,2,3,4};
		System.out.println(findLIS(arr3));
	}
}
