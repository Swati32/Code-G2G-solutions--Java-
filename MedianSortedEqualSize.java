
public class MedianSortedEqualSize {
   
	public static double findmedian(int[] arr1 , int[] arr2 , int start1 , int start2, int end1, int end2){
		float result=0;
		
		if(end1-start1==0 && end2-start2==0)
			return((arr1[start1]+arr2[start2])/2.0);

		if(end2-start2==1 && end1-start1==1)
			return((Math.max(arr1[start1], arr2[start2])+Math.max(arr1[end1], arr2[end2])) /2);
		
		if(start2<=end2 && start1<=end1){
			int mid1 = (end1-start1)/2;
			int mid2 = (end2-start2)/2;	
			mid1 = start1+mid1;
			mid2 = start2+mid2;
			int median1= arr1[mid1];
			int median2 = arr1[mid2];
			if(end1-start1%2 !=0){
			   median1= (arr1[mid1]+arr1[mid1+1])/2;
			}
			if(end2-start2%2 !=0){
			   median2= (arr2[mid2]+arr2[mid2+1])/2;
			}
		
			if(median1==median2)
				return arr1[mid1];
			    		
		    if(median2>median1){
		    	 end2=mid2-1;
		    	 if(end2<start2) end2=start2;
		    	 start1 =mid1+1;
		    	 if(start1>end1) start1=end1;
		    	return  findmedian(arr1,arr2,start1,start2,end1,end2);
		    }else{
		    	end1=mid1-1;
		    	if(end1<start1) end1=start1;
		    	start2=mid2+1;
		    	if(start2>end2) start2=end2;
		    	return  findmedian(arr1,arr2,start1,start2,end1,end2);
		    }
		}
		return result;
		
	}
	public static void main(String[] arg){
		int[] arr1 =  new int[] {1,1,3,4};
		int[] arr2 =  new int[] {0,1,2,3};
		double result = findmedian(arr1,arr2,0,0,arr1.length-1,arr1.length-1);
		System.out.println(result);
		
	}
}
