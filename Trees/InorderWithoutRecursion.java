package Trees;

import java.util.Stack;


public class InorderWithoutRecursion {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	}
	 public static void Inorder(Node root){
		 if(root == null){
			 return;
		 }else{
			 Stack<Node> st = new Stack<Node>();
			 st.add(root);
			 Node curr = root;
			
			 while(!st.isEmpty()){
				 //Go to LeftMost Point from current
				 while(curr != null && curr.left != null){
					 st.push(curr.left);
					 curr=curr.left;
				 }
				 //come back popping from leftmost
				 Node leftmost = st.pop();
				 System.out.print(leftmost.data+" ");
				 
				 //If you have a right right becomes the next curr
				 if(leftmost.right!=null){
					 st.push(leftmost.right);
					 curr=leftmost.right;
				 }else{
					 curr=null;
				 }
				 
				 
			 }
		 }
	 }
	 public static void main(String[] arg){
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.left.left = new Node(8);
		 root.left.right = new Node(5);
		 root.left.right.left = new Node(6);
		 root.left.right.left.left = new Node(6);
		 root.left.right.left.left.left = new Node(7);
		 
		 Inorder(root);
	 }
}
