package LinkedList;

public class InsertInSortedList {
	
	public static Node insertintoSortedList(Node head,int n){
		if(head ==null){
			head = new Node(n);
			return head;
		}
	
	   if(head.data>=n){
		   	   Node temp = head;
			   head = new Node(n);
			   head.next = temp;
	   }else{
		   
		   if(head.next == null) {
			   head.next = new Node(n);
			   
		   }else{
			   Node curr= head.next;
			   Node prev = head;
			   while(curr!=null){
				   if(n<=curr.data){
					   Node temp = new Node(n);
					   prev.next= temp;
					   temp.next = curr;
					   return head;
				   }else{
					   prev=curr;
					   curr=curr.next;
				   }
			   }
			   
			   prev.next = new Node(n);
		   }
		   
	   }
	   
		
	  
		return head;
	}
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
		 l.insert(1);       
	     l.insert(2);
	     l.insert(7);
	     l.insert(9);
	       
       
        l.head = insertintoSortedList(l.head,0);
        l.printList();
	}

}
