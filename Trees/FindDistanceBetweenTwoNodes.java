package Trees;

import Trees.areIdentical.Node;

public class FindDistanceBetweenTwoNodes {
	static class found{
		boolean found;
		int distanceFromRoot;
		public found(){
			found = false;
			distanceFromRoot = 0;
		}
	}
	
	public static int findDistance(Node root,int node1,int node2){
		found node1found = new found();
		found node2found = new found();
		found Distancefound = new found();
		int pathlength = 0;
		Node lca = findDistance(root,node1,node2,node1found,node2found,Distancefound , pathlength);
		if(node1found.found && node2found.found){
			/*if(lca.data == node1){
				Distancefound.distanceFromRoot =node1found.distanceFromRoot;
			}else if(lca.data == node1){
				Distancefound.distanceFromRoot =node2found.distanceFromRoot;
			}*/
			return(node1found.distanceFromRoot+node2found.distanceFromRoot - 2*(Distancefound.distanceFromRoot));
		}else{
			return -1;
		}
	}
	public static Node findDistance(Node root,int node1,int node2,found node1found ,found node2found ,found Distancefound,int pathlength ){
		if(root == null){
			return null;
		}else{
			Node leftsearch =findDistance(root.left,node1,node2,node1found,node2found,Distancefound , pathlength+1);
			Node rightsearch =  findDistance(root.right,node1,node2,node1found,node2found,Distancefound , pathlength+1);	
			if(node1 == root.data){
				if(!node1found.found){
					node1found.found = true;
					node1found.distanceFromRoot = pathlength;
					Distancefound.distanceFromRoot = pathlength;
					return root;
				}
			}else if(node2 == root.data){
				if(!node2found.found){
					node2found.found = true;
					node2found.distanceFromRoot = pathlength;
					Distancefound.distanceFromRoot = pathlength;
					return root;
				}	
			}else if(leftsearch != null && rightsearch != null){
					Distancefound.found = true;
					Distancefound.distanceFromRoot = pathlength;
					return root;
			}

			return (leftsearch != null) ? leftsearch :rightsearch;
			
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
		  System.out.println("Distance(4, 5) = " + findDistance(root, 4, 5));
		  System.out.println("Distance(4, 6) = " + findDistance(root, 4, 6));
		  System.out.println("Distance(3, 4) = " + findDistance(root, 3, 4));
		  System.out.println("Distance(2, 4) = " + findDistance(root, 2, 4));
	}


}
