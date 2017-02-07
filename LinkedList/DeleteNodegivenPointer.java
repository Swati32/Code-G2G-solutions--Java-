package LinkedList;

public class DeleteNodegivenPointer {

	/*public static Node delete(Node head,Node del){
		if(head == null)  return null;
		if(del == null) return head;
		if(del.next !=null){
			del.data= del.next.data;
		    del.next =del.next.next;
			
		}else {
			Node prev = head;
			while(prev!=null && prev.next != del){
				prev = prev.next;
			}
			
			prev.next = null;
			
		}		
		
	    
		return head;
		
	}*/
	
	public static Node delete(Node head, Node del) {
		if(head == null) {
			return null;
		} else if(del == null) {
			return head;
		} else if(head == del) {
			return head.next;
		} else {
			head.next = delete(head.next, del);
			return head;
		}
	}
	
	
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
		 l.insert(1);       
	     l.insert(2);
	     l.insert(7);
	     l.insert(9);
	       
       
        l.head = delete(l.head,l.head.next.next);
        l.printList();
	}
}
