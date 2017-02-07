package Trees;

public class areIdentical {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	}
	
	 public static boolean areIdenticalTrees(Node root1,Node root2){
		 if(root1== null && root2== null){
			 return true;
		 }else if(root1 == null && root2 != null){
			 return false;
		 }else if(root1!=null && root2 == null ){
			 return false;
		 }else if(root1.data==root2.data && areIdenticalTrees(root1.left ,root2.left) && areIdenticalTrees(root1.right ,root2.right)){
			 return true;
		 }else{
			 return false;
		 } 
	 }
	 
	 
	 public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(5);
		
		 Node root2 = new Node(1);
		 root2.left = new Node(2);
		 root2.right = new Node(30);
		 root2.left.left = new Node(4);
		 root2.left.right = new Node(5);
		
		 System.out.println(areIdenticalTrees(root1,root2));
	 }

}
 