import java.util.Arrays;

public class MaximumProductSubarray {
            // whats important ?
	        // a way to handle 0,keep track of continuos positive sum till this point
	        // keep trck of maximum negative sum till point.How do you do it ?
	        // at each element you check if element is positive or negative
	        //positive - good , multiply with positive , comapre with global max and update it 
	        //negative - you wanna check negative till now ,if its positive update it with max positive uptil now into this element
	        // plus since you are breaking the continuos positive sum set it to 1
	        // if its not muliply it with current element and positive sum,check with global and set negative till now to 1
	         //cause now you are already accounting for it in postive sum
	        //
	       
	public static int findMaxProduct(int[] arr){
		if(arr == null || arr.length ==0 ) return 0;
		if(arr[0]==0) return 0;
		int max = Integer.MIN_VALUE;
		int max_pos = (arr[0]>0)?arr[0]:1;
		int max_neg = (arr[0]<0)?arr[0]:1;
		
		
		for(int i=1;i<arr.length;i++){
			if(arr[i]==0) {          
				max_pos=1;
				max_neg=1;
			}else if(arr[i]>0) {
				max_pos = max_pos*arr[i];
				max = Math.max(max_pos, max);
			}
			else {
				if(max_neg * arr[i] >0) {
					max_pos = arr[i] * max_neg *max_pos;
					max = Math.max(max_pos, max);
					max_neg=1;
				}else{
					max_neg = arr[i]*max_pos;
					max_pos=1;
				}
			}
		}
		
		return (max>arr[0]?max:arr[0]);
	}
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {12, 2, -3, -5, -6, -2};
		int result = findMaxProduct(arr1);
		System.out.println(result);
	}
}
