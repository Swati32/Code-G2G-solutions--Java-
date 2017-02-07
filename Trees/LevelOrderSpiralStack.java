package Trees;

import java.util.Stack;

import Trees.areIdentical.Node;

public class LevelOrderSpiralStack {
	
	public static void LevelOrderSpiral(Node root){
		if(root == null){
			return;
		}else{
			Stack<Node> leftFirst = new Stack<Node>();
			Stack<Node> rightFirst = new Stack<Node>();
			
			rightFirst.push(root);
			
			while(!rightFirst.isEmpty()){
				
				while(!rightFirst.isEmpty()){
					Node curr = rightFirst.pop();
					System.out.print(curr.data+" ");
					if(curr.right !=null) leftFirst.push(curr.right);
					if(curr.left !=null) leftFirst.push(curr.left);
				}
				while(!leftFirst.isEmpty()){
					Node curr = leftFirst.pop();
					System.out.print(curr.data+" ");
					if(curr.left !=null) rightFirst.push(curr.left);
					if(curr.right !=null) rightFirst.push(curr.right);
				}
				
			}
		}
	}
	
	public static void main(String[] arg){
		 Node root1 = new Node(1);
		 root1.left = new Node(2);
		 root1.right = new Node(3);
		 root1.left.left = new Node(4);
		 root1.right.right = new Node(8);
		 root1.right.left = new Node(6);
		 
		 LevelOrderSpiral(root1);
	}
}
