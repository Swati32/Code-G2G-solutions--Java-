package Graph;

public class FloydMarshallShortestPath {
	final static int INF = 9999;
	
	public static void main (String[] args)
    {
        
        int graph[][] = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
                        };
        FloydMarshallShortestPath a = new FloydMarshallShortestPath();
 
        // Print the solution
        a.findShortestPath(graph);
    }

	private void findShortestPath(int[][] graph) {
		int V = graph.length;
		int path[][] = new int[V][V];
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				path[i][j]=graph[i][j];
			}
		}
		
		for(int k=0; k<V; k++){
			for(int i =0; i <V; i++){
				for(int j=0; j<V; j++){
					if(path[i][k]+path[k][j]<path[i][j]){
						path[i][j] = path[i][k]+path[k][j];
					}
				}
			}
		}
		
		printSolution(path);
	}
	 void printSolution(int dist[][])
	    {
		    int V = dist.length;
	        System.out.println("Following matrix shows the shortest "+
	                         "distances between every pair of vertices");
	        for (int i=0; i<V; ++i)
	        {
	            for (int j=0; j<V; ++j)
	            {
	                if (dist[i][j]==INF)
	                    System.out.print("INF ");
	                else
	                    System.out.print(dist[i][j]+"   ");
	            }
	            System.out.println();
	        }
	    }
}
