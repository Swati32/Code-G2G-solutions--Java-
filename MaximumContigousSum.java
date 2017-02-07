
public class MaximumContigousSum {
	public static int kadane(int[] arr){
		int result = 0;
		if(arr == null || arr.length ==0)
			return result;
		
		int count_neg =0;
		int max_neg = Integer.MIN_VALUE;
		int max_sum = 0;
		int sum_till_here =0;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i]<0) {
				count_neg++;
				if(arr[i]>max_neg) max_neg = arr[i];
			}
			
			sum_till_here += arr[i];
			if(sum_till_here>0){
				if(sum_till_here>max_sum)
					max_sum= sum_till_here;
			}else{
				sum_till_here = 0;
			}
		}
		
		if(count_neg==arr.length) 
			result= max_neg;
		else	
			result= max_sum;
		
		return result;
		
	}
	
	public static void main(String[] arg){
		int[] arr= new int[] {-2, -3,-3};
		//System.out.println(majorityBrute(arr));
		System.out.println(kadane(arr));
		
	}

}
