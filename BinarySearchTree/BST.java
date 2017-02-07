package BinarySearchTree;

public class BST {
      BSTNode root;
      public BST(){
    	  root = null;
      }
      public void insert(int data){
    	  root = insertRec(root,data);
      }
      public BSTNode insertRec(BSTNode root, int  data ){
    	  if(root == null){
    		 root = new BSTNode(data);
    		 return root;
    	  }else{
    		  if(root.data > data){
    			  root.left = insertRec(root.left,data);
    		  }else{
    			  root.right = insertRec(root.right,data);
    		  }
    		  return root;
    	  }	  
      }
      public static void inorder(BSTNode root){
    	  if(root == null){
    		  return;
    	  }else{
    		  inorder(root.left);
    		  System.out.print(root.data+" ");
    		  inorder(root.right);
    	  }
      }
      
      public void deleteNode(int data){
    	  root = deleteNodeRec(root,data);
      }
      
      public static BSTNode findleftmost(BSTNode root){
    	  if(root.left == null){
    		  return root;
    	  }else{
    		  return findleftmost(root.left);
    	  }
      }
      public BSTNode deleteNodeRec(BSTNode root, int data){
    	  if(root == null){
    		  return null;
    	  }else if(root.data <data){
    		  root.right = deleteNodeRec(root.right,data);
    		  
    	  }else if(root.data > data){
    		  root.left = deleteNodeRec(root.left,data);
    	  }else{
    		  if(root.left == null){
    			  return root.right;
    		  }
    		  if(root.right == null){
    			  return root.left;
    		  }
    		  
    		  BSTNode successor = findleftmost(root.right);
    		  root.data = successor.data;
    		  root.right = deleteNodeRec(root.right,successor.data);
    	  }
    	  return root;
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
    	  inorder(bst.root);
    	  bst.deleteNode(5);
    	  System.out.println();
    	  inorder(bst.root);
      }
}
