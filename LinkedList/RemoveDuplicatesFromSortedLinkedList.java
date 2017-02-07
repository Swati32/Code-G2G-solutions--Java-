package LinkedList;

public class RemoveDuplicatesFromSortedLinkedList {
          public static void removeDuplicates(Node head){
        	  if(head == null || head.next == null) return;
        	  Node first = head;
        	  Node curr = head;
        	  
        	  while(curr !=null){
        		  while(curr.next != null && curr.data==first.data){
        			  curr=curr.next;
        		  }
        		  if(curr.next!=null){
        			  first.next = curr;
        		      first = curr;
        		  }else{
        			  first.next =null;
        			  break;
        		  }
        	  }
        	  
        	  return;
          }
      
          
          public static void main(String[] arg){
        	  LinkedList l = new LinkedList();
        	  l.insert(2);
        	  l.insert(2);
        	  l.insert(7);
        	  l.insert(7);
        	  l.insert(7);
        	  l.insert(9);
        	  l.insert(9);
        	  
        	  
        	  l.printList();
        	  removeDuplicates(l.head);
        	  System.out.println();
        	  l.printList();
        	  
          }
}
