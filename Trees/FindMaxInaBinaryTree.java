package Trees;

import Trees.InorderWithoutRecursionandStack.Node;

public class FindMaxInaBinaryTree {
	public static int findMax(Node root){
		if(root == null){
			return 0;
		}else{
			int leftmax = findMax(root.left);
			int rightmax = findMax(root.right);
			
			return(Math.max(root.data, Math.max(leftmax, rightmax)));
		}
	}	
	
	public static void main(String[] arg){
			 Node root = new Node(1);
			 root.left = new Node(2);
			 root.right = new Node(3);
			 root.left.left = new Node(4);
			 root.left.right = new Node(5);
			 root.left.right.left = new Node(8);
			 root.left.right.right = new Node(7);
			 System.out.println(findMax(root));
	}
	
}
