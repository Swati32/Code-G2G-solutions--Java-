package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
		private int V;
		private LinkedList<Integer> adj[];
		
		BFS(int v){
			this.V = v;
			adj = new LinkedList[V];
			for(int i=0 ;i<v;i++){
				 adj[i] = new LinkedList<Integer>();
			}
		}
		void addEdge(int v,int w){
			adj[v].add(w);
		}
		
		void printBFS(int node){
			boolean[] visited = new boolean[V];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(node);
			visited[node] = true;
			while(!q.isEmpty()){
				int curr= q.remove();
				System.out.println(curr+" ");
				
				Iterator<Integer> iter = adj[curr].listIterator();
				while(iter.hasNext()){
					int v = iter.next();
					if(!visited[v]){
						q.add(v);
						visited[v]=true;
					}
				}
			}
		}
		
	public static void main(String[] arg){
		BFS g = new BFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.printBFS(2);
	}

}
