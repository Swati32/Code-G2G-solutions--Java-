package Trees;
public class DiameterofTree {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data= data;
			left=right=null;
		}
	 }
	static class Height
	{
	    int h;
	    public Height(){
	    	h=0;
	    }
	}
	 public static int Diameter( Node root ,Height height){
		 if(root == null){
			 return 0;
		 }else{
			 Height leftHeight = new Height();
			 Height rightHeight = new Height();
			 
			 int left_diameter = Diameter(root.left,leftHeight);
			 int right_diameter = Diameter(root.right,rightHeight);
			 
			 height.h = Math.max(leftHeight.h,rightHeight.h)+1;
			 return (Math.max(leftHeight.h+rightHeight.h+1,Math.max(left_diameter, right_diameter)));
		 }
	 }
	 
	 public static void main(String[] arg){
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.left.left = new Node(8);
		 root.left.right = new Node(5);
		 root.left.right.left = new Node(6);
		 root.left.right.left.left = new Node(6);
		 root.left.right.left.left.left = new Node(7);
		 Height h = new Height();
		 System.out.println(Diameter(root,h) +" "+ h.h );
	 }
}
	
	
