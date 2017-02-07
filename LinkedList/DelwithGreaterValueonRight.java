package LinkedList;

public class DelwithGreaterValueonRight {
	public static Node delGreater(Node head){
		if(head == null||head.next == null){
			return head;
		}else{
			Node greatBefore = delGreater(head.next);
			if(greatBefore.data>head.data)
				return greatBefore;
			else{
				head.next = greatBefore;
				return head;
			}
		}
	}
	
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
	    l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insert(40);
        l.insert(70);
        
        
       
        l.head=delGreater(l.head);
        l.printList();
	}

}
