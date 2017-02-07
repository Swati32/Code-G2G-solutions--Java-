package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.MirrorTree.Node;

public class MaxWidth {
	static public int findMaxWidth(Node root){
		if(root == null){
			return 0;
		}else{
			Queue<Node> q = new LinkedList<Node>();
			int maxWidth = Integer.MIN_VALUE;
			int width=0;
			q.add(root);
			q.add(new Node(-1));
			while(!q.isEmpty()){
			  Node temp= q.remove();
			  if(temp.data == -1){
				  maxWidth = Math.max(maxWidth, width);
				  width = 0;
				  if(!q.isEmpty()){                   //ye condition is important - breaking point
					  q.add(new Node(-1));
				  }
			  }else{
				  if(temp.left !=null) q.add(temp.left);
				  if(temp.right != null) q.add(temp.right);
				  
				  width++;
			  }
			  
			}
			return maxWidth;
		}
	}
	
	
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(5);
		 root1.right.left = new Node(6);
		 root1.right.right = new Node(7);
		
		 System.out.println(findMaxWidth(root1));
	
	}

}
