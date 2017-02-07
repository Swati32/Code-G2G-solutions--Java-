package LinkedList;

public class nthNodeFromEnd {
	public static Node findNthFromEnd(Node head,int n){
		 if(head == null) return null;
		 Node p =head;
		 Node q = head;
		 int count = 1;
		 while(q.next !=null){
			 if(count >= n)
				 p=p.next;
			 q=q.next;
			 count++;
		 }
		 
		 if(count<n) return null ;else return p;
		
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
        
       
        Node nth =findNthFromEnd(l.head,5);
        System.out.println(nth.data);

}

}
