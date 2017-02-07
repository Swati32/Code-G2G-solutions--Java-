package Trees;

import Trees.leafNodes.Node;

public class LevelOfaGivenNode {
	 public static int findLevel(Node root, int current_level , int target){
		 if(root == null){
			 return 0;
		 }else{
			 if(root.data == target){
				 return current_level;
			 }else{
				int levelfromleft = findLevel(root.left,current_level+1,target);
				if(levelfromleft !=0){
					return levelfromleft;
				}else{
					int levelfromright = findLevel(root.right,current_level+1,target);
					return levelfromright;
				}
			 }
		 }
	 }	
  
	 public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(8);
		 root1.right.left = new Node(6);
		 int k = 8;
		 int current_Level = 1;
		 int level = findLevel(root1,current_Level,k);
		 if(level == 0){
			 System.out.println("Node not found");
		 }else{
			 System.out.println(level);
		 }
	}
}
