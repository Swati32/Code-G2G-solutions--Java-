package Trees;

import Trees.InorderWithoutRecursionandStack.Node;

public class DepthOfDeepestOddLevelLeaf {
	
	
	public static int findDepth(Node root, int currLevel){
		if(root.left == null && root.right == null){
			return (currLevel %2 == 1) ? currLevel: -1;    //careful what you return !
		}else{
			int leftdepth = -1;
			int rightdepth = -1;
			if(root.left != null ) leftdepth = findDepth(root.left,currLevel++);
			if(root.right != null ) rightdepth = findDepth(root.right,currLevel++);
			
			return(Math.max(leftdepth,rightdepth));
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
		System.out.println(findDepth(root,1));
	}

}
