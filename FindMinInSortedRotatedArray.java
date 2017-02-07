
public class FindMinInSortedRotatedArray {

	public static int findmin(int arr[]){
		if(arr==null || arr.length == 0 ) return -1;
		int n =binarySearch(arr,0,arr.length-1);
		return n;
	}
	
	public static int binarySearch (int[] arr,int start, int end){
		int bp= Integer.MAX_VALUE;
		if(start>end)
			return bp;
		int mid = (end-start)/2;
		mid = mid+start;
		if(arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1])
			return arr[mid];
		if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1])				
		    return binarySearch (arr, start,  mid-1);
		if(arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1])				
			return binarySearch (arr, mid+1,  end);
		else
			return arr[mid+1];
		
	}
	
	public static void main(String[] arg){
		   int[] arr1 =  new int[] {4,5,6,7,0,2,3};	
		   int r = 3;
		   int data[] = new int [r];
			
		   int n = findmin(arr1);
		   System.out.println(n);
		}
}
