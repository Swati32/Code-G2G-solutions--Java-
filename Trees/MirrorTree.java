package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.areIdentical.Node;

public class MirrorTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left= this.right = null;
		}
	}
	static public void printTree(Node root){
		if(root == null){
			return;
		}else{
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			q.add(new Node(-1));
			while(!q.isEmpty()){
			  Node temp= q.remove();
			  if(temp.data == -1){
				  System.out.println();
				  if(!q.isEmpty()){
					  q.add(new Node(-1));
				  }
			  }else{
				  if(temp.left !=null) q.add(temp.left);
				  if(temp.right != null) q.add(temp.right);
				  System.out.print(" "+temp.data+" ");
			  }
			  
			}
		}
	}
	
	static public void Mirror(Node root){
		if(root==null){
			return;
		}else{
			
			if(root.left !=null){
				Mirror(root.left);
			}
			if(root.right !=null){
				Mirror(root.right);
			}
			
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			return;
		}
	}
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(5);
		 printTree(root1);
		 Mirror(root1);
		 printTree(root1);
	}

}
