package BinarySearchTree;

public class InorderPostorder {
	
	 static class predecessor{
		 BSTNode pred;
		 public predecessor(){
			 pred = null;
		 }
	 }
	
	 static class successor{
		 BSTNode succ;                      //we want nodes
		 public successor(){
			 succ = null;
		 }
	 }
	 
	 public static BSTNode findrightmost(BSTNode root){
		 if(root == null){
			 return null;
		 }else if(root.right == null){
			 return root;
		 }else{
			 return findrightmost(root.right);
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
	 
	 public static void find_pred_succ(BSTNode root,predecessor p, successor s,int data){
		 if(root == null){
			 return;
		 }else if(root.data == data){
			 BSTNode pred = findrightmost(root.left);
			 BSTNode succ = findleftmost(root.right);
			 if(pred != null){
				p.pred = pred;
			 }
			 if(succ != null){
				 s.succ = succ;
			 }
			 return;
		 }else{
			 if(root.data > data){
				 s.succ = root;
				 find_pred_succ(root.left,p,s,data);
			 }else{
				 p.pred = root;
				 find_pred_succ(root.right,p,s,data);
			 }
			 return;
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
     
	 public static void main(String[] arg){
   	  BST bst = new BST();
   	  bst.insert(10);
   	  bst.insert(5);
   	  bst.insert(11);
   	  bst.insert(9);
   	  bst.insert(32);
   	  bst.insert(12);
   	  bst.insert(4);
   	  predecessor p = new predecessor();
   	  successor s= new successor();
   	  
   	  inorder(bst.root);
   	  System.out.println();
   	  
   	  find_pred_succ(bst.root,p,s,9);
   	  
   	  if(p.pred!= null){
   		  System.out.println("predecessor :"+p.pred.data);
	  }else{
		  System.out.println("predecessor :"+ "NULL");
	  } 
   	  if(s.succ!= null){
   		  System.out.println("successor :"+s.succ.data);
	  }else{
		  System.out.println("successor :"+ "NULL");
	  }
   	  
   	  
    }

}
