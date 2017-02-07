package LinkedList;

public class alternateNodesDeletion {
   public static void deleteAlternate(Node head){
	   if(head==null||head.next==null){
		   return;
	   }else{
		   Node iter = head;
		   while(iter !=null && iter.next!=null){
			   iter.next = iter.next.next;
			   iter = iter.next;
		   }
		   
	   }
	   
   }
   
   public static void main(String[] arg){
		LinkedList llist1 = new LinkedList();
		llist1.insert(23);
		llist1.insert(6);
		llist1.insert(52);
		llist1.insert(5);
		llist1.insert(13);
		llist1.insert(9);
		llist1.insert(2);
		
		llist1.printList();
		System.out.println();
		deleteAlternate(llist1.head);
		System.out.println();
		llist1.printList();
	}
	
}
