package LinkedList;

public class MoveLastElementToFront {
	
	public static Node MoveLastToFront(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node iter = head.next;
			Node prev = head;
			while(iter.next != null){
				prev= iter;
				iter = iter.next;
			}
			prev.next = null;
			iter.next =head;
			head = iter;
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
			
			llist1.printList();
			System.out.println();
			llist1.head = MoveLastToFront(llist1.head);
			llist1.printList();
		
	}
}
