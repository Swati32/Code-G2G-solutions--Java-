package Trees;

import Trees.areIdentical.Node;

public class MaxpathSumBetweenTwoNodes {
    static class Max{
    	int val;
    	public Max(){
    		val = Integer.MIN_VALUE;
    	}
    }
	public static int maxsumpath(Node root ,Max maxval ){
		if(root == null){
			return 0;
		}else{
			int lefttreemax = maxsumpath(root.left,maxval);
			int righttreemax = maxsumpath(root.right,maxval);
			if(lefttreemax+righttreemax+root.data >maxval.val){
				maxval.val = lefttreemax+righttreemax+root.data;
			}
			return(Math.max(lefttreemax+root.data, righttreemax+root.data));		
		}
	}
	public static void main(String[] arg){
		Node root = new Node(1);
		 root.left = new Node(5);
		    root.right = new Node(6);
		    root.left.left = new Node(-8);
		    root.left.right = new Node(1);
		    root.left.left.left = new Node(2);
		    root.left.left.right = new Node(6);
		    root.right.left = new Node(3);
		    root.right.right = new Node(9);
		    root.right.right.right= new Node(0);
		    root.right.right.right.left= new Node(4);
		    root.right.right.right.right= new Node(-1);
		    root.right.right.right.right.left= new Node(10);

	    Max maxval = new Max();
	    int sum_till_now = 0;
	    int res = maxsumpath(root,maxval);
	    System.out.println(maxval.val);
	}
}
