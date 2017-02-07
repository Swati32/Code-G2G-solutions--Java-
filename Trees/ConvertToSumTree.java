package Trees;

import Trees.leafNodes.Node;

public class ConvertToSumTree {
	public static int makeSumTree(Node root){
		if(root.left == null && root.right==null){
			int leaf = root.data;
			root.data = 0;
			return leaf;
		}else{
			int leftsum =0;
			int rightsum = 0;
			if(root.left!=null){
				leftsum = makeSumTree(root.left);
			}
			if(root.right !=null){
				rightsum = makeSumTree(root.right);
			}
			int originaldata = root.data;
			root.data = leftsum+rightsum;
			return (originaldata+root.data);
		}
		
	}

	public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.right.right = new Node(8);
		 root1.right.left = new Node(6);
		
		 int sum = makeSumTree(root1);
		 System.out.println(sum);
		 System.out.println(root1.data);
		 System.out.println(root1.left.data);
		 System.out.println(root1.right.data);
		 System.out.println(root1.left.left.data);
		 System.out.println(root1.right.right.data);
		 System.out.println(root1.right.left.data);
	}
}
