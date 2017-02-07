package BinarySearchTree;

public class InorderSuccessor {
	
	
	public static void inorder(BSTNode root){
		if(root == null){
	    	  return;
	    }else{
	    	inorder(root.left);
	    	System.out.print(root.data+" ");
	    	inorder(root.right);
	    }
	}
	
	public static BSTNode findSuccessor(BSTNode root, int data, BSTNode succ){
		if(root== null){
			return null;
		}else if(root.data>data){
			succ = root;
			return findSuccessor(root.left,data,succ);
		}else if(root.data<data){
			return findSuccessor(root.right,data,succ);
		}else{
			BSTNode nextinLine =  findleftmost(root.right);
			if(nextinLine == null){
				return succ;
			}else{
				return nextinLine;
			}
		}
	}
	public static BSTNode findleftmost(BSTNode root){
		if(root == null){
			return null;
		}else if(root.left == null){
			return root;
		}else{
			return findleftmost(root.left);
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
  	  BSTNode successor = findSuccessor(bst.root,9,null);   // case where
  	  if(successor != null)									// normal recursion and findleftmostofright fails 	
  		  System.out.println(successor.data);           	// node is leaf node
  	  else                                              	// thing here to note is whenever you move left succ you are gonna be successsor
  		System.out.println("Null");                     	// if you move right successor remains the same
    }
}
