import java.util.Arrays;

public class ReplaceWithGreatestOnRight{
	
    public static int[] replace(int[] arr){
    	if(arr == null || arr.length ==0 ) return arr;
    	int max = -1;
    	for(int i=arr.length-1 ;i>=0;i--){
    		int temp = arr[i];
    		arr[i] =max;
    		max = Math.max(max, temp);
    	}
    	return arr;
    }
	
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {20, 4, 1, 10, 3, 4, 2};
		int[] result = replace(arr1);
		System.out.println(Arrays.toString(result));
	}
}
