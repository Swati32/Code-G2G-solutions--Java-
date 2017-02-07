
public class BitonicSearch {
	public static int bitonicSearch(int[] arr){
		int bp= Integer.MAX_VALUE;
		if(arr==null || arr.length ==0)
			return 0;
		for(int i=1;i<arr.length-1;i++){
			if(arr[i-1] < arr[i] && arr[i]> arr[i+1])
				return arr[i];
		}
		
		return bp;
	}
	
	public static int binarySearch (int[] arr,int start, int end){
		int bp= Integer.MAX_VALUE;
		if(start>end)
			return bp;
		int mid = (end-start)/2;
		mid = mid+start;
		if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
			return arr[mid];
		if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1])				
		    return binarySearch (arr, mid+1,  end);
		if(arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1])				
			return binarySearch (arr, start,  mid-1);
		return bp;
	}
	
	public static void main(String[] arg){
		int[] arr =  new int[] {1,2,3,4,5,3,2,1};
		int result = bitonicSearch(arr);
		System.out.println(result);
		
		int resultb = binarySearch(arr,0,arr.length-1);
		System.out.println(resultb);
	}
}
