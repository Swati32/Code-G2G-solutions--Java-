
public class NextGreaterElement {
	public static void printNGE(int arr[]){
		
		if(arr == null ||arr.length <1) System.out.println("Empty Array");;
		int[] right = new int[arr.length];
		right[arr.length-1] = -1;
		
		for(int i = arr.length-2;i>=0;i--){
			if(arr[i+1]>arr[i]) right[i] =  arr[i+1] ;
				else if(right[i+1]>arr[i]) //arr ki jagah right se compare kar rahi thi duffer !
					right[i] =right[i+1];
				else right[i] = -1;
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.println(Integer.toString(arr[i])+" --> "+Integer.toString(right[i]));
	}

	 public static void main(String[] arg){
     	int[] arr = new int[]{4, 2, 5, 5, 2, 3,3,3, 1};
     	printNGE(arr);
     }
}
