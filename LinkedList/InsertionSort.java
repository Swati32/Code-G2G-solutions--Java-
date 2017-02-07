package LinkedList;

public class InsertionSort {
	
	public static Node insertionsort(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node result = null;
			Node curr = head;
			while(curr!=null){
				Node Next = curr.next;
				result = insertInSortedList(result,curr);
				curr=Next;
			}
			return result;
		}
		
	}
	
	public static Node insertInSortedList(Node head,Node m){
		if(head == null){
			head = m;
			m.next=null;
			return head;
		}else{
			Node curr= head;
			if(m.data<=head.data){
				m.next=head;
				head =m;
				return head;
			}else{
				while(curr.next!=null){
					if(curr.next.data >= m.data){
						Node temp =curr.next ;
						curr.next =m;
						m.next = temp;
						return head;
					
					}
				curr =curr.next;
				}
			
			curr.next = m;
			m.next = null;
			return head;
		  }
		}
	}
    public static void main(String[] arg){
  	  LinkedList llist1 = new LinkedList();
  	  	    llist1.insert(90);
	        llist1.insert(18);
	        llist1.insert(83);
	        llist1.insert(30);
	        llist1.insert(90);
	        llist1.insert(160);
	        llist1.insert(120);
	        
	        llist1.printList();
	        System.out.println();
			llist1.head= insertionsort(llist1.head);
			llist1.printList();
    }
}
