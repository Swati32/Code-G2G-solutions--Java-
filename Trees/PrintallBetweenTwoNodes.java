package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.areIdentical.Node;

public class PrintallBetweenTwoNodes {
	public static void printall(Node root ,int low,int high){
		if(root == null){
			return;
		}else{
			Queue<Node> q = new LinkedList<Node>();
			int level =1;
			Node marker = new Node(-1);
			q.add(root);
			q.add(marker);
			while(!q.isEmpty()){
				Node curr = q.remove();
				if( curr == marker ){
					
					if(!q.isEmpty()){
						q.add(marker);
					}
					level++;
				}else{
					if(level>=low && level<=high){
						System.out.print(curr.data+" ");
					}
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
				}
			}
				
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
	    
	    printall(root,4,6);
	}
}
