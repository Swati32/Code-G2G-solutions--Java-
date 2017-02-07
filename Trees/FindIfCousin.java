package Trees;

import Trees.areIdentical.Node;

public class FindIfCousin {
	public static int findLevel(Node root ,int k , int key){
		if(root == null){
			return -1;
		}else{
			int level = -1;
			if(root.data == key){
				level = k;
			}else{
				level = findLevel(root.left,k+1,key);
				if(level == -1){
					level = findLevel(root.right,k+1,key);
				}
			}
			return level;
		}
	}
	
	public static boolean checkifSibling(Node root,int k, int currlevel, int a,int b){
		if(root == null){
			return false;
		}else{
			if(currlevel == k-1){
				return((root.left.data == a && root.right.data ==b)|| (root.left.data ==b && root.right.data==a));
			}else{
				return(checkifSibling(root.left,k,currlevel+1,a,b) || checkifSibling(root.right,k,currlevel+1,a,b));
			}
		}
	}
	
	public static boolean checkifCousin(Node root,int a,int b){
		if(root == null){
			return false;
		}else{
			int level_a = findLevel(root,1,a);
			int level_b = findLevel(root,1,b);
			
			if(level_a == -1 || level_b == -1){
				System.out.println("Missing one or both nodes");
				return false;
			}else{
				if(level_a == level_b){
					boolean areSiblings = checkifSibling(root,level_a,1,a,b);
					return(!areSiblings);
				}else{
					return false;
				}
			}
		}
	}

	public static void main(String[] arg){
		Node root = new Node(1);
	 	root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.left.left.left = new Node(8);
	    root.left.left.right = new Node(9);
	    root.left.right.left = new Node(12);
	    root.right.right.left = new Node(10);
	    root.right.right.left.right = new Node(11);
	    root.left.left.right.left = new Node(13);
	    root.left.left.right.right = new Node(14);
	    root.left.left.right.right.left = new Node(15);
	    
	    System.out.println(checkifCousin(root,4,6));
	}
}
