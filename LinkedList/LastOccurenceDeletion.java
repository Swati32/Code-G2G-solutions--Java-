package LinkedList;

public class LastOccurenceDeletion {
	
	public static Node delLastOccurence(Node head,int m){
		if(head == null) {
			return head;
		}else {
			Node curr =head;
			Node last = null;
			
			while(curr.next.next != null){     //stop at second last elem
				if(curr.data == m)
					last= curr;
				curr= curr.next;	
			}
			if(curr.next.data == m) {     //if last elem =  m 
				curr.next = null;
				return head;
			}
			if(last==head) return head.next; // if head is first and last occurence
			
			System.out.println("\n"+last.data);
			
			last.data = last.next.data;
			last.next = last.next.next;
			
			return head;
		}
	}
	
	
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
          
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.insert(6);
        llist.insert(5);
        llist.insert(4);
        llist.insert(4);
        llist.insert(2);
        llist.insert(1);
        llist.insert(0);
          
        System.out.println("Original List :");
        llist.printList();
          
        llist.head = delLastOccurence(llist.head,6);
      
        System.out.println("Sorted list :");
        llist.printList();
    }
}
