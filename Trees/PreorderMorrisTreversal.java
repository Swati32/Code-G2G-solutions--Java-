package Trees;

import Trees.areIdentical.Node;

public class PreorderMorrisTreversal {

    public static void preorder(Node root){
    	if(root == null){
    		return;
    	}else{
    		Node curr = root;
    		while(curr != null){
    			if(curr.left == null){
    				System.out.print(curr.data+" ");
    				curr = curr.right;
    			}else{
    				Node leftcurr = curr.left;
    				while(leftcurr.right != null && leftcurr.right != curr){ ///ye tumhar har baar yahan hi kyun gadbad hota he
    					leftcurr =leftcurr.right;                            // do conition pe rokne he
    				}                                                        // ya toh righmost->right == null
    				if(leftcurr.right == null){                              // ya rightmost ka right = curr ho
    					System.out.print(curr.data+" ");                       // jab tak DONO false he tab you keep looping
    					leftcurr.right = curr;                               // dono toh and
    					curr = curr.left;
    				}else{
    					leftcurr.right = null;
    					curr = curr.right;
    				}
    			}
    		}
    	}
    }
	public static void main(String[] arg){
		 Node root1 = new Node(10);
		 root1.left = new Node(8);
		 root1.right = new Node(11);
		 root1.left.left = new Node(4);
		 root1.left.right = new Node(9	);
		 
		 preorder(root1);
	}
}
