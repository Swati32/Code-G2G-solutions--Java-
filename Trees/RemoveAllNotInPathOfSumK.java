package Trees;

import Trees.InorderWithoutRecursionandStack.Node;

//Note you cant actually delete anything in java
//you can just dereference it

public class RemoveAllNotInPathOfSumK {

	public static Node prune(Node root,int remaining){
		if(root == null){
			return null;
		}else{
			root.left  = prune(root.left , remaining-root.data);
			root.right = prune(root.right ,remaining-root.data);
			
			if(root.left == null && root.right == null ){
				if(remaining>root.data){
					return null;
				}
			}
			return root;
		}
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
		    prune(root,20);
		    System.out.println();
		    printInorder(root);
	}
}
