package Stacks;

import java.util.Stack;

public class NGE {

	public static void printNGE(int[] arr){
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<arr.length;i++){
			while(!st.isEmpty()){
				int prev = st.pop();
				if(prev<arr[i]){
					System.out.println(Integer.toString(prev)+"--->"+Integer.toString(arr[i]));
				}else{
					st.push(prev);
					break;
				}
			}
			st.push(arr[i]);
		}
		
		while(!st.isEmpty()){
			System.out.println(Integer.toString(st.pop())+"--->"+Integer.toString(-1));
		}
	}
	
	public static void main(String[] arg){
		int[] arr= new int[]{1,4,5,9,6,3,2,7,8};
		printNGE(arr);
	}
}
