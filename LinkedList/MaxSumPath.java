package LinkedList;

public class MaxSumPath {
	   public static Node MaxPath(Node head1,Node head2){
		   if(head1 == null && head2 ==  null){
			   return null;
		   }else if(head1 == null &&  head2 !=null){
			   return head2;
		   }else if(head1 != null && head2 == null){
			   return head1;
		   }else{
			   Node result = null;
			   Node curr_list1 = head1;
			   Node curr_list2 = head2;
			   Node laststop_list1 = head1;
			   Node laststop_list2 = head2;
			
			   while(curr_list1 != null || curr_list2 != null){
				   int sum1 = 0, sum2 = 0;
				   while(curr_list1 != null && curr_list2 != null && curr_list1.data != curr_list2.data){
					   if(curr_list1.data<curr_list2.data){
						   sum1 += curr_list1.data;
						   curr_list1 = curr_list1.next;
					   }else{
						   sum2 += curr_list2.data;
						   curr_list2 =curr_list2.next;
					   }
				   }
				   
		           if (curr_list1 == null)
		            {
		                while (curr_list2 != null)
		                {
		                    sum2 += curr_list2.data;
		                    curr_list2 = curr_list2.next;
		                }
		            }
		           
		           
		            if (curr_list2 == null)
		            {
		                while(curr_list1 != null)
		                {
		                    sum1 += curr_list1.data;
		                    curr_list1 = curr_list1.next;
		                }
		            }
		            
		            if(result == null){
		            	result = (sum1>sum2)? head1:head2;
		            	
		            }else{
		            	if(sum1>sum2){
		            		laststop_list2.next =  laststop_list1.next;
		            	}else{
		            		laststop_list1.next = laststop_list2.next;
		            	}
		            }
		            
		            laststop_list1=curr_list1;
	            	laststop_list2=curr_list2;
		            
	            	if(curr_list1 != null) curr_list1 =curr_list1.next;
	            	if(curr_list2 != null) curr_list2 =curr_list2.next;
			   }
			   
			   return result;
		   } 
				   
	   }
	
	
	   public static void main(String[] arg){
			LinkedList llist1 = new LinkedList();

	        llist1.insert(1);
	        llist1.insert(3);
	        llist1.insert(30);
	        llist1.insert(90);
	        llist1.insert(110);
	        llist1.insert(120);
	        //Linked List 1 : 1->3->30->90->110->120->NULL
	        //Linked List 2 : 0->3->12->32->90->100->120->130->NULL
	    	System.out.println("");
			LinkedList llist2 = new LinkedList();
			
	        llist2.insert(0);
	        llist2.insert(3);
	        llist2.insert(12);
	        llist2.insert(32);
	        llist2.insert(90);
	        llist2.insert(100);
	        llist2.insert(120);
	        llist2.insert(130);
		
			
			System.out.println("");
			LinkedList llist3 = new LinkedList(); 
			llist3.head= MaxPath(llist1.head,llist2.head);
			llist3.printList();
	   }

}
