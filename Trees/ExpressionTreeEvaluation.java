package Trees;

import java.util.Stack;

public class ExpressionTreeEvaluation {
	static class Node{
		char  data;
		Node left,right;
		public Node(char data){
			this.data = data;
			left = right = null;
		}
	}
	
	static class ExpressionTree{
		
		Node root;
		public ExpressionTree(){
			root= null;
		}
		public boolean isOperator(char ch){
			if(ch =='+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
				return true;
			}else{
				return false;	
			}
		}
		
		public boolean isDigit(char ch){
			if(ch >='1' && ch <='9'){
				return true;
			}else{
				return false;
			}
		}
		
		public void inorder(){
			inorderrec(root);
		}
		public void inorderrec(Node r){
			if(r == null){
				return;
			}else{
				inorderrec(r.left);
				System.out.print(r.data+" ");
				inorderrec(r.right);
			}
		}
		public Node constructTreeFromPostFix(String postfix){
			Stack<Node> st = new Stack<Node>();
			Node curr , leftcurr,rightcurr;
			curr = leftcurr = rightcurr = null;
			
			for(int i=0 ; i<postfix.length() ;i++){
				
				char ch = postfix.charAt(i);
				curr = new Node(ch);
				
				if(isOperator(ch)){
					rightcurr  = st.pop();
					 leftcurr  = st.pop();
					curr.left  = leftcurr;
					curr.right = rightcurr;
					st.push(curr);
				}else{
					st.push(curr);
				}
			}
			root = st.pop();
			return root;
		}
		
	}
	
	  public static void main(String args[]) {
		  
	        ExpressionTree et = new ExpressionTree();
	        String postfix = "ab+ef*g*-";
	        et.constructTreeFromPostFix(postfix);
	        System.out.println("infix expression is");
	        et.inorder();
	 
	    }
   
}
