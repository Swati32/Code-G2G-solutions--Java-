package LinkedList;

public class Intersection {
	public static Node findIntersection(Node head1,Node head2){
		if(head1 == null || head2 == null) 
		{
			return null;
		}else{
			int length_list1 = count(head1);
			int length_list2 = count(head2);
			
		    int diff = Math.abs(length_list2-length_list1);
		    int count=0;
		    
		    if(length_list1>length_list2) {
		    	
		    	while(count != diff){
		    		head1 = head1.next;
		    		count++;
		    	}
		    }else if(length_list2>length_list1){
		    	while(count != diff){
		    		head2 = head2.next;
		    		count++;
		    	}
		    	
		    }
		    
		    while(head1 != null && head2 !=null){
		    	if(head1.data == head2.data)
		    		return head1;
		    	head1=head1.next;
		    	head2=head2.next;
		    }
		    	
			
		}
		return null;
	}
	
	
	public static int count(Node head){
		int count =0;
		while(head != null){
			count++;
			head=head.next;
		}
		return count;
	}
	
	public static void  main(String[] arg){
		LinkedList llist1 = new LinkedList();
		llist1.insert(8);
		llist1.insert(9);
		llist1.insert(16);
		llist1.insert(18);
		llist1.insert(21);
		llist1.insert(20);
		llist1.insert(30);
		
		LinkedList llist2 = new LinkedList();
		llist2.insert(7);
		llist2.insert(8);
		llist2.insert(10);
		llist2.insert(20);
		llist2.insert(30);
		
		Node intersection = findIntersection(llist1.head,llist2.head);
		System.out.println(intersection.data);
		
	}

}
