package Stacks;

import java.util.Stack;

public class LongestValidSubstring {
	
	public static int findLongestValidSubstring(String s){
		if(s == null || s.length() == 0){
			return 0;
		}else{
			int size = s.length();
			Stack<Integer> st = new Stack<Integer>();
			int result= Integer.MIN_VALUE;
			st.push(-1);
			for(int i=0;i<size;i++){
				char ch = s.charAt(i);
				if(ch =='('){ 
						st.push(i);
				}else{ 
						st.pop();
						if(!st.isEmpty()){
							result = Math.max(result, i-st.peek());
							
						}else{
							st.push(i);
						}
						
				}
			}
			return result;
		}
	}
	
	public static void main(String[] arg){
		String input  = "()(()))))";
		System.out.println(findLongestValidSubstring(input));
	}
}
