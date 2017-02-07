package Stacks;

import java.util.Stack;

public class sortRecursion {
	public static void sort(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}
		int top = s.pop();
		sort(s);
		InsertatRightPos(s,top);
		return;
	}
	public static void InsertatRightPos(Stack<Integer> s, int elem){
		if(s.isEmpty() || elem >= s.peek()){
			s.push(elem);
		}else{
			int top = s.pop();
			InsertatRightPos(s,elem);
			s.push(top);
		}
	}
	
	public static void main(String[] arg){
		Stack<Integer> st = new Stack<Integer>();
		st.push(2);
		st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        
        for(int i=0;i<st.size();i++){
        	System.out.print(st.elementAt(i)+" ");
        }
        System.out.println();
        sort(st);
        
        for(int i=0;i<st.size();i++){
        	System.out.print(st.elementAt(i)+" ");
        }
	}

}
