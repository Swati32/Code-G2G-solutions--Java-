package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.InorderWithoutRecursionandStack.Node;

	public class IterativeMethodtoFindTreeHieght {
		public static int findHieght(Node root){
			if(root==null){
				return  0;
			}else{
				Queue<Node> q = new LinkedList<Node>();
				q.add(root);
				int hieght = 0;
				while(true){
					int elementsinQueue = q.size();
					if(elementsinQueue == 0){
						return hieght;
					}else{
						hieght++;
					}
					while(elementsinQueue>0){
						Node curr = q.remove();
						if(curr.left != null) q.add(curr.left);
						if(curr.right!= null) q.add(curr.right);
						elementsinQueue--;
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
			root.left.right.left = new Node(8);
			root.left.right.right = new Node(7);
			System.out.println(findHieght(root));
		}
}
