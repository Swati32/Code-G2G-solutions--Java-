package BackTracking;

public class mColoringProblem {
	final int V=4;
	
	 public boolean graphColoring(int[][] graph ,int m){
		 int[] sol = new int[V];
		 int[] colors = new int[m];
		 
		 //Initialization
		
		 for(int i=1;i<=m;i++){
			 colors[i-1] = i;
		 }
		 for(int i=0;i<V;i++){
			 sol[i] = -1;
		 }
		 
		 //recursion
		 if(mColoringRecur(0,graph,sol,colors)){
			 printsolution(sol);
			 return true;
		 }else{
			 return false;
		 }
	 }
	 
	 public void printsolution(int[]sol){
			for(int i=0;i<V;i++){
					System.out.print(sol[i]+"  "); //-1 meaning unvisited
		
			}
	 }
	 
	 public boolean mColoringRecur(int node ,int[][] graph, int[] sol, int[] colors){
		if(node==V){
			 return true;
		}else{
		 for(int i=0;i<colors.length;i++){
			 if(isSafe(node,graph,sol,colors[i])){
				 sol[node] = colors[i];
				 if(mColoringRecur(node+1,graph,sol,colors)){
					 return true;
				 }else{
					 sol[node] = -1;
				 }
			 }
		 }
		 return false;
	   }
	 }
	 
	 public boolean isSafe(int node ,int[][] graph, int[] sol, int color){
		 for(int i=0;i<V;i++){
			 if(graph[node][i]==1){
				 if(sol[i]==color){
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 public static void main(String args[])
	    {
	        mColoringProblem Coloring = new mColoringProblem();
	        /* Create following graph and test whether it is
	           3 colorable
	          (3)---(2)
	           |   / |
	           |  /  |
	           | /   |
	          (0)---(1)
	        */
	        int graph[][] = {	{0, 1, 1, 1},
	        					{1, 0, 1, 0},
	        					{1, 1, 0, 1},
	        					{1, 0, 1, 0},
	        				 };
	        int m = 3; // Number of colors
	        System.out.println(Coloring.graphColoring(graph, m));
	    }
}
