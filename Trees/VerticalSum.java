package Trees;

import java.util.HashMap;

import Trees.leafNodes.Node;

public class VerticalSum {

	public static void fillSumOnDistance(Node root,int distanceFromRoot,HashMap<Integer,Integer> Sum){
		if(root==null){
			return;
		}else{
			if(Sum.containsKey(distanceFromRoot)){
				Sum.put(distanceFromRoot, Sum.get(distanceFromRoot)+root.data);
			}else{
				Sum.put(distanceFromRoot, root.data);
			}
			fillSumOnDistance(root.left,distanceFromRoot-1,Sum);
			fillSumOnDistance(root.right,distanceFromRoot+1,Sum);
		}
	}

	public static void findVerticalSum(Node root){
		if(root == null){
			return;
		}else{
			HashMap<Integer,Integer> Sum = new HashMap<Integer,Integer>();
			fillSumOnDistance(root,0,Sum);
			for(int sumval : Sum.keySet()){
				System.out.println(sumval+" "+Sum.get(sumval));
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
	     findVerticalSum(root1);	 
	}	 
}
