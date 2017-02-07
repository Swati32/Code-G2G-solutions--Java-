package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	}
	
	public static void inOrder(Node root){
		if(root == null){
			return; 
		}else{
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	public static void preOrder(Node root){
		if(root==null){
			return;
		}else{
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public static void postOrder(Node root){
		if(root == null){
			return;
		}else{
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	public static void levelOrder(Node root){
		if(root == null){
			return;
		}else{
			Queue<Node> q= new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()){
				Node curr= q.remove();
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
				System.out.print(curr.data + " ");
			}
		}	
	}
	
	
	public static void main(String[] arg){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		levelOrder(root);
	}
}

