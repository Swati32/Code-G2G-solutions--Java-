package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.InorderWithoutRecursionandStack.Node;

public class PrintAllPathsFromRoot {
	public static void printThisPath(int[] path, int pathlen){
			for(int i=0;i<pathlen;i++){
				System.out.print(path[i]+" ");
			}
	}
	
	public static void printallpaths(Node root, int[] path , int pathlen){
		if(root.left == null && root.right == null){
			path[pathlen++] = root.data;
			printThisPath(path,pathlen);
			return;
		}else{
			
			path[pathlen++] = root.data;
			
			if(root.left != null){
				 printallpaths(root.left,path,pathlen);
			}
			if(root.right != null){
				 printallpaths(root.right,path,pathlen);
			}
		}
	}
	public static void main(String[] arg){
		 Node root = new Node(1);
		 root.left = new Node(2);
		 root.right = new Node(3);
		 root.left.left = new Node(4);
		 root.left.right = new Node(5);
		 int[] path = new int[10000];
		 printallpaths(root,path,0);
	}

}
