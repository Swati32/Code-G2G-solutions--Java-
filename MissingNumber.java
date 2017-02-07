
public class MissingNumber {
	public static int MissingNumbers(int[] arr){
		
		int size= (arr.length)+1;
		int sum = size*(size+1)/2;
		int sum_arr=0;
		for(int i=0;i<arr.length;i++){
			sum_arr+=arr[i];
		}
		
		return (sum-sum_arr);
	}
	
	public static void main(String[] arg){
		int[] arr= new int[] {1,2,3,5};
		//System.out.println(majorityBrute(arr));
		System.out.println(MissingNumbers(arr));
		
	}

}
