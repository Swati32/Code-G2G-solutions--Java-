package Trees;

import Trees.leafNodes.Node;

public class checkifSumTree {
      
	static class Sum{
		int sum ;
		public Sum(){
			sum=0;
		}
	}
	public static boolean checksumtree(Node root,Sum sum){
		if(root.left == null && root.right == null){ //----epic disaster
			sum.sum= root.data;
			return true;
		}else{
			Sum leftsum = new Sum();
			Sum rightsum = new Sum();
			boolean leftcheck = true;
			boolean rightcheck = true;
			
			if(root.left !=null) leftcheck = checksumtree(root.left,leftsum);
			if(root.right !=null) rightcheck = checksumtree(root.right,rightsum) ;
			
			boolean isBalanced = (leftcheck && rightcheck && leftsum.sum+rightsum.sum == root.data); 
			
			sum.sum = leftsum.sum+rightsum.sum+ root.data;
			return isBalanced;
		}
	}
	
	public static void main(String[] arg){
		 Node root1 = new Node(36);
		 root1.left = new Node(4);
		 root1.right = new Node(14);
		 root1.left.left = new Node(4);
		 root1.right.right = new Node(8);
		 root1.right.left = new Node(6);
		 Sum sum = new Sum();
		 System.out.println(checksumtree(root1,sum));
		 System.out.println(sum.sum);
	}	
}
