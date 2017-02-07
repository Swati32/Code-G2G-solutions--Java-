package LinkedList;
/* Quick sort
 * - getPivot
 * - partition about pivot
 * - Quick sort for left till pivot and pivot.next till right
 * - In case of linked list bind left right  together
 * 
 *  base case  no or single element  return head
 */


public class QuickSortLinkedList {
	
	public static Node partition(Node head,Node pivot){
		if(head == null || head.next == null || pivot == null){
			return head;
		}else{
			Node curr = head;
			Node left = null;
			Node right = null;
			Node lefthead = null; //keep a track of left and right head -   makes life easier later on
			Node righthead = null;
			
			while(curr != null){                     
				if (curr==pivot){ //Important - Skip pivot while traversing
					curr = curr.next;
					continue;
				}else if(curr.data >= pivot.data){
					if(right == null){
						righthead = right = curr;
					}else{
						right.next = curr;
						right = right.next;
					}
				}else{
					if(left == null){
						lefthead = left = curr;
					}else{
						left.next = curr;
						left = left.next;
					}
				}
				curr = curr.next;
			}
			//pivot may be leftmost ,if thats case your head is pivot
			if(lefthead == null){
				lefthead = pivot;
			}else{
				left.next = pivot;
			}
			//pivot may be rightmost
			pivot.next = righthead;
			if(righthead != null ){           //check because exception will occur if you there is no right element and you are trying to set it to null
				right.next =null;                
			}
			return lefthead;
		}
	}
	
	public static Node getPivot(Node head){
		//taking middle elem as pivot
		if(head == null) {
			return null;
		}else{
			Node slow= head;
			Node fast= head;
			while(fast.next !=null && fast.next.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}
	}
	
	public static Node QuickSort(Node head){
		if(head == null || head.next == null) {
			return head;
		}else{
			Node pivot = getPivot(head);
			
			Node head_partitioned_list = partition(head,pivot);
			Node lefthead = head_partitioned_list;
			Node righthead = pivot.next;
			pivot.next =null;
			
			Node left_partitioned_list = QuickSort(lefthead);
			Node right_partitioned_list = QuickSort(righthead);
		    Node curr = left_partitioned_list;
		 
		    while(curr != null && curr.next != null){
		    	curr =curr.next;
		    }
		    
		    curr.next = right_partitioned_list;
		    return left_partitioned_list;
		}
	}
	
	public static void main(String[] args)
    {
		LinkedList llist1 = new LinkedList();
		llist1.insert(23);
		llist1.insert(6);
		llist1.insert(52);
		llist1.insert(5);
		llist1.insert(13);
		llist1.insert(9);
		llist1.insert(2);
		
		llist1.printList();
		System.out.println("");
		llist1.head = QuickSort(llist1.head);
		llist1.printList();
    }
	
}
