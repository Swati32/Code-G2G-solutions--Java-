package LinkedList;

import java.util.Stack;

public class FlattenMultilevelLinkedList {
	static class Node{
		  int data;
		  Node next;
		  Node down;
		 public Node(int data){
			 this.data = data;
			 this.next = null;
			 this.down = null;
		 }
		
	}
	
	public static Node Flatten(Node head){
		if(head == null || (head.next == null && head.down == null)){
			return head;
		}else{
			Stack<Node> st = new Stack<Node>();
			Node curr = null ,prev=null, last = null;
			st.push(head);
			while(!st.isEmpty()){
				curr = st.pop();
				if(last != null) {
					last.next = curr;
				}			
				
				while(curr!=null){
					if(curr.down != null){
						st.push(curr.down);
						curr.down = null;
					}
					prev = curr;
					curr = curr.next;
				}				
				last = prev;
			}	
			return head;
		}
	}
	
	//PAYAL ---> SAMPLE CLEAN CODE 
	
	public static Node FlattenInPlace(Node head)
	{
		Node last  = GetLast(head);
		Node curr = head;			
		
		while(curr != null){
			if(curr.down != null){
				last.next = curr.down;
				curr.down = null;
				last = GetLast(last);	
			}
			curr=curr.next;
		}
		
		return head;
	}
	
	public static Node GetLast(Node head)
	{
		Node last = head;
		while(last.next != null){
			last=last.next;
		}
		return last;
	}
	
	
	public static void main(String[] arg){
		
		
		Node head = new Node(1);
		head.next = new Node(6);
		head.down = new Node(3);
		head.next.next = new Node(5);
		head.next.down = new Node(4);
		head.down.next = new Node(7);
		head.down.down = new Node(2);
		head = FlattenInPlace(head);
		while(head != null){
			System.out.print(head.data+ " ");
			head = head.next;
		}
	}
}
