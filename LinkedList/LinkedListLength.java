package LinkedList;

public class LinkedListLength {
	
	public static int findLength(Node head){
		if(head == null ) return 0;
		int count =0;
		Node p = head;
		while(p !=null){
			count++;
			p=p.next;
		}
		return count;
	}
	
	public static void main(String[] arg){
             LinkedList llist = new LinkedList();
             
             llist.insert(6);
             llist.insert(1);
 	         llist.insert(3);
 	         llist.insert(2);
 	         
 	         int length = findLength(llist.head);
 	         System.out.println(length);
	}   
}
