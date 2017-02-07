package Trees;

import Trees.InorderWithoutRecursion.Node;

	public class InorderWithoutRecursionandStack {
		static class Node{
			int data;
			Node left;
			Node right;
		
			Node(int data){
				this.data= data;
				left=right=null;
			}
	   }
		
		
	public static void InorderThreading(Node root){
			Node curr = root;
			while(curr != null){
				if(curr.left == null){
					System.out.print(curr.data+ " ");
					curr = curr.right;
				}else{
					
					Node temp = curr.left;
					while(temp.right != null && temp.right != curr){
						temp = temp.right;
					}
					if(temp.right == null){
						temp.right = curr;
						curr = curr.left;
					}else{
						System.out.print(curr.data+" ");
						curr = curr.right;
						temp.right = null;
					}
				}
			}
			return;
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
			 
			 InorderThreading(root);
	}
	
		
		
		
		
}
