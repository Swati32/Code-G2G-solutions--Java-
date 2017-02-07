package Trees;

import Trees.MaximumPathSum.maximum;
import Trees.leafNodes.Node;

public class AllAtDistanceK {
	
	public static void printatK(Node root ,int depth , int k){
		if(root == null){
			return;
		}else{
			if(depth == k){
				System.out.print(root.data+" ");
			}else{
				printatK(root.left,depth+1,k);
				printatK(root.right,depth+1,k);
			}
		}
	
	
	}
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(3);
		 root1.right.left = new Node(6);
		 int k = 2;
		 int depth = 1;
		 printatK(root1,depth,k);
		
	}
}
