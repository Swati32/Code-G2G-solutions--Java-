import java.util.Arrays;

public class Index0tobereplacedby1 {
	public static int findthe0(int[] arr){
		if(arr == null || arr.length==0) return -1; //-1 empty array
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = (arr[0] == 0) ? 0 :1;
		right[arr.length-1] =  (arr[arr.length-1] == 0) ? 0 :1;
		for(int i=1;i<arr.length;i++)
			if(arr[i]==0) left[i]=0; else left[i]=left[i-1]+1;
		for(int i=arr.length-2;i>=0;i--)
			if(arr[i]==0) right[i] =0 ;else right[i]=right[i+1]+1;
		
		int max_on_left_plus_right = Integer.MIN_VALUE;
		int index =0;
		for(int i=1;i<arr.length-1;i++){
			if(arr[i]==0){
			int sum = left[i-1]+right[i+1];
			max_on_left_plus_right=Math.max(max_on_left_plus_right, sum);
			if(sum == max_on_left_plus_right) index=i;}
		}
			
		if(arr[0]==0) {
			max_on_left_plus_right=Math.max(max_on_left_plus_right, right[1]);
			if(max_on_left_plus_right == right[1]) index=0;
		}
		
		if(arr[arr.length-1]==0) {
			max_on_left_plus_right=Math.max(max_on_left_plus_right, left[arr.length-2]);
			if(max_on_left_plus_right == left[arr.length-2]) index= arr.length-1;
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		return index;
		
	}

	public static void main(String[] arg){
		int[] arr1 =  new int[] {1, 1, 1, 1, 0};
		int result = findthe0(arr1);
		System.out.println(result);
	}
}
