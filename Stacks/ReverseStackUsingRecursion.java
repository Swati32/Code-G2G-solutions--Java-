package Stacks;
import java.util.Stack;

public class ReverseStackUsingRecursion {
	public static void reverse(Stack s){
		if(s.isEmpty()) {
			return;
		}else{
			int bottom = popBottom(s);
			reverse(s);
			s.push(bottom);
		}
	}
	
	public static int popBottom(Stack<Integer> s){
         int top = s.pop();
         if(s.isEmpty()){
        	 return top;
         }else{
        	 int bottom = popBottom(s);
        	 s.push(top);
        	 return bottom;
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
        reverse(st);
        
        for(int i=0;i<st.size();i++){
        	System.out.print(st.elementAt(i)+" ");
        }
	}
}
