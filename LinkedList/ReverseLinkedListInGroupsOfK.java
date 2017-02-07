package LinkedList;

public class ReverseLinkedListInGroupsOfK {
	public static Node reverseInGroups(Node head,int k){
		if(head == null || k<1) {
			return head;
		}else{
			Node iter = head;
			//Move forward k elements 
			for(int i=1;i<k && iter!=null;i++){  //See when you initialize as head and iterate once you already covered two elems
				iter = iter.next;                // iterate k-1 times for k elements
			}
			Node Nexthead = null;
			
			//set to null if kth elements next is not already null but get next node before that
			if(iter != null){
				Nexthead = iter.next;
				iter.next =null;
			}
			
			Node reversedhead = reverse(head);
			head.next = reverseInGroups(Nexthead,k);
			return reversedhead;
		}
	
	}
	
	public static Node reverse(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node iter = head;
			Node prev = null;
			while(iter != null){
				Node temp = iter.next;
				iter.next = prev;
				prev = iter;
				iter = temp;
			}
			return prev;
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
 			llist1.head = reverseInGroups(llist1.head,6);
 			llist1.printList();
 		
 	}
}
	


