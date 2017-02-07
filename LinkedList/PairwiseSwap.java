package LinkedList;

public class PairwiseSwap {

	public static Node swap(Node head){
		if(head == null || head.next == null){ //base case
			return head;
		}else{
			Node temp = head.next;
			head.next= swap(head.next.next);
			temp.next =  head; //you forgot this but causght it during dry run.Good ! But yo can do better
			head= temp;
			return head;
		}
	}
	
	public static Node swapIterative(Node head){
		if(head == null || head.next == null){ //base case
			return head;
		}else{
			Node final_head = head.next;
			Node prev_first = null;
			Node first = head;
			Node second = head.next; 
			while(first != null && second !=null && second.next != null){
			
				Node next_second = second.next.next;
				Node next_first = second.next;
				second.next = first;
				first.next = next_second;
				prev_first = first;
				first = next_first;
				second = next_second;
			}
			if(first != null){
				prev_first.next = first;
			}
			return final_head;
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
		//llist1.head = swap(llist1.head);
		//System.out.println();
		//llist1.printList();
		llist1.head = swapIterative(llist1.head);
		System.out.println();
		llist1.printList();
				
	}
	
}
