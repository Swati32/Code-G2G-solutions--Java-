package BinarySearchTree;

public class PrintinGivenRange {

	public static void printinrange(BSTNode root, int data1,int data2){
		if(root == null){
			return;
		}else if(root.data<data1){
			printinrange(root.right,data1,data2);
		}else if(root.data>data2){
			printinrange(root.left,data1,data2);
		}else{
			System.out.print(root.data +" ");
			printinrange(root.left,data1,data2);
			printinrange(root.right,data1,data2);
		}
	}
	
	public static void print(BSTNode root, int data1,int data2){
		if(data1>data2){
			int temp = data1;
			data1 = data2;
			data2 = temp;
		}
		printinrange(root,data1,data2);
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
	  	  print(bst.root,5,28);  
	  	               
	}
}
