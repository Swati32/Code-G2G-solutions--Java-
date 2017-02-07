package Stacks;

import java.util.Stack;

public class specialStacktoStoreMin {
 static class StackMin{
	 Stack<Integer> st = new Stack<Integer>();
	 Stack<Integer> minst = new Stack<Integer>();
	 
	 public void push(int m){
		 if(st.isEmpty()){
			 st.push(m);
			 minst.push(m);
		 }else{
			 
			 int top_min = minst.pop();
			 minst.push(top_min);
			 if(m<top_min){
				 minst.push(m);
			 }
			 st.push(m);
		 }
	 }
	 
	 public int pop(){
		 if(st.isEmpty()){
			 System.out.println("Empty Stack");
			 return -1;
		 }else{
			 int top = st.pop();
			 if(top == minst.peek()){
				 minst.pop();
			 }
			 return top;	 
		 }
	 }
	 
	 public int getMin(){
		 return minst.peek();
	 }
 }
 
 public static void main(String[] arg){
	 StackMin st = new StackMin();
	 st.push(14);
	 st.push(19);
	 st.push(12);
	 st.push(1);
	 st.push(30);
	 
	 System.out.println(st.getMin());
	 st.pop();
	 st.pop();
	 
	 System.out.println(st.getMin());
	 st.pop();
	 System.out.println(st.getMin());
	 
 }

}
