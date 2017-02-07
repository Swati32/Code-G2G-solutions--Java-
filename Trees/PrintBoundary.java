package Trees;

import Trees.leafNodes.Node;

public class PrintBoundary {

	 public static void printleftboundary(Node root){
		 if(root.left == null && root.right == null){
			 return;
		 }else{
			 System.out.print(root.data+"  ");
			 printleftboundary(root.left);
		 }
	 }
	 public static void printleaves(Node root){
		 if(root.left==null && root.right == null){
			 System.out.print(root.data+"  ");
		 }else{
			 if(root.left !=null){
				 printleaves(root.left);
			 }
			 if(root.right !=null){
				 printleaves(root.right);
			 }
		 }
	 }
	 public static void printrightboundary(Node root){
		 if(root.left == null && root.right==null){
			 return;
		 }else{
			 printrightboundary(root.right);
			 System.out.print(root.data+" ");
		 }
	 }
	 public static void printBoundaryofTree(Node root){
		 printleftboundary(root);
		 printleaves(root);
		 printrightboundary(root.right);
			
	 }
	 public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.right.right = new Node(8);
		 root1.right.left = new Node(6);
		
		 printBoundaryofTree(root1);
		
	}
}
