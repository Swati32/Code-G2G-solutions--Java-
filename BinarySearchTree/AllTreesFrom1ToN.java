package BinarySearchTree;

import java.util.ArrayList;

public class AllTreesFrom1ToN {

	
	public static void preorder(BSTNode root){
		if(root == null){
			return;
		}else{
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void getTrees(int N,ArrayList<BSTNode> trees){
		for(int i=1 ; i<=N ; i++)
		{	BST bst = new BST();
		    bst.insert(i);
		    for(int j=1 ;j<=N ; j++){
		    	if(j != i) bst.insert(j);
		    }
			trees.add(bst.root);
		}
	}
	public static void main(String[] arg){
		ArrayList<BSTNode> trees = new ArrayList<BSTNode>();
		getTrees(4,trees);
		for(int i=0;i<trees.size();i++){
			preorder(trees.get(i));
			System.out.println();
		}
	}
}
