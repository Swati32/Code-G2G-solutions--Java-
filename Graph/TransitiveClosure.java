package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class TransitiveClosure {
	private int V;
	private LinkedList<Integer> adj[];
	
	public TransitiveClosure(int V){
		this.V= V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	//Based on Floyd Marshall
	public void findClosure(){
		boolean closure[][] = new boolean[V][V];
		for(int i=0;i<V;i++){
			closure[i][i] = true;
			Iterator<Integer> iter = adj[i].listIterator(); //remember generics
			while(iter.hasNext()){
				int elem = iter.next();
				closure[i][elem] = true;
			}
		}
		
		for(int k=0;k<V;k++){
			for(int i=0;i<V;i++){
				for(int j=0;j<V;j++){
					if(!closure[i][j]){
						if(closure[i][k] && closure[k][j]){
							closure[i][j]=true;
						}
					}
				}
			}
		}
		printSolution(closure);
	}
	//We can do better,using dfs
	
	public void findClosuredfs(){
		boolean closure[][] = new boolean[V][V];
		for(int i=0; i<V;i++){
		    dfs(i,i,closure);
		   
		}
		printSolution(closure);
	}
	
	public void dfs(int root,int node, boolean[][] closure){
		
		closure[root][node] = true;
		Iterator<Integer> iter = adj[node].listIterator();
		while(iter.hasNext()){
			int elem =  iter.next();
			   if(!closure[root][elem]){
				 dfs(root,elem,closure);
			}
		}
	}
	
	public static void main(String[] arg){
		TransitiveClosure g = new TransitiveClosure(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    g.findClosure();
	    g.findClosuredfs();
	}

	void printSolution(boolean closure[][])
    {
	   
        System.out.println("Following matrix shows the closure "+
                         "between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (closure[i][j])
                    System.out.print(1+" ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }
    }
}
