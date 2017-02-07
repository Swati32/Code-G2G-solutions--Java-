package LinkedList;



public class LinkedList {
       Node head;
       
		public void insert(int data){
			Node newNode = new Node(data);
			if(head==null){
				head = newNode;
				return;
			}	
			Node n = head;
			while(n.next != null)
				n=n.next;
			
			n.next = newNode;
			return;
		}
		
		public  void delete(int data){
			Node prev,curr,temp;
			if(head == null)
				return ;
			
			if(head.data == data){
				head = head.next;
				return;
			}
			
			curr=head.next;
			prev=head;

			while(curr.next !=null){
				if(curr.data==data) {
					prev.next=curr.next;
					return;
				}
				prev=curr;
				curr=curr.next;
		    }
			
		}
		
	    public void printList()
	    {
	        Node n = head;
	        while (n != null)
	        {
	            System.out.print(n.data+"->");
	            n = n.next;
	        }
	    }
}
