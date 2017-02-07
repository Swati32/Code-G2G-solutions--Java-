package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class MotherVertice {
	private int v;
	private LinkedList<Integer> adj[];
	
	public void addEdge(int v,int w){
		adj[v].add(w);
	}
	
	public MotherVertice(int v){
		this.v =v;
		adj = new LinkedList[this.v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public int findMotherVertex(){
		boolean visited[] = new boolean[v];
		int lastdfssource = -1;
		//call dfs on each node that has not been previously visited
		for(int i=0;i<v;i++){
			if(!visited[i]){
				dfs(i,visited);
				lastdfssource = i;
			}
		}
		//done.Now lastdfssource can be a mothe vertex or it might be some doscnnected node
		//how to make sure ? run dfs again of lastdfsnode
		
		for(int i=0 ; i<v ;i++){
			visited[i] = false;
		}
		dfs(lastdfssource,visited);
		for(int i=0;i<v;i++){
			if(!visited[i]){
				return -1;
			}
		}
		return lastdfssource;
	}
	public void dfs(int node,boolean[] visited){
		if(visited[node]){
			return;
		}else{
			visited[node] = true;
			Iterator<Integer> iter = adj[node].listIterator();
			while(iter.hasNext()){
				int elem = iter.next();
				dfs(elem,visited);
			}			
		}
	}
	public static void main(String[] arg){
		MotherVertice g = new MotherVertice(7);
		    g.addEdge(0, 1);
		    g.addEdge(0, 2);
		    g.addEdge(1, 3);
		    g.addEdge(4, 1);
		    g.addEdge(6, 4);
		    g.addEdge(5, 6);
		    g.addEdge(5, 2);
		    g.addEdge(6, 0);
		    System.out.println(g.findMotherVertex());
	}
}
