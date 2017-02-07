package LinkedList;

public class addLinkedListEasy {

	 public static Node addRecursion( Node head1,Node head2,int carry){
		 if(head1 == null && head2==null){
			 if(carry == 0){
				 return null;
			 }else{
				 Node carry_over = new Node(carry);
				 return carry_over;
			 }
		 }else{
			 int digit1= 0;
			 int digit2 =0;
			 Node nextHead1 = null;
			 Node nextHead2 = null;
			 if(head1 !=null) digit1 = head1.data;
			 if(head2 !=null) digit2 = head2.data;
			 if(head1.next != null) nextHead;
		 }
	 }
	 
	 public static LinkedList add(Node head1,Node head2){
		LinkedList sum = new LinkedList();
		if(head1==null && head2==null){
			return sum;
		}else{
			Node iter1 = head1;
			Node iter2 = head2;
			Node iterSum = null;
			int carry = 0;
			
			while(iter1 != null || iter2 != null){
				int digit1 = 0;
				int digit2 = 0;
				if(iter1!=null) {
					digit1 = iter1.data;
				}
				if(iter2!=null) {
					digit2 = iter2.data;
				}

				int sum_of_nodes = digit1 + digit2 + carry;
				carry =0;
				if(sum_of_nodes>9){
					carry = sum_of_nodes/10;
					sum_of_nodes =sum_of_nodes%10;
				}
				if(sum.head == null){
					sum.head = new Node(sum_of_nodes);
					iterSum = sum.head;
				}else{
					iterSum.next = new Node(sum_of_nodes);
					iterSum = iterSum.next;
				}
				if(iter1!=null) {
					iter1 = iter1.next;
				}
				if(iter2!=null) {
					iter2 = iter2.next;
				}
			}
			if(carry !=0){
				iterSum.next = new Node(carry);
			}
			return sum;
		}
		 
	 }
	
	 public static void main(String[] arg){
			LinkedList llist1 = new LinkedList();
			llist1.insert(2);
			llist1.insert(6);
			llist1.insert(5);
			
			LinkedList llist2 = new LinkedList();
			llist2.insert(3);
			llist2.insert(9);
			llist2.insert(4);
			llist2.insert(6);
			
			
			LinkedList llist3 = add(llist1.head,llist2.head);
		    llist3.printList();
		
	}

}
	