package Stacks;

public class Deque {
     public static class dllNode{
    	 int data;
    	 dllNode prev;
    	 dllNode next;
    	 dllNode(int m){
    		 this.data = m;
    		 prev=next =null;
    	 }
     }
     
     public static class Dqueue{
    	dllNode front;
    	dllNode rear;
    	public void insertFront(int m){
    		if(front == null){
    			front = rear = new dllNode(m);
    		}else{
    			dllNode newNode = new dllNode(m);
    			newNode.next = front;
    			front.prev = newNode;
    			front=newNode;
    		}
    	}
    	public void insertLast(int m){
    		if(front == null){
    			front = rear = new dllNode(m);
    		}else{
    			dllNode newNode= new dllNode(m);
    			newNode.prev = rear;
    			rear.next = newNode;
    			rear = rear.next;
    		}
    	}
    	
    	public void deleteFront(){
    		if(front ==null){
    			System.out.println("Empty Queue");
    		}else if(front.next == null){
    			front = rear = null;                         //when last element important, will error out if you dont handle
    		}else{
    		
    			dllNode temp = front.next;
    			temp.prev =null;
    			front.next =null;
    			front = temp;
    		}
    	}
    	
    	public void deleteLast(){
    		if(front ==null){
    			System.out.println("Empty Queue");              
    		}else if(front.next == null){
    			front = rear = null;                       //when last element important , will error out if you dont handle
    		}else{
    			dllNode temp = rear.prev;
    			temp.next = null;
    			rear.prev = null;
    			rear = temp;
    		}
    	}
    	
    	public boolean isEmpty(){
    		return (front==null);
    	}
    	
    	public int getFront(){
    		if(isEmpty()){
    			System.out.println("Empty Queue");
    			return -1;
    		}else{
    			return front.data;
    		}
    	}
    	
    	public int getRear(){
    		if(isEmpty()){
    			System.out.println("Empty Queue");
    			return -1;
    		}else{
    			return rear.data;
    		}
    	}
    	
    	public void print(){
    		if(isEmpty()){
    			System.out.println("Empty");
    		}else{
    			dllNode curr = front;
    			while(curr != null){
    				System.out.print(curr.data+"-->");
    				curr = curr.next;
    			}
    			System.out.println();
    		}
    	}
     }
     
     public static void main(String[] arg){
    	 Dqueue d = new Dqueue();
    	 d.insertFront(1);
    	 d.insertFront(9);
    	 d.insertFront(8);
    	 d.insertLast(6);
    	 d.insertLast(3);
    	 d.insertLast(0);
    	 d.print();
    	 d.deleteFront();
    	 d.print();
    	 System.out.println(d.getFront());
    	 System.out.println(d.getRear());
    	 d.deleteFront();
    	 d.print();
    	 d.deleteFront();
    	 d.print();
    	 d.deleteFront();
    	 d.print();
    	 d.deleteFront();
    	 d.print();
    	 d.deleteFront();
    	 d.print();
    
     }
 
}
