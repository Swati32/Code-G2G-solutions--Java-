package DivideAndConquer;

public class MedianOfTwoSortedArrays {
	
	public static float findMedian(int[] arr1,int[] arr2){
		if(arr1 ==null ||arr2 == null){
			return -1;
		}else{
			return median(arr1,arr2,0,arr1.length-1,0,arr2.length-1);
		}
	}
	
	public static float median(int[] arr1,int[] arr2, int start1,int end1,int start2,int end2){
		if(end1- start1 == 1){
			return ((float)(Math.max(arr1[start1], arr2[start2])+Math.min(arr1[end1], arr2[end2])) /2);
		}else{
			int interval = end1- start1/2;
			int med1 = start1+interval;
			int med2 = start2+interval;
			if(arr1[med1]>arr2[med2]){
				median(arr1,arr2,start1,med1,med2,end2);
			}else if(arr2[med2]<arr1[med1]){
				median(arr1,arr2,med1,end1,start2,med2);
			}
			return (float)(arr1[med1]+arr2[med2])/2;
		}
	}
	public static float findMedianByMerging(int[] arr1,int[] arr2){
		if(arr1 ==null ||arr2 == null){
			return -1;
		}else{
			int count=0;
			int i = 0;
			int j = 0;
			int median= 0;
			int n = arr1.length;
			while(count<n && i<n && j<n){
				if( arr1[i]<arr2[j]){
					median=arr1[i++];
				}else{
					median=arr2[j++];
				}
			}
			if(i<n && j<n){
				median += Math.min(arr1[i], arr2[j]);
			}else if(i<n){
				median += arr1[i];
			}else{
				median +=arr2[j];
			}
			return ((float)median/2);
		}
	}
	public static void main(String[] arg){
		int[] arr1= {1,3,8,9,10};
		int[] arr2= {2,5,6,7,11};
		System.out.println(findMedian(arr1,arr2));
		System.out.println(findMedianByMerging(arr1,arr2));
	}

}
