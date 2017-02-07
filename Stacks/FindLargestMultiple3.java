package Stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FindLargestMultiple3 {
	public static Integer[] findLargest(Integer[] arr){
		Arrays.sort(arr);
		 
		Queue<Integer> q0 = new LinkedList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int sum =0;
		int min1_1 , min1_2 , min2_1 , min2_2 = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			int remainder = arr[i]%3;
			if(remainder == 0){
				q0.add(arr[i]);
			}else if(remainder == 1){
				q1.add(arr[i]);
			}else {
				q2.add(arr[i]);
			}
			sum=sum+arr[i];
		}
        int remainder = sum%3;
		if(remainder == 1){
			if(!q1.isEmpty()){
				q1.remove();
			}else if(q2.size()>1){
				q2.remove();
				q2.remove();
			}else{
				return null;
			}
			
		}else if(remainder == 2){
			if(!q2.isEmpty()){
				q2.remove();
			}else if(q1.size()>1){
				q1.remove();
				q1.remove();
			}else{
				return null;
			}
		}
		
		Integer[] result = combineQueues(q0,q1,q2);
		return result;
	}
	
	public static Integer[] combineQueues(Queue<Integer> q0,Queue<Integer> q1,Queue<Integer> q2){
		Integer[] result = new Integer[q0.size()+q1.size()+q2.size()];
		for(int i=result.length-1;i>=0;i--){
			int max = Integer.MAX_VALUE;
			int zero = (q0.isEmpty())?max:q0.peek();
			int one = (q1.isEmpty())?max:q1.peek();
			int two = (q2.isEmpty())?max:q2.peek();
			int min = Math.min(zero, one);
			min = Math.min(min, two);
			result[i]=min;
			if(min == zero){
				q0.remove();
			}else if(min == one){
				q1.remove();
			}else{
				q2.remove();
			}
		}	
		return result;
	}
	
	public static void main(String[] arg){
		Integer[] arr = new Integer[]{8, 1, 7, 6, 0};
		System.out.println(Arrays.toString(findLargest(arr)));
	}
}
