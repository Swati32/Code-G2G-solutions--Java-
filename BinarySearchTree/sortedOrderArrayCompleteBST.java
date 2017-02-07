package BinarySearchTree;

public class sortedOrderArrayCompleteBST {
	
	
	public static void printascending(int[] arr, int start, int end){
		if(start>end){
			return;
		}else{
			printascending(arr,2*start+1, end);
			System.out.print(arr[start]+" ");
			printascending(arr,2*start+2, end);
		}
	}
	public static void main(String[] arg){
		int[] arr = new int[]{4,2,5,1,3};
		printascending(arr,0,arr.length-1);
	}

}
