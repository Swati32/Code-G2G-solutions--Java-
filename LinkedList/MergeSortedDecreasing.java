package LinkedList;
/*
 * Iterative Procedure
 * Create a node res_head -->final head
 * iterate through list element by element
 * pick smaller one each time make it head and attach res_head to it
 * go to next one
 */

public class MergeSortedDecreasing {
	public static Node Merge(Node head1,Node head2){
		if(head1 == null && head2 == null){
			return null;
		}else{
			//Merge
			Node res_head = null;
			while(head1 != null && head2 != null){
				if(head1.data >head2.data){
					if(res_head == null){
						res_head = head2;
						head2 = head2.next;
						res_head.next =null;
						
					}else{
						Node temp = head2.next;          // store next one for iteration
						head2.next =res_head;            // attach res_head  to this node
						res_head = head2;                // make this node the head
						head2 =temp;                     // iterate to next one
					}
				}else{
					if(res_head == null){
						res_head = head1;
						head1=head1.next;
						res_head.next =null;
					}else{
						Node temp = head1.next;
						head1.next = res_head;
						res_head = head1;
						head1 = temp;
					}	
				}
			}
			//Simply reverse remaining elements
			if(head1 != null){
				while(head1!=null){
					Node temp = head1.next;
					head1.next = res_head;
					res_head = head1;
					head1 = temp;
				}
			}else{
				while(head2!=null){
					Node temp = head2.next;
					head2.next =res_head;
					res_head = head1;
					head2 =temp;
				}
			}
			
			return res_head;
		}
	}
		
	public static Node reverse(Node head , Node prev){
			if(head == null || head.next == null){
				head.next = prev;
				return head;
			}else{
		        Node temp = head.next;
		        head.next = prev;
		        prev= head;
		        head= temp;
		        return reverse(head,prev);
			}
		}
	
	   public static void main(String[] arg){
			LinkedList llist1 = new LinkedList();
			llist1.insert(2);
			llist1.insert(5);
			llist1.insert(6);
			
			llist1.printList();
			
			System.out.println("");
			LinkedList llist2 = new LinkedList();
			llist2.insert(1);
			llist2.insert(3);
			llist2.printList();

			System.out.println("");
			LinkedList llist3 = new LinkedList();
			llist3.head= Merge(llist1.head,llist2.head);
			llist3.printList();
  }
		
		
}
 
   
	
	
	
	


