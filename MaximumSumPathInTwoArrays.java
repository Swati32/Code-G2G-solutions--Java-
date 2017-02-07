import java.util.ArrayList;
import java.util.List;

public class MaximumSumPathInTwoArrays {
	public static List<Integer> MaxSum(int[] arr1,int[] arr2){
		List<Integer> path = new ArrayList<Integer>();
		int start1 = 0;
		int start2 = 0;
		
		int sum1=0;
		int sum2=0;
		
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length){
			sum1= sum1 +arr1[i];
			sum2 = sum2 +arr2[j];
			if(arr1[i]==arr2[j]){
				if(sum1>sum2)
					for(int k=start1;k<=i;k++) path.add(arr1[k]);
				else
					for(int k=start2;k<=j;k++) path.add(arr2[k]);
				
			   sum1=sum2=0; 
			   start1=i+1; i++;
			   start2=j+1; j++;
				
			}else if(arr1[i]<arr2[j]) i++;	
			else j++;
		}
		
		if(i<arr1.length)
			while(i<arr1.length) sum1=arr1[i++];
		else
			while(j<arr2.length) sum1=arr1[j++];
		
		if(sum1>sum2)
			for(int k=start1;k<arr1.length;k++) path.add(arr1[k]);
		else
			for(int k=start2;k<arr2.length;k++) path.add(arr2[k]);
		
		return path;
		
	}
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {2, 3, 7, 10, 12};
		int[] arr2 =  new int[] {1, 5, 7, 8};
		List<Integer> result = MaxSum(arr1,arr2);
		System.out.println(result);
	}
}
