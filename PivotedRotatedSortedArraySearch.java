
public class PivotedRotatedSortedArraySearch {

	public static int findPivot(int[] arr ,int start,int end){
		int result = 0;
		if(start<=end){
			int mid= (end-start)/2;
			mid = start+mid;
			
			if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
				return mid;
			if(arr[mid-1]>arr[mid] && arr[mid]<arr[mid+1])
				return mid;
			if(arr[mid]<arr[start])
				return(findPivot(arr,start,mid-1));
			else
				return(findPivot(arr,mid+1,end));
		}
		return result;
	}
	
	public static int binarysearch(int[] arr,int start, int end,int elem){
		int result = -1 ;
		if(start<=end){
			int mid= (end-start)/2;
			mid = start+mid;
			
			if(elem==arr[mid])
				return mid;
			if(elem<arr[mid])
				return(binarysearch(arr,start,mid-1,elem));
			else
				return(binarysearch(arr,mid+1,end,elem));
		}
		return result;
	}
	public static void main(String[] arg){
		int[] arr =  new int[] {8,1,2,3,4,5,5,6,7};
		int elem= 5 ;
		int pivot = findPivot(arr,0,arr.length-1);
		System.out.println(pivot);
		int resultb = -1;
		if(arr[pivot]==elem)
			resultb=pivot;
		else{
			
		resultb = Math.max(binarysearch(arr,pivot+1,arr.length-1,elem), binarysearch(arr,0,pivot-1,elem));	
		}
	   System.out.println(resultb);
	}
}
