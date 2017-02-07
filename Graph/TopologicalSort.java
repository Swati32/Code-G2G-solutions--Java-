package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
      static class Graph{
	   int V;
       LinkedList<Integer> adj[];
       
       Graph(int v){
    	   this.V =v;
    	   adj = new LinkedList[V];
    	   for(int i=0;i<v;i++){
    		   adj[i] = new LinkedList();
    	   }
       }
       
       public void addEdge(int v,int w){
    	   adj[v].add(w);
       }
       
       public void TopologicalSort(){
     	  boolean visited[] = new boolean[V];
     	  Stack<Integer> st  = new Stack<Integer>();
     	  
     	  //Initialize
     	  for(int i=0;i<V;i++){
     		  visited[i]=false;
     	  }
     	 
     	  //go through your entire array of vertices calling topological sort ne ach vertice
     	  for(int i=0;i<V;i++){
     		  if(!visited[i]){
     			  TopologicalSortRecur(i,st,visited);
     		  }
     	  }
     	  //pop our stack
     	  while(!st.isEmpty()){
     		  System.out.print(st.pop()+" ");
     	  }
       }
       
       //Essentially what we are doing here is first process children then yourself
       //mark yourself as true you have been visited
       //then recur on children one by one
       //finally add ourself to stack
       //you get added after your children
       
       public void TopologicalSortRecur(int node, Stack<Integer> st, boolean[] visited){
    	   if(visited[node]){
    		   return;
    	   }else{
    		   visited[node] = true;
    		   Iterator<Integer> iter = adj[node].listIterator();
      		   while(iter.hasNext()){
      			  int elem = iter.next();
      			  if(!visited[elem]){
      				  TopologicalSortRecur(elem,st,visited);
      			  }	  
      		  }
      		  st.push(node);
    	  }
       }
     }
      
      
      public static void main(String arg[]){
    	  Graph g = new Graph(6);
    	   g.addEdge(5, 2);
           g.addEdge(5, 0);
           g.addEdge(4, 0);
           g.addEdge(4, 1);
           g.addEdge(2, 3);
           g.addEdge(3, 1);
           System.out.println("Following is a Topological " +
                   "sort of the given graph");
           g.TopologicalSort();
      }
       
}
