package Trees;

import java.util.ArrayList;
import java.util.LinkedList;

import Trees.InorderWithoutRecursionandStack.Node;

public class MinIterationsToPassInformation {
	
	static class NaryNode{
		int data;
		ArrayList<NaryNode> children;
		
		NaryNode(int data){
			this.data = data;
			this.children = new ArrayList<NaryNode>();
		}
		
		public void addChildren(NaryNode child){
			children.add(child);
		}
	}
	static class MinMax {
	    int value;
	    public MinMax(int data){
	    	this.value = data;
	    }
	}
	public static int minIterations(NaryNode root){
		if(root == null){
			return 0;
		}else if(root.children.size() == 0){
			return 0;
		}else{
			int children = root.children.size();
			int[] iterationChildren = new int[children];
			for( int i=0 ; i<children ;i++){
				iterationChildren[i] = minIterations(root.children.get(i));
			}
			
			MinMax min = new MinMax(Integer.MAX_VALUE); MinMax max = new MinMax(Integer.MIN_VALUE);
			findMinMax(min,max,iterationChildren);
			return (Math.max(min.value+children-1, max.value)+1);
		}
	}
	
	public static void findMinMax(MinMax min , MinMax max ,int[] arr){
		for(int i=0; i<arr.length;i++){
			if(arr[i] >max.value){
				max.value = arr[i];
			}
			if(arr[i] <min.value){
				min.value = arr[i];
			}
		}	
	}

	public static void main(String[] arg){
		NaryNode root = new NaryNode(1);
		
		NaryNode child1 = new NaryNode(2);
		NaryNode child2 = new NaryNode(3);
		NaryNode child3 = new NaryNode(4);
		
		root.addChildren(child1);
		root.addChildren(child2);
		root.addChildren(child3);
		
		NaryNode child4 = new NaryNode(5);
		NaryNode child5 = new NaryNode(6);
		NaryNode child6 = new NaryNode(7);
		NaryNode child7 = new NaryNode(8);
		NaryNode child8 = new NaryNode(8);
		
		
		child1.addChildren(child4);
		child1.addChildren(child5);
		child1.addChildren(child6);
		child1.addChildren(child7);
		
		child2.addChildren(child8);
		
		System.out.println(minIterations(root));
	}
}
