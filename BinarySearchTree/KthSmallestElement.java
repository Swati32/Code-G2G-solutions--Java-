package BinarySearchTree;

import BinarySearchTree.FindLargestBSTsubtreeBinaryTree.Node;

public class KthSmallestElement {
    public static void findKthSmallest(BSTNode root , int k ){
    	if(root == null){
    		return;
    	}else{
    		int rank = 0;
    		BSTNode curr = root;
    		while(curr != null){
    			if(curr.left == null){
    				if(++rank == k) break;
    				curr= curr.right;
    			}else{
    				BSTNode left_elem = curr.left;
    				while(left_elem.right != null && left_elem.right != curr){
    					left_elem = left_elem.right;
    				}
    				if(left_elem.right == null){
    					left_elem.right = curr;
    					curr = curr.left;
    				}else{
    					left_elem.right =null;
    					if(++rank == k) break;
    					curr = curr.right;
    				}
    			}
    		}
    		if(rank == k){
    			System.out.println(curr.data);
    		}else{
    			System.out.println("No such node");
    		}
    	}
    }
	public static void main(String[] arg){
		BST bst = new BST();
	  	  bst.insert(10);
	  	  bst.insert(5);
	  	  bst.insert(11);
	  	  bst.insert(9);
	  	  bst.insert(32);
	  	  bst.insert(12);
	  	  bst.insert(4);
	  	  bst.insert(3);
	  	  findKthSmallest(bst.root,3);
		 
	}
}
