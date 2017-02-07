package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.InorderWithoutRecursionandStack.Node;

public class PrintAllPaths {
	
	public static void printAllPaths(Node root,List<Integer> pathtillnow){
		
		if(root.left == null && root.right == null){
			pathtillnow.add(root.data);
			printpath(pathtillnow);
			pathtillnow.remove(pathtillnow.size()-1);
			return;
		}else{
			pathtillnow.add(root.data);
			if(root.left != null) {
				printAllPaths(root.left,pathtillnow);
			}
			if(root.right != null) {
				printAllPaths(root.right,pathtillnow);
			}
			pathtillnow.remove(pathtillnow.size()-1); //list me bheja he toh remove karna pad raha he
		}                                             //array me bheja hota toh nai karna padta , kyunki tum abhi tak ka index bhejti sath me
		                                              //left aur right dono ko same next milega toh overwrote hoga .
	}                                                 //Longstory short array would have been a better choice for this one
	
	public static void printpath(List<Integer> path){
		if(path == null){
			return;
		}else{
			for(int i=0;i<path.size();i++){
				System.out.print(path.get(i)+" ");
			}
			System.out.println();
		}
		return;
	}
	
	public static void main(String[] arg){
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.right = new Node(5);
		 List<Integer> path = new ArrayList<Integer>();
		 printAllPaths(root,path);
	}

}
