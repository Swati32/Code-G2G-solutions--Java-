package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	int V;
	LinkedList<Integer> adj[];

	public DFS(int v){
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	public void printDFS(int node){
		boolean visited[] = new boolean[V];
		DFSRecur(node, visited);
	}
	public void DFSRecur(int node , boolean visited[]){
		if(visited[node]){
			return;
		}else{
			System.out.print(node+" ");
			visited[node] = true;
			Iterator<Integer> iter = adj[node].listIterator();
			while(iter.hasNext()){
				DFSRecur(iter.next(),visited);
			}
		}
	}
     
	public static void main(String[] arg){

        DFS g = new DFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.printDFS(2);
	}
	
}
