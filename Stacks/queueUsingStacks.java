package Stacks;

import java.util.Stack;

public class queueUsingStacks {
       static class Queue{
    	   Stack<Integer> st_enqueue;
    	   Stack<Integer> st_dequeue;
    	   public Queue(){
    		   st_enqueue = new Stack<Integer>();
    		   st_dequeue = new Stack<Integer>();
    	   }
    	   public boolean isEmpty(){
    		   if(st_enqueue.isEmpty() && st_dequeue.isEmpty()){
    			   return true;
    		   }else{
    			   return false;
    		   }
    	   }
    	   
    	   public void Enqueue(int m){
    		   if(st_dequeue.isEmpty()){
    			   st_enqueue.push(m);
    		   }else{
    			   while(!st_dequeue.isEmpty()){
    				   st_enqueue.push(st_dequeue.pop());
    			   }
    			   st_enqueue.push(m);
    		   }
    	   }
    	   public int Dequeue(){
    		   if(st_enqueue.isEmpty()){
    			   if(st_dequeue.isEmpty()){
    				   System.out.println("Empty Queue");
    				   return -1;
    			   }else{
    				   return st_dequeue.pop();
    			   }
    		   }else{
    			   while(!st_enqueue.isEmpty()){
    				   st_dequeue.push(st_enqueue.pop());
    			   }
    			   return st_dequeue.pop();
    		   }
    	   }
    	   
       }
       
       public static void main(String[] arg){
    	   Queue q = new Queue();
    	   q.Enqueue(1);
    	   q.Enqueue(4);
    	   q.Enqueue(3);
    	   q.Enqueue(23);
    	   System.out.println(q.Dequeue());
    	   System.out.println(q.Dequeue());
    	   System.out.println(q.Dequeue());
    	   System.out.println(q.Dequeue());
    	   System.out.println(q.Dequeue());
       }
}
