package BinarySearchTree;

public class countInRange {
	static class Count{
		int val;
		public Count(){
			val = 0;
		}
	}
    public static void count(BSTNode root, int data1,int data2, Count count){
    	if(root == null){
    		return;
    	}else{
    		if(data1<data2){
    			countinrange(root,data1,data2,count);
    		}else{
    			countinrange(root,data2,data1,count);
    		}
    	}
    }
    public static void countinrange(BSTNode root, int data1,int data2, Count count) {
    	if(root == null){
    		return;
    	}else if(root.data<data1){
    		countinrange(root.right, data1,data2,count);
    	}else if(root.data>data2){
    		countinrange(root.left,data1,data2,count);
    	}else{
    		count.val +=1;
    		countinrange(root.left,data1,data2,count);
    		countinrange(root.right, data1,data2,count);
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
	  	  Count cnt = new Count();
	  	  count(bst.root,5,28,cnt);  
	  	  System.out.println(cnt.val);             
	}
}
