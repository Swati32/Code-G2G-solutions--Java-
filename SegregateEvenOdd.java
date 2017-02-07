import java.util.Arrays;

public class SegregateEvenOdd {
	public static int[] evenodd(int[] arr){
		if(arr==null || arr.length<2) return arr;
		int left =0;
		int right = arr.length-1;
		while(left<right){
			if(arr[left]%2 == 0 && arr[right]%2 != 0){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right]= temp;
				left++;
				right--;
			}else if (arr[left]%2 != 0) left++;
			else if(arr[right]%2 == 0) right--;
		}
		return arr;
	}

	public static void main(String[] arg){
    	int[] arr = new int[]{1,1,0,1,1};
    	
    	int[] result = evenodd(arr);
    	System.out.println(Arrays.toString(result));
    }
}
