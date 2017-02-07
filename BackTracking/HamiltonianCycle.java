package BackTracking;

import java.util.Arrays;

public class HamiltonianCycle {
	public void hamCycle(int[][] graph){
		int V = graph.length;
		boolean[] visited = new boolean[V];
		int[] path = new int[V];
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		
		if(hamCycleRecur(visited,graph,path,0,0)){
			System.out.println(Arrays.toString(path));
		}else{
			
			System.out.println("No such path");
		}
	}
	
	public static boolean hamCycleRecur(boolean[] visited,int[][] graph, int[]path, int current ,int visitedNodesNum){
		if(visitedNodesNum==graph.length-1){
			if(graph[current][path[0]]==1){
				path[visitedNodesNum]=current;
				return true;
			}else{
				return false;
			}
		}else{
			for(int i=0;i<graph.length;i++){
				if(graph[current][i]==1 && !visited[i]){
					path[visitedNodesNum] = current;
					visited[current] = true;
					if(hamCycleRecur(visited,graph,path,i,visitedNodesNum+1)){
						return true;
					}else{
						visited[current] = false;
					}
				}
			}
			return false;
		}
	}
    public static void main(String args[])
    {
        HamiltonianCycle hamiltonian = new HamiltonianCycle();
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
 
        // Print the solution
        hamiltonian.hamCycle(graph1);
 
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
        };
 
        // Print the solution
        hamiltonian.hamCycle(graph2);
    }
}
