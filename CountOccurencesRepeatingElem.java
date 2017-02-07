
public class CountOccurencesRepeatingElem {
	public static int binarySearchFirst(int[] arr,int start,int end,int x){
		if(arr == null ||arr.length == 0) return -1;
		
		if(start==end) {
			if(arr[start]==x)
				return start;
			else
				return -1;
		}
		
		if(end-start==1){
			if(arr[start]==x) return start;
			if(arr[end]==x) return end;
			return -1;
		}
			
		int mid= (end-start)/2;
		mid = start+mid;
		if(arr[mid] == x && arr[mid-1]<x) return mid;
		if(arr[mid]>= x) return binarySearchFirst(arr,start,mid,x);
		if(arr[mid]< x) return binarySearchFirst(arr,mid+1,end,x);
		
		return -1;
	}
	
	public static int binarySearchLast(int[] arr,int start,int end,int x){
		if(arr == null ||arr.length == 0) return -1;
		
		if(start==end) {
			if(arr[start]==x)
				return start;
			else
				return -1;
		}
		
		if(end-start==1){
			if(arr[start]==x) return start;
			if(arr[end]==x) return end;
			return -1;
		}
			
		int mid= (end-start)/2;
		mid = start+mid;
		if(arr[mid] == x && arr[mid+1]>x) return mid;
		if(arr[mid]> x) return binarySearchLast(arr,start,mid,x);
		if(arr[mid]<= x) return binarySearchLast(arr,mid+1,end,x);
		
		return -1;
	}
	
	public static void main(String[] arg){
		  int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3};
		  int m = 2;
	  	  int first = binarySearchFirst(arr,0,arr.length-1,m);
	  	  int last = binarySearchLast(arr,0,arr.length-1,m);
	  	  if(first == -1) System.out.println("-1");
	  	  System.out.println(last-first+1);
	  }
}
