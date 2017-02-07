package BinarySearchTree;

import BinarySearchTree.checkifBinaryisBST.Node;

public class FindLargestBSTsubtreeBinaryTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	}
	
	public static int findLargestBST(Node root, Integer min , Integer max){
		if(root==null){
			return 0;
		}else{
			Integer minleft,maxleft,minright,maxright;
			minleft =  minright = Integer.MAX_VALUE;
			maxleft =  maxright = Integer.MIN_VALUE;
			
			int leftsize = findLargestBST(root.left,minleft,maxleft);
			int rightsize = findLargestBST(root.right,minright,maxright);
			
			min = (root.left == null) ? root.data: minleft;
			max = (root.right == null) ? root.data: maxright;
			
			if(root.data > maxleft && root.data<minright){
				return leftsize+rightsize+1;
			}else{
				return Math.max(leftsize, rightsize);
			}
			
		}
	}
	
	
	public static void main(String[] arg){
		 Node root1 = new Node(10);
		 root1.left = new Node(8);
		 root1.right = new Node(11);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(9	);
		 
		 System.out.println(findLargestBST(root1,Integer.MAX_VALUE,Integer.MIN_VALUE));
	}
}
