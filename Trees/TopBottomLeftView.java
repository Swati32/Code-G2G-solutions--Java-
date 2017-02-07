package Trees;

import java.util.HashMap;

import Trees.areIdentical.Node;

public class TopBottomLeftView {
	
	public static void GetTopView(Node root){
		if(root == null){
			return;
		}else{
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			int horizontal_distance = 0;
			getTopElements(root,map,horizontal_distance);
			for(Integer key:map.keySet()){
				System.out.print(map.get(key)+" ");
			}
			System.out.println();
		}
	}
	public static void getTopElements(Node root,HashMap<Integer,Integer> map,int horizontal_distance){
		if(root == null){
			return;
		}else{
			if(!map.containsKey(horizontal_distance)){
				map.put(horizontal_distance, root.data);
			}
			getTopElements(root.left,map,horizontal_distance+1);
			getTopElements(root.right,map,horizontal_distance-1);
		}
	}

	public static void GetBottomView(Node root){
		if(root == null){
			return;
		}else{
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			int horizontal_distance = 0;
			getBottomElements(root,map,horizontal_distance);
			for(Integer key : map.keySet()){
				System.out.print(map.get(key)+" ");
			}
			System.out.println();
		}
	}
	public static void getBottomElements(Node root,HashMap<Integer,Integer> map , int horizontal_distance){
		if(root == null){
			return;
		}else{
			map.put(horizontal_distance, root.data);
			getBottomElements(root.left,map,horizontal_distance+1);
			getBottomElements(root.right,map,horizontal_distance-1);
		}
	}

	static class MaxVal{
		int val;
		public MaxVal(){
			val = Integer.MIN_VALUE;
		}
	}
	
	public static void GetLeftView(Node root){
		if(root == null){
			return;
		}else{
			MaxVal max_level_till_now = new MaxVal();
			int curr_level = 1; 
			printNewLevels(root,curr_level,max_level_till_now);
		}
	}
	
	public static void printNewLevels(Node root, int curr_level, MaxVal max_level_till_now ){
		if(root == null){
			return;
		}else{
			if(curr_level>max_level_till_now.val){
				System.out.print(root.data+" ");
				max_level_till_now.val = curr_level;
			}
			printNewLevels(root.left,curr_level+1,max_level_till_now);
			printNewLevels(root.right,curr_level+1,max_level_till_now);
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
	    root.left.left.left = new Node(8);
	    root.left.left.right = new Node(9);
	    root.left.right.left = new Node(12);
	    root.right.right.left = new Node(10);
	    root.right.right.left.right = new Node(11);
	    root.left.left.right.left = new Node(13);
	    root.left.left.right.right = new Node(14);
	    root.left.left.right.right.left = new Node(15);
	    System.out.println("Top View");
	    GetTopView(root);
	    System.out.println("Bottom View");
	    GetBottomView(root);
	    System.out.println("Left View");
	    GetLeftView(root);
	}
}
