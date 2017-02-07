package Stacks;

import java.util.Stack;

public class Histogram {
	public static int findMaxAreaHistogram(int[] arr){
		if(arr==null || arr.length == 0){
			return 0;
		}else{
			Stack<Integer> st = new Stack<Integer>();
			int max_area =Integer.MIN_VALUE;
			int i=0;
			for(;i<arr.length;i++){
				if(st.isEmpty() || arr[st.peek()]>arr[i]){
					st.push(i);
				}else{
					int top = st.pop();
					int area_with_top =arr[top] *(st.isEmpty()?i:i-st.peek()-1);
					max_area= Math.max(max_area, area_with_top);
				}
				
			
			}
			
			while(!st.isEmpty()){
				int top = st.pop();	
				int area_with_top =arr[top] *(st.isEmpty()?1:top-st.peek()-1);
				max_area= Math.max(max_area, area_with_top);
			}
			return max_area;
		}
	}
	
	public static void main(String[] arg){
		int[] hist = {6, 2, 5, 4, 5, 1, 6};
		System.out.println("max area "+findMaxAreaHistogram(hist));
	}
}
