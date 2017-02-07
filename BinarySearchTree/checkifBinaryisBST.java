package BinarySearchTree;

//Wrong Solution - check the right in find largest BST
//Remember why its wrong ?
//check G2G Yours is method one
public class checkifBinaryisBST {
	
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	}
    
	public static boolean isBST(Node root){
		if(root == null){
			return true;
		}else{
			boolean isleftBST = isBST(root.left);
			boolean isrightBST = isBST(root.right);
			boolean rootinOrder = true;
			if((root.left != null && root.left.data > root.data) || (root.right != null && root.right.data<root.data)){
				rootinOrder = false;
			}
			return(isleftBST && isrightBST && rootinOrder);
		}
	}
	public static void main(String[] arg){
		 Node root1 = new Node(10);
		 root1.left = new Node(8);
		 root1.right = new Node(11);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(9	);
		 
		 System.out.println(isBST(root1));
	}
	 
}
