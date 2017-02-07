package LinkedList;

public class ZigZag {
      public static Node zigzag(Node head){
    	  if(head ==null || head.next == null){
    		  return head;
    	  }else{
    		  int ascending = 1;
    		  Node prev = head;
    		  Node curr = head.next;
    		  Node result= head;
    		  while(curr!=null){
    			  if((ascending==1 && prev.data>curr.data) || (ascending==0 && prev.data<curr.data)){
    				  int temp= prev.data;
    				  prev.data = curr.data;
    				  curr.data = temp;
    				  prev = curr;
    				  curr = curr.next;
    			  }else{
    				  prev=curr;
    				  curr = curr.next;
    			  }
    			  if(ascending==1){
    				  ascending=0;
    			  }else{
    				  ascending=1;
    			  }
    		  }
    		  return result;
    	  }
      }
      
      public static void main(String[] arg){
    	  LinkedList llist1 = new LinkedList();
    	  	llist1.insert(6);
	        llist1.insert(1);
	        llist1.insert(3);
	        llist1.insert(30);
	        llist1.insert(90);
	        llist1.insert(110);
	        llist1.insert(120);
	        
	        llist1.printList();
	        System.out.println();
			llist1.head= zigzag(llist1.head);
			llist1.printList();
      }
}
