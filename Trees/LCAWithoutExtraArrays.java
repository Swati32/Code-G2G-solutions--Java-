package Trees;

import Trees.MaxpathSumBetweenTwoNodes.Max;
import Trees.areIdentical.Node;

public class LCAWithoutExtraArrays {
	
	
	static class Nodefound{
		boolean found;
		public Nodefound(){
			found = false;
		}
	}
	
	
	public static int findLCA(Node root,int node1,int node2){
		Nodefound node1found = new Nodefound();
		Nodefound node2found = new Nodefound();
		Node lca = getLCA(root,node1,node2,node1found,node2found);
		if(node1found.found  && node2found.found ){
			return lca.data;
		}else{
			return -1;
		}
		
	}
	//Trick is the order
	// You first process children see, if they have both or one of your elements
	//then first you check if you yourself are the node (that takes care of case when lca is one of the elements) return yourself
	//then you check if both your children have elems (then too you return yourself)
	//third case when say your left child has a node but your right child doesnt you return left child telling the parent that hey I found one of the nodes here
	//four case is just opposite of the second case
	
	public static Node getLCA(Node root,int node1,int node2,Nodefound node1found,Nodefound node2found){
		if(root == null){
			return null;
		}else{
			Node leftsearch = getLCA(root.left,node1,node2,node1found,node2found);
			Node rightsearch = getLCA(root.right,node1,node2,node1found,node2found);
			
			if(root.data == node1){
				if(!node1found.found)  node1found.found =true;
				return root;
			}else if(root.data == node2){
				if(!node2found.found)  node2found.found =true;
				return root;
			}else if(leftsearch != null && rightsearch != null){
				return root;
			}else{
				return (leftsearch == null) ?rightsearch:leftsearch;
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
		  System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5));
		  System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6));
		  System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4));
		  System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4));
	}

}
