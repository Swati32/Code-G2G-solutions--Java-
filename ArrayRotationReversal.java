import java.util.Arrays;

public class ArrayRotationReversal {
	public static int[] reverse(int[] arr,int start,int end){
		if(arr == null || arr.length<2)
			return arr;
		int i=start;
		int j=end;
		while(i<j){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		return arr;
	}
	
	public static int[] arrayRotation(int[] arr,int d){
		if(arr == null || arr.length<2)
			return arr;
		arr = reverse(arr,0,d-1);
		arr = reverse(arr,d,arr.length-1);
		arr = reverse(arr,0,arr.length-1);
		return arr;
	}
	
	 public static void main(String[] arg){
	    	int[] arr = new int[]{1,2,3,4,5,6,7,9};
	    	int d = 3;
	    	int[] result = arrayRotation(arr,d);
	    	System.out.println(Arrays.toString(result));
	 }
}
