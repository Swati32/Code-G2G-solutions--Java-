package Trees;

import Trees.InorderWithoutRecursionandStack.Node;

public class DifferenceBetweenOddEvenLevels {

	public static int  finddiff(Node root){
		if(root==null){
			return 0;
		}else{
			return(root.data - (finddiff(root.left) + finddiff(root.right)));
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
		System.out.println(finddiff(root));
	}
}
