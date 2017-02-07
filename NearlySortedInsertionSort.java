import java.util.Arrays;

public class NearlySortedInsertionSort {
	public static int[] SortK(int[] arr){
		if(arr == null || arr.length ==0 ) return arr;
		for(int i= 1;i<arr.length;i++){
			
			for(int j=i; j>0;j--){
				if(arr[j]<arr[j-1]){
					int temp= arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else
					break;
			}
		
		}
		
		return arr;
	}

	public static void main(String[] arg){
		int[] arr1 =  new int[] {20, 4, 1, 2, 3, 4, 2, 10};
		int[] result = SortK(arr1);
		System.out.println(Arrays.toString(result));
	}
}
