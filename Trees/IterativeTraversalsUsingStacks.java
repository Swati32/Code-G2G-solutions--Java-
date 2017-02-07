package Trees;

import java.util.Stack;

import Trees.areIdentical.Node;

public class IterativeTraversalsUsingStacks {
	public static void inOrder(Node root){
		if(root == null){
			return;
		}else{
			Stack<Node> st = new Stack<Node>();
			Node curr= root;
			st.push(curr);
			while(!st.isEmpty()){
				while(curr !=null && curr.left!=null){
					st.push(curr.left);
					curr =curr.left;
				}
				Node leftmost = st.pop();
				System.out.print(leftmost.data+" ");
				if(leftmost.right != null){
					st.push(leftmost.right);
					curr = leftmost.right;
				}else{
					curr = null;
				}
			}
		}
	}
	
	public static void preOrder(Node root){
		if(root == null){
			return;
		}else{
			Stack<Node> st = new Stack<Node>();
			st.push(root);
			
		    while(!st.isEmpty()){
		    	
		    	Node curr = st.pop();
		    	System.out.print(curr.data + " ");
		    	
		    	if(curr.right != null) st.push(curr.right);
		    	if(curr.left != null) st.push(curr.left);
		    }
		}
	}
	
	public static void postOrder(Node root){
		if(root == null){
			return;
		}else{
			Stack<Node> postordered = new Stack<Node>();
			Stack<Node> st = new Stack();
			st.push(root);
			
			while(!st.isEmpty()){
				Node curr = st.pop();
				postordered.push(curr);
				if(curr.left != null) st.push(curr.left);
				if(curr.right != null) st.push(curr.right);
				
			}
			
			while(!postordered.isEmpty()){
				Node curr = postordered.pop();
				System.out.print(curr.data + " ");
			}
		}
	}
	
	public static void postOrderOptimized(Node root){
	  if(root == null){
		  return;
	  }else{
		  Stack<Node> st = new Stack<Node>();
		  st.push(root);
		  Node curr = root;
		  while(!st.isEmpty()){
			      
				  while(curr != null){
					  if(curr.right != null) st.push(curr.right);
				      st.push(curr);
				      curr=curr.left;
				  }
				 curr = st.pop();
				 
				 if(!st.isEmpty()){
				 if(curr!=null && curr.right == st.peek()){
					  Node right = st.pop();
					  st.push(curr);
					  curr = right;
				 }else{
					 System.out.print(curr.data+" ");
					 curr=null;
				 }
			   }
			}
		}
	  }	  

	
	public static void main(String[] arg){
		  Node root = new Node(1);
		    root.left = new Node(2);
		    root.right = new Node(3);
		    root.left.left = new Node(4);
		    root.left.right = new Node(5);
		    root.right.left = new Node(6);
		    root.right.right = new Node(7);
		    System.out.println("Inorder");
			inOrder(root);
			System.out.println();
			System.out.println("Preorder");
			preOrder(root);
			System.out.println();
			System.out.println("Postorder");
			postOrder(root);
			System.out.println();
			System.out.println("postorder 2");
		    postOrderOptimized(root);
	}

}
