package BinarySearchTree;

public class LCABinarySearchTree {
	public static BSTNode findLCA(BSTNode root,int data1, int data2){
		if(root == null){
			return null;
		}else{
			if(data1>data2){
				int temp=data1;
				data1=data2;
				data2=temp;
			}
			return findLCArecur(root,data1,data2);
		}
	}
	public static BSTNode findLCArecur(BSTNode root,int data1, int data2){
		if(root == null){
			return null;
		}else if(root.data<data1){
			return findLCArecur(root.right,data1,data2);
		}else if(root.data>data2){
			return findLCArecur(root.left,data1,data2);
		}else{
			return root;
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
	  	  BSTNode lca = findLCA(bst.root,3,4);   // case where
	  	  if(lca != null)									// normal recursion and findleftmostofright fails 	
	  		  System.out.println(lca.data);           	// node is leaf node
	  	  else                                              	// thing here to note is whenever you move left succ you are gonna be successsor
	  		System.out.println("Null");                     	// if you move right successor remains the same
	}
}
