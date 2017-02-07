package Trees;

import java.util.ArrayList;

import Trees.MaxpathSumBetweenTwoNodes.Max;
import Trees.areIdentical.Node;

public class LCA {

	public static int findLCA(Node root,int a,int b){
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		if(findpathtonode(root,path1,a) && findpathtonode(root,path2,b)){
			if(path1.size()>path2.size()){
				return (lca(path1,path2,path1.size()-path2.size()));
			}else{
				return (lca(path2,path1,path2.size()-path1.size()));
			}
		}else{
			return -1;
		}
	}
	
	public static int lca(ArrayList<Integer> path1,ArrayList<Integer> path2,int diff){
		int i= 0;
		while(diff >0){
			i++; diff--;
		}
		for(int j = 0; j<path2.size() && i<path1.size() ;j++,i++){
			if(path2.get(j) == path1.get(i)){
				return path2.get(j);
			}
		}
		return -1;
	}
	
	public static boolean findpathtonode(Node root, ArrayList<Integer> path,int data){
		if(root == null){
			return false;
		}else{
           boolean lefthasnode = findpathtonode(root.left,path,data);
           boolean righthasnode = findpathtonode(root.right,path,data);
           if(lefthasnode||righthasnode||root.data == data){
        	   path.add(root.data);
        	   return true;
           }else{
        	   return false;
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
