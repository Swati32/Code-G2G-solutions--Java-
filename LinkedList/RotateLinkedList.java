package LinkedList;

public class RotateLinkedList {
	public static Node rotate(Node head,int k){
		if(head==null|| k<=0) return head;
		int count =1;
		Node iter = head;
		Node head_original = head;
		while(iter.next !=null){
			if(count==k){
				head=iter.next;
				iter.next=null;
				iter=head;
				count++;               //you forgot this condition.You shouldnt have ! Dry run more carefully idiot !
				continue;
			}
			count++;
			iter=iter.next;
		}
		if(count>k){
			iter.next = head_original;
		}else{
			return rotate(head,k%count);
		}
		
		return head;
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
		llist1.head = rotate(llist1.head,9);
		System.out.println();
		llist1.printList();
	}
}
