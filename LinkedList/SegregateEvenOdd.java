package LinkedList;

public class SegregateEvenOdd {
	
	public static Node segregate(Node head){
		if(head == null || head.next == null) {
			return head;
		}else{
			Node iter = head;
			Node even_first = null;
			Node odd_first = null;
			Node even_curr =null;
			Node odd_curr = null;
			
			while(iter != null){                 //conditions think carefully before you write ; dry run once after writing carefully
				if(iter.data %2 == 0){
					if(even_first == null){
						even_first=even_curr = iter;
					}else{
						even_curr.next = iter;
						even_curr= even_curr.next;
					}
				}else{
					if(odd_first == null){
						odd_first=odd_curr= iter;
					}else{
						odd_curr.next = iter;
						odd_curr=odd_curr.next;
					}
				}
				iter = iter.next;
			}
			
			if(odd_curr != null){
				odd_curr.next = null; //very important
			}
			
			if(even_first !=null){
				head = even_first;
				even_curr.next = odd_first;
			}else{
				head = odd_first;
			}
			
			return head;
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
		llist1.insert(2);
		llist1.printList();
		System.out.println();
		llist1.head = segregate(llist1.head);
		System.out.println();
		llist1.printList();
	}

}
