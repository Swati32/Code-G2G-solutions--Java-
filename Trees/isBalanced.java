package Trees;

import Trees.MirrorTree.Node;

public class isBalanced {
	
	static class Hieght{
		int h;
		public Hieght(){
			h=0;
		}
	}
	
	public static boolean isBalancedTree(Node root ,Hieght height){
		if(root == null){
			return true;
		}else{
			Hieght leftHieght = new Hieght();
			Hieght rightHieght = new Hieght();
			boolean leftbalanced = isBalancedTree(root.left,leftHieght);
			boolean rightbalanced = isBalancedTree(root.right,rightHieght);
			height.h = Math.max(leftHieght.h,rightHieght.h)+1;
			
			return((leftbalanced && rightbalanced) && (Math.abs(leftHieght.h-rightHieght.h)<=1));
		}
	}
	
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		
		 Hieght h = new Hieght();
		 System.out.println(isBalancedTree(root1,h));
		
	}

}
