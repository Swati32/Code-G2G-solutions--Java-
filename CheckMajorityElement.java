

public class CheckMajorityElement {
	
	public static boolean checkIfMajority(int[] arr,int num){
		if(arr == null || arr.length==0) return false;
		int first_pos = binarySearch(arr,arr.length-1,0,num);
		if(first_pos <0) return false;
		
		if((first_pos+((arr.length-1)/2))<arr.length-1 && arr[first_pos+((arr.length-1)/2)]==num) 
			return true;
			else
			return false;
		
		
	}
	
	public static int binarySearch(int[] arr, int high, int low,int x){
		if(low>high) //base case
			return -1;
		int mid= (high-low)/2;
		mid = low + mid;
		if(arr[0]==x)  return 0;
		if(mid-1 >0 && arr[mid] == x && arr[mid]>arr[mid-1]) return mid;
		if(arr[mid]>=x) return(binarySearch(arr,mid-1,low,x));
		if(arr[mid]<x) return(binarySearch(arr,high,mid+1,x));
		return -1;
	}
	
	public static void main(String[] arg){
    	int[] arr = new int[]{1,1,1,1,1,1};
    	int d = 1;
    	boolean result = checkIfMajority(arr,d);
    	System.out.println(result);
 }

}
