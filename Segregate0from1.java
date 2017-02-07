import java.util.Arrays;

public class Segregate0from1 {

	public static int[] shift(int[] arr){
		if(arr==null || arr.length==0) return arr;
		int left = 0;
		int right =arr.length-1;
		while(left<right){
			if(arr[left]==1 && arr[right]==0) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}else if(arr[left] == 0) left++;
			else if(arr[right]==1) right --;
		}
		return arr;
	}
	
	public static void main(String[] arg){
    	int[] arr = new int[]{1,1,0,1,1};
    	
    	int[] result = shift(arr);
    	System.out.println(Arrays.toString(result));
    }
	
}
