package LinkedList;

public class MergeLinkedLists {
	
	public static Node Merge(Node head1,Node head2){
		if(head1 == null && head2 == null) return null;
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		Node head = null;
		Node p = head1;
		Node q = head2;
		
		if(head1.data<head2.data) {
			head = head1;
		    p=p.next;
		}else {
			head=head2;
			q=q.next;
		}
		
		Node prev = head;
		while(p!=null && q!=null){
			if(p.data<q.data){
				prev.next = p;
				prev=p;
				p=p.next;
			}else{
				prev.next =q;
				prev = q;
				q=q.next;
			}
		}
		
		if(p==null && q==null) return head;
		if(p==null) {
			while(q!=null){
				prev.next =q;
				prev=q;
				q=q.next;
			}
		}else{
			while(p!=null){
				prev.next =p;
				prev=p;
				p=p.next;
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
       
        l.printList();
        LinkedList l2 = new LinkedList();
        
        l2.insert(6);
        l2.insert(9);
        l2.insert(11);
        System.out.println("\n");
        l2.printList();
        //l.head.next.next.next.next = l.head;
        LinkedList l3 = new LinkedList();
        l3.head = Merge(l.head,l2.head);
        System.out.println("\n");
        l3.printList();
	}
}
