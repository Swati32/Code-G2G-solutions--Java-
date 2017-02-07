package Stacks;

import java.util.Arrays;

public class MaxofSubarraysWithoutQueue {
    
	public static int[] findMaxwithoutQueue(int[] arr,int k){
		if(arr==null || arr.length == 0){
			return arr;
		}else{
			if(arr.length<k){
				k=arr.length;
			}
			int[] result = new int[arr.length-k+1];
		    int max_index = findMaxWithinRange(arr,0,k);
			result[0] = arr[max_index];
			for(int i=1;i<arr.length-k+1;i++){
				if(max_index == i-1){
					max_index = findMaxWithinRange(arr,i,k);
				}
				if(arr[i+k-1]>=arr[max_index]){
					max_index = i+k-1;
				}
				result[i]=arr[max_index];
			}
			return result;
		}
	}
	
	
	public static int findMaxWithinRange(int[] arr,int start, int k){
		int max =Integer.MIN_VALUE;
		int max_index = -1;
		for(int i =start;i<start+k;i++){
			if(arr[i]>=max){
				max = arr[i] ;
				max_index =i;
			}
		}	
		return max_index;
	}
	
	
	public static void main(String[] arg){
		int[] arr = new int[]{10,30,20,50,20,90,60};
		int k = 3;
		int[] result = findMaxwithoutQueue(arr,k);
		System.out.println(Arrays.toString(result));
	}
}
