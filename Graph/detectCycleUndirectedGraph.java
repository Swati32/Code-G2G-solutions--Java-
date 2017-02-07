package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class detectCycleUndirectedGraph {
	int v;
	LinkedList<Integer> adj[];
	//constructor
	public detectCycleUndirectedGraph(int V){
		this.v= V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	//function to add edge - since its undirected graph ,we add to both nodes
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}

	public boolean isCyclic(){
		for(int i=0;i<v;i++){
			boolean[] visited = new boolean[v];
			if(dfs(i,-1,visited)){
				return true;
			}	
		}
		return false;
	}
	
	public boolean dfs(int node, int parent,boolean[] visited){
		if(visited[node]){
			return true;
		}else{
			visited[node] = true;
			Iterator<Integer> iter = adj[node].listIterator();
			while(iter.hasNext()){
				int elem = iter.next();
				if(elem != parent){
					if(dfs(elem,node,visited)){
						return true;
					}
				}
			}
			return false;
		}
	}
	public static void main(String[] arg){
		detectCycleUndirectedGraph g = new detectCycleUndirectedGraph(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(2, 3);
	    g.addEdge(3, 0);
	    
	    if(g.isCyclic())
	        System.out.println("Graph contains cycle");
	    else
	    	System.out.println("Graph doesn't contain cycle");
	    
	}
}
