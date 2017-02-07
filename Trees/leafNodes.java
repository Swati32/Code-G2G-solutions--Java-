package Trees;

public class leafNodes {
	    static class Node{
	    	int data;
	    	Node left,right;
	    	public Node(int data){
	    		this.data = data;
	    		left=right=null;
	    	}
	    }
	  
		static public int countleaf(Node root){
			if(root == null){
				return 0;
			}else{
				
				if(root.left == null && root.right == null){
					return 1;
				}else if(root.left == null && root.right !=null){
					return countleaf(root.right);
				}else if(root.left != null && root.right == null){
					return countleaf(root.left);
				}else{
					return (countleaf(root.right)+countleaf(root.left));
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
			 int count = 0;
			 System.out.println(countleaf(root1));
			
		}
	

}
