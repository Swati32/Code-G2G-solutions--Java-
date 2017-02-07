package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.leafNodes.Node;

public class checkIfComplete {

	 public static boolean isFullNode(Node root){
		 if(root.left != null && root.right !=null){
			 return true;
		 }
		 return false;
	 }
	 public static boolean findIfComplete(Node root){
		 if(root == null){
			 return true;
		 }else{
			 Queue<Node> q =new LinkedList<Node>();
			 q.add(root);
			 int partialNodeFound = 0;
			 while(!q.isEmpty()){
				 Node curr = q.remove();
				 if(isFullNode(curr)){
					 if(partialNodeFound == 1){
						 return false;
					 }
				 }else{
					 if(partialNodeFound == 0){
						 partialNodeFound=1;
					 }
				 }
				 if(curr.left !=null) q.add(curr.left);
				 if(curr.right !=null) q.add(curr.right);
			 }
			 return true;
		 }
	 }
	 public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.right.right = new Node(8);
		 root1.right.left = new Node(6);
		
		 System.out.println(findIfComplete(root1));
		
	}
}
