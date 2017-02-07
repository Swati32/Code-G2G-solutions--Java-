package Trees;

import Trees.MirrorTree.Node;
import Trees.isBalanced.Hieght;

public class SumFromRootToLeaf {
	
	static public boolean pathSumMatchTargetSum(Node root, int sum , int target){
		if(root == null){
			return false;
		}else{
			sum = sum +root.data;
			if(root.left == null && root.right == null){
				return (sum == target) ? true:false;
			}else if(root.left == null && root.right !=null){
				return pathSumMatchTargetSum(root.right,sum+root.data,target);
			}else if(root.left != null && root.right == null){
				return pathSumMatchTargetSum(root.left,sum,target);
			}else{
				return (pathSumMatchTargetSum(root.left,sum,target)||pathSumMatchTargetSum(root.right,sum,target));
		   }
	   }
	}
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.right.left = new Node(6);
		 int sum = 0;
		 int target = 10;
		 System.out.println(pathSumMatchTargetSum(root1,sum,target));
		
	}
}
