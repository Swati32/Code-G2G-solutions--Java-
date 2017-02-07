package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.leafNodes.Node;

public class ConnectNodesatSameLevel {
	static class Node{
		int data;
		Node left,right,nextRight;
		Node(int data){
			this.data=data;
			left=right=nextRight=null;
		}
	}
	
	public static void connectNodesQueue(Node root){
		if(root == null){
			return;
		}else{
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			q.add(new Node(-1));
			while(!q.isEmpty())
			{
				Node curr = q.remove();
				if(curr.data == -1){
					if(!q.isEmpty()){
						q.add(new Node(-1));
					}
				}else{
					if(q.peek().data == -1){
						curr.nextRight = null;
					}else{
					    curr.nextRight = q.peek();
					}
					if(curr.left != null) q.add(curr.left);
					if(curr.right != null) q.add(curr.right);
				}
			}	
		}
	}
	
	public static Node getNextRight(Node root){
		if(root == null || root.nextRight == null){
			return null;
		}else{
			Node curr = root.nextRight;
			while(curr!=null){
				if(curr.left !=null){
					return curr.left;
				}else if(curr.right != null){
					return curr.right;
				}
				curr = curr.nextRight;
			}
			return null;
		}
	}
  
	public static void connectNodesIteration(Node root){
		if(root==null){
			return;
		}else{
			root.nextRight = null;
			Node level = root;
			while(level !=null){
				Node level_elem = level;
				while(level_elem != null){
					
					if(level_elem.left !=null){
						if(level_elem.right != null){
							level_elem.left.nextRight = level_elem.right;
						}else{
							level_elem.left.nextRight = getNextRight(level_elem);
						}
					}
					if(level_elem.right != null){
						level_elem.right.nextRight = getNextRight(level_elem);
					}
					level_elem = level_elem.nextRight;
				}
				
				if(level.left != null){
					level = level.left;
				}else if(level.right != null){
					level = level.right;
				}else{
					level = getNextRight(level);
				}
			}
		}
	}
	
	public static void main(String[] arg){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.right = new Node(8);
		root.right.left = new Node(6);
		//connectNodesQueue(root);
		connectNodesIteration(root);
		System.out.println(root.left.nextRight.data);
		System.out.println(root.left.left.nextRight.data);
		System.out.println(root.right.left.nextRight.data);

		//connectNodesIteration(root);

	}
	
}
