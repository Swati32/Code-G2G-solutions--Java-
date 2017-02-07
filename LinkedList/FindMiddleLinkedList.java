package LinkedList;

public class FindMiddleLinkedList {
	
	public static Node findmiddle(Node head){
         if(head == null) return null;
         if(head.next==null) return null;
         
         Node p=head;
         Node q=head;
         
         while(q!=null && q.next !=null && q.next.next!=null){
        	 p=p.next;
        	 q=q.next.next;
         }
        	 
         return p;
	}
       
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
	    l.insert(6);
        l.insert(1);
        l.insert(3);
        l.insert(2);
        l.insert(7);
        l.insert(9);
        l.insert(5);
        l.insert(11);
        l.insert(19);
        
       
        Node mid =findmiddle(l.head);
        System.out.println(mid.data);

}
}
