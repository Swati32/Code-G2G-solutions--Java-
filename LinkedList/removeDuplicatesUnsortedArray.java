package LinkedList;

import java.util.HashMap;

public class removeDuplicatesUnsortedArray {           
	public static void removeDuplicates(Node head){
		if(head ==null ||head.next == null) return ;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Node prev = head;
		Node curr =head.next;
		map.put(head.data, 1);
		while(curr.next != null){
			if(map.containsKey(curr.data)){
				prev.next=curr.next;
			}else{
				map.put(curr.data, 1);
				prev=curr;
			}
			curr=curr.next;
		}
		prev.next = null;
	}
	public static void removeDuplicatesLoop(Node head){
		if(head ==null ||head.next == null) return ;
		Node curr = head;
		Node prev = curr;
		while(curr.next != null){
			int data = curr.data;
			Node inner_curr = curr.next;
			prev =curr;
			while(inner_curr != null){
				if(inner_curr.next !=null && inner_curr.data == data){
					inner_curr = inner_curr.next;
				}else if(inner_curr.next ==null && inner_curr.data == data){
					prev.next=null;
					inner_curr = inner_curr.next;
				}else{
					prev.next = inner_curr;
					prev = inner_curr;
					inner_curr = inner_curr.next;
				}
			}
			
			curr=curr.next;
		}
		
		
	}
	public static void main(String[] arg){ 
  	  LinkedList l = new LinkedList();
  	  l.insert(7);
  	  l.insert(2);
  	  l.insert(2);
  	  l.insert(7);
  	  l.insert(7);
  	  l.insert(7);
  	  l.insert(2);
  	  l.insert(9);
  	  l.insert(9);
  	  
  	  
  	  l.printList();
  	  //removeDuplicates(l.head);
  	removeDuplicatesLoop(l.head);
  	  System.out.println();
  	  l.printList();
  	  
    }
}
