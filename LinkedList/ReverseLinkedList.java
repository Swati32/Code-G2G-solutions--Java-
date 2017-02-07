package LinkedList;

public class ReverseLinkedList {

	public static Node iterativeMethod(Node head){             //head ka value you cant change directly unless you pass a reference remember !
		if(head==null || head.next == null) return null;
		Node temp = null;
		Node curr = head;
		Node prev = null;
		
		while(curr != null){
			
			temp =curr.next;
			curr.next = prev;
			prev=curr;
			curr=temp;
			
		}
		
		head = prev;
		return head;
	}
	
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
		l.insert(5);
		l.insert(10);
		l.insert(99);
		l.insert(65);
		l.insert(4);
		
		l.printList();
		l.head = iterativeMethod(l.head);
		System.out.println("\n");
		l.printList();
		
		
	}
}
