package LinkedList;

public class alternateMerging {

	public static Node mergeAlternates(Node head1 , Node head2){
		if(head1 == null || head2 == null){
			return null;
		}else{
			Node temp1 = head1.next;
			Node temp2 = head2.next;
			head1.next = head2;
			head2.next = mergeAlternates(temp1,temp2);
			return head1;
		}
	}
	
	   public static void main(String[] arg){
				LinkedList llist1 = new LinkedList();
				llist1.insert(2);
				llist1.insert(6);
				llist1.insert(5);
				llist1.insert(5);
				
				
				
				LinkedList llist2 = new LinkedList();
				llist2.insert(3);
				llist2.insert(6);
				llist2.insert(1);
				
				
				LinkedList llist3 = new LinkedList();
				llist3.head= mergeAlternates(llist1.head,llist2.head);
				llist3.printList();
	   }
}
