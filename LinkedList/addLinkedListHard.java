package LinkedList;

public class addLinkedListHard {
	
	
	public Node add(Node head1, Node head2, Integer carry) {
		if(head1 == null || head2 == null) {
			carry = 0;
			return null;
		} else {
			Integer curCarry = new Integer(0);
			Node output = add(head1.next, head2.next, curCarry);
			carry = (curCarry+head1.data+head2.data)/10;
			Node cur = new Node((curCarry+head1.data+head2.data)%10);
			cur.next = output;
			return cur;
		}
	}
	
	 public static Node add(Node head1, Node head2){
		 if(head1 == null && head2==null){
			 return null;
		 }else if(head1 == null){
			 return head2;
		 }else if(head2 == null){
			 return head1;
		 }else {
			 
			 int len1 = findLength(head1);
			 int len2 = findLength(head2);
			 
			
			 Node iter1 = head1;
			 Node iter2 = head2;
			 Node sum_prev= null;
			 Node prev =null;
			 Node curr1 = null;
			 Node curr2 = null;
			
			 if(len1 - len2 == 0){
				 sum_prev = addEqualLengths(head1,head2);
			 }else if(len1>len2){
				 int len= len1;
				 while(len != len2){
					curr1=iter1;
					iter1 = iter1.next;
					len--; 
				 }
				 sum_prev=addEqualLengths(iter1,iter2);
			 }else{
				 int len= len2;
				 while(len1!= len){
					curr2 = iter2; 
					iter2 = iter2.next;
					len--; 
				 }
				 sum_prev= addEqualLengths(iter1,iter2);
			 }
			 
			 int carry = 0;
			 carry = sum_prev.data/10;
			 sum_prev.data = sum_prev.data%10;
			 Node carry_sum = null;
			 if(len1==len2){
				 if(carry>0){
					 Node firstNode = new Node(carry);
					 firstNode.next = sum_prev;
					 return firstNode;
				 }else{
					 return sum_prev;
				 }
			 }else if(len1>len2){
				 carry_sum = addCarry(head1,curr1,carry);
				  
			 }else{
				 carry_sum = addCarry(head2,curr2,carry);
			 }
			 
			 carry = carry_sum.data/10;
			 carry_sum.data = carry_sum.data%10;
			 Node carry_node = null;
			 if(carry>0){
				 carry_node = new Node(carry);
				 carry_node.next = carry_sum;
			 }else{
				 carry_node=carry_sum;
			 }
			 Node firstnode = carry_node;
			 while(carry_node.next != null)
				 carry_node = carry_node.next;
			 carry_node.next = sum_prev;
			 return firstnode;
		 }
			
	 }
	 
	 public static int findLength(Node head){
		 if(head == null){
			 return 0;
		 }else{
			 int count = 0;
			 Node iter = head;
			 while(iter != null){
				 count++;
				 iter=iter.next;
			 }
			 return count;
			 
		 }
	 }
	 
	 public static Node addEqualLengths(Node head1,Node head2){
		 if(head1 == null && head2==null){
			 return null;
		 }else if(head1.next == null && head2.next==null){
			 Node sum= new Node(head1.data+head2.data);
			 return sum;
		 }else{
			 Node sum_prev = addEqualLengths(head1.next,head2.next);
			 int carry = sum_prev.data/10;
			 sum_prev.data = sum_prev.data%10;
			 Node sum_this_node = new Node(carry + head1.data + head2.data);
			 sum_this_node.next=sum_prev;
			 return sum_this_node;
		 }
		 
	 }
	 
	 public static Node addCarry(Node head,Node curr,int carry){
		 if(head == curr ){
			 return new Node(head.data+carry);
	     }else{
			 Node sum_prev= addCarry(head.next,curr,carry);
			 carry = sum_prev.data/10;
			 sum_prev.data = sum_prev.data%10;
			 Node sum_curr = new Node(head.data + carry);
			 sum_curr.next =sum_prev;
			 return sum_curr;
		 }
	 }
	 
	 public static void main(String[] arg){
			LinkedList llist1 = new LinkedList();
			llist1.insert(2);
			llist1.insert(6);
			llist1.insert(5);
			
			LinkedList llist2 = new LinkedList();
			llist2.insert(1);
			llist2.insert(8);
			llist2.insert(9);
			llist2.insert(4);
			
			
			
			LinkedList llist3 =  new LinkedList();
			llist3.head = add(llist1.head,llist2.head);
		    llist3.printList();
		
	}


}
