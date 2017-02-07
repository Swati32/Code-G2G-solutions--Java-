package Trees;

import Trees.InorderWithoutRecursionandStack.Node;

public class GreatListRecursion {
     
	public static void circulardisplay(Node head)
    {   
		if(head==null){
			return;
		}else{
			System.out.println("Circular Linked List is :");
        	Node curr = head;
        	
        	while(curr != null && curr.right != head)
        	{
            	System.out.print(curr.data+ " " );
            	curr = curr.right;
        	}
        	if(curr!=null){
        		System.out.print(curr.data+ " " );
        	}
		}
    }
	public static Node mergeCircles(Node head1,Node head2, Node root){
		if(head1== null && head2 == null){
			return root;
		}else {
			Node head = null;
			if(head1 == null){
			head = root;
			Node lastlist2 = (head2.left == null) ? head2 : head2.left;
			
			lastlist2.right =root;
			root.right =head2;
			head2.left= root;
			root.left = lastlist2;
		}else if(head2 == null){
			head = head1;
			Node lastlist1 = (head2.left == null) ? head2 : head2.left;
			lastlist1.right = root;
			root.right = head1;
			root.left  = lastlist1;
			head1.left  = root;
		}else{
			head= head1;
			
			Node lastlist1 = (head1.left == null) ? head1 : head1.left;
			Node lastlist2 = (head2.left == null) ? head2 : head2.left;
			
			lastlist2.right = head1;
			lastlist1.right = root;
			root.right = head2;
			      
			root.left = lastlist1;    
			head1.left = lastlist2;
			head2.left = root;
			
			
		}
		return head;
		}
	}
	public static Node treeToList(Node root){
		if(root == null){
			return root;
		}else if(root.left == null && root.right == null){
			return root;
		}else{
			Node head = null;
			
			Node lefthead = treeToList(root.left);
			Node righthead = treeToList(root.right);
			 
	        head = mergeCircles(lefthead,righthead,root);
			
			return head;
		}
	}
	public static Node convertTree(Node root){
		Node head = treeToList(root);
		return head;
	}
	public static void main(String[] arg){
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.right = new Node(5);
		 root.left.right.left = new Node(8);
		 root.left.right.right = new Node(7);
		 Node head = convertTree(root);
		 circulardisplay(head);
	}
}
