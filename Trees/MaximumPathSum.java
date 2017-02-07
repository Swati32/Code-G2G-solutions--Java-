package Trees;

import Trees.leafNodes.Node;

public class MaximumPathSum {
	static class maximum
	{
		int max;
		Node maxleaf ;
		public maximum(){
			max = Integer.MIN_VALUE;
			maxleaf = null;
		}		
	}
	public static void GetMaxLeafNode(Node root,int sumtillnow, maximum maxval){
		if(root==null){
			return;
		}else{
			if(root.left == null && root.right == null){
				sumtillnow += root.data;
				if(sumtillnow>maxval.max){
					maxval.max = sumtillnow;
					maxval.maxleaf = root;
				}
				return;
			}else{
				sumtillnow += root.data;
				if(root.left != null){
					GetMaxLeafNode(root.left,sumtillnow,maxval);
				}
				if(root.right != null){
					GetMaxLeafNode(root.right,sumtillnow,maxval);
				}	
			}
		}
	}
    public static void printMaxSumpath(Node root,int sumtillnow, maximum maxval){
    	if(root == null){
    		return;
    	}else{
    		GetMaxLeafNode(root,sumtillnow,maxval);
    		printpath(root,maxval.maxleaf);
    	}
    }
    
    public static boolean printpath(Node root,Node leaf){
    	if(root == null){
    		return false;
    	}else{
    			if(root==leaf || printpath(root.left,leaf) ||printpath(root.right,leaf)){
    				System.out.print(root.data+" ");
    				return true;
    			}else{
    				return false;
    			}
    	}
    }
    
    public static void printpath(int[] path,int pathlen){
    	for(int i =0 ;i<pathlen;i++){
    		System.out.print(path[i]+" ");
    	}
    	System.out.println();
    }
	
	
	
	static public void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(3);
		 root1.right.left = new Node(6);
		 maximum maxval = new maximum();
		 printMaxSumpath(root1,0,maxval);
		
	}
	
	
	
	
}
