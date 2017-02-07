package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class detectCycleInGraph {

	int v;
	LinkedList<Integer> adj[];
	
	public detectCycleInGraph(int V){
		this.v= V;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	public boolean isCyclic(){
		if(v==0){
			return false;
		}else{
			
			for(int i=0;i<v;i++){
				boolean visited[] = new boolean[v];
				if(dfs(i,visited)){
					return true;
				}
			}
			return false;
		}
	}
	public boolean dfs(int node,boolean[] visited){
		if(visited[node]){
			return true;
		}else{
			visited[node] = true;
			Iterator<Integer> iter = adj[node].listIterator();
			while(iter.hasNext()){
				int elem = iter.next();
				if(dfs(elem,visited)){
					return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] arg){
		detectCycleInGraph g = new detectCycleInGraph(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(2, 3);
	    
	    if(g.isCyclic())
	        System.out.println("Graph contains cycle");
	    else
	    	System.out.println("Graph doesn't contain cycle");
	    
	}
}
