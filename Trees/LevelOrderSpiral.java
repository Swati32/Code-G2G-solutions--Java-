package Trees;

import Trees.areIdentical.Node;

//            1
//           /\
//          2  3
//         /\  /\ 
//        7  6 5 4 
//
// O(n^2)

public class LevelOrderSpiral {

	public static boolean printatLevelK(Node root ,int curr_level, int k, boolean fromRight){
		if(root == null){
			return false;
		}else{
			if(curr_level == k){
				System.out.print(root.data+" ");
				return true;
			}else{
				boolean left = true;
				boolean right = true;
				if(fromRight){
					right = printatLevelK(root.right ,curr_level+1,k,fromRight);
					left  = printatLevelK(root.left,curr_level+1,k,fromRight);
				}	else{
					left  = printatLevelK(root.left ,curr_level+1,k,fromRight);
					right = printatLevelK(root.right,curr_level+1,k,fromRight);
				}
				return(left||right);
			}
		}
	}
	
	public static void LevelOrderSpiral(Node root){
		if(root == null){
			return;
		}else{
			boolean fromright = true;
			boolean levelsLeft = true;
			int k=1;
			while(levelsLeft){
				levelsLeft = printatLevelK(root,1,k++,fromright);
				fromright = (fromright)?false:true;
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


