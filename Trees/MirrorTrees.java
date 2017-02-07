package Trees;

import Trees.areIdentical.Node;

public class MirrorTrees {

	public static boolean isMirror(Node root){
		return checkIfMirror(root,root);
	}
	public static boolean checkIfMirror(Node root1, Node root2){
		if(root1 == null && root2 == null){
			return true;
		}else if(root1 == null||root2 ==null){
			return false;
		}else{
			boolean leftmirror = checkIfMirror(root1.left,root2.right);
			boolean rightmirror = checkIfMirror(root1.right,root2.left);
			return (leftmirror && rightmirror && root1.data == root2.data);
		}
	}
	public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(2);
		 root1.left.left = new Node(3);
		 root1.left.right = new Node(4);
		 root1.right.left = new Node(5);
		 root1.right.right = new Node(3);
		 System.out.println(isMirror(root1));
	}
}
