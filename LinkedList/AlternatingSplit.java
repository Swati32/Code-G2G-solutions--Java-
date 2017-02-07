package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class AlternatingSplit {
  public static List<Node> split(Node head){
	  List<Node> res = new ArrayList<Node>();
	  if(head==null||head.next==null) {              //if cannot be split just send back the head
		  res.add(head);
		  res.add(null);
		  return res;
	  }else{
		  
		  Node head_list1= head;
		  Node head_list2= head.next;
		  Node iter = head.next.next;
		  Node list1_curr = head_list1;
		  Node list2_curr = head_list2;
		  int flip = 0;
		  while(iter!=null){ //Starting iteration from head.next.next 
			  if(flip==0){
				  list1_curr.next = iter;
				  list1_curr=list1_curr.next;
				  flip=1;
			  }else{
				  list2_curr.next = iter;
				  list2_curr=list2_curr.next;
				  flip=0;
				  
			  }
			  
			  iter = iter.next;
		  }
		  if(list1_curr.next != null){ //making sure no loops.I think at any point either list2 or list2 ka end 
			  list1_curr.next=null;    // would be null.We can put this in if else too.
		  }

		  if(list2_curr.next != null){
			  list2_curr.next=null;
		  }
		  res.add(head_list1);
		  res.add(head_list2);
		  
		  return res;
	  }
  }
	  
	  public static void main(String[] arg){
			LinkedList llist1 = new LinkedList();
			llist1.insert(23);
			llist1.insert(6);
			llist1.insert(52);
			llist1.insert(5);
			llist1.insert(13);
			llist1.insert(9);
			llist1.insert(2);
			
			llist1.printList();
			System.out.println();
			List<Node> lists = split(llist1.head);
			LinkedList list1 = new LinkedList();
			LinkedList list2 = new LinkedList();
			list1.head = lists.get(0);
			list2.head =lists.get(1);
			if(list2.head==null){
				System.out.println("Single or no element.List could not be split.");
			}else{
				list1.printList();
				System.out.println();
				list2.printList();
			}
	}
		
  }
  
  
  

