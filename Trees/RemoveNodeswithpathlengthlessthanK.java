package Trees;

import Trees.areIdentical.Node;

public class RemoveNodeswithpathlengthlessthanK {
	
	public static Node pruneTree(Node root,int k,int pathlengthtillnow){
		if(root == null){
			return null;
		}
		Node leftnode =pruneTree(root.left,k,pathlengthtillnow++);
		Node rightnode = pruneTree(root.right,k,pathlengthtillnow++);
		if(leftnode == null) root.left = null;
		if(rightnode == null) root.right = null;
		if(leftnode == null && rightnode == null && pathlengthtillnow<k){
			return null;
		}
		return root;
	}
	public static void printInorder(Node root){
		if(root == null){
			return;
		}else{
			printInorder(root.left);
			System.out.print(root.data+" ");
			printInorder(root.right);
		}
	}
	public static void main(String[] arg){
		Node root = new Node(1);
	 	root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.left.left.left = new Node(8);
	    root.left.left.right = new Node(9);
	    root.left.right.left = new Node(12);
	    root.right.right.left = new Node(10);
	    root.right.right.left.right = new Node(11);
	    root.left.left.right.left = new Node(13);
	    root.left.left.right.right = new Node(14);
	    root.left.left.right.right.left = new Node(15);
	    printInorder(root);
	    System.out.println();
	    root =  pruneTree(root,5,1);
	    printInorder(root);
	    System.out.println();
	}
}
