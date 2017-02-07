package Stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxOfSubarrays {

	
	
	public static int[] findMaxQueue(int[] arr,int k){
		if(arr == null || arr.length==0){
			return arr;
		}else{
			if(arr.length<k){
				k= arr.length;
			}
			int[] result = new int[arr.length-k+1]; int resindex =0;;
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			// Find max of first window
			for(int i=0;i<k;i++){
				if(!q.isEmpty()){
					while(!q.isEmpty() && arr[q.peek()]<=arr[i]){
						q.remove();
					}
				}
				q.add(i);
			}
			
			result[resindex++] = arr[q.peek()];
			
			//Slide window and find rest  
			
			for(int i=k;i<arr.length;i++){
				if(q.peek() < i-k+1){
					q.remove();
				}
				while(!q.isEmpty() && arr[q.peek()]<arr[i]){
					q.remove();
				}
				q.add(i);
				result[resindex++] = arr[q.peek()];
			}
			
			return result;
		}
	}
	
	public static void main(String[] arg){
		int[] arr = new int[]{10,30,20,50,20,90,60};
		int k = 3;
		int[] result = findMaxQueue(arr,k);
		System.out.println(Arrays.toString(result));
	}
}
