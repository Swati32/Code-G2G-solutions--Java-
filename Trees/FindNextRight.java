package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.InorderWithoutRecursionandStack.Node;

public class FindNextRight {

	public static Node getright(Node root,int key){
		if(root == null){
			return null;
		}else{
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			
			while(!q.isEmpty()){
				int size = q.size();
				
				while(size>0){
					size --;
					Node curr=q.remove();
					if(curr.data == key){
						if(size == 0) return null;else return q.peek();
					}else{
						if(curr.left != null) q.add(curr.left);
						if(curr.right != null) q.add(curr.right);
					}
			   }
			}
			return null;
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
	  
	    Node right = getright(root,9); 
	    if(right != null){
	    	System.out.println(right.data);
	    }
	} 
}
