package LinkedList;

import java.util.List;

public class MergeSort {
             public static int count(Node head){
            	 if(head ==null) return 0;
            	 int count = 0;
            	 while(head !=null)
            		 count++;
            	 return count;
             }
             public static Node getMiddleNode(Node head){
            	 if(head == null || head.next==null) {
            		 return head;
            	 }else{
            		 Node slow=head;
            		 Node fast=head;
            		 while(fast!=null && fast.next !=null && fast.next.next !=null){
            			 slow=slow.next;
            			 fast=fast.next.next;
            		 }
            		 return slow;
            	 }
             }
             public static Node mergeTwoSortedLists(Node list1,Node list2){
            	 if(list1==null && list2 == null){
            		 return null;
            	 }else if(list1 == null){
            		 return list2;
            	 }else if(list2 ==null){
            		 return list1;
            	 }else{
            		 Node head = null;
            		 
            		 //setting the first element
            		 if(list1.data>list2.data){
            			 head = list2;
            			 list2 = list2.next;
            		 }else{
            			 head = list1;
            			 list1 = list1.next;
            		 }
            		 Node curr = head;            //once found the head start iterating over the head
            		 while(list1 != null && list2 != null){
            			 if(list1.data <list2.data){
            				 curr.next  =  list1;
            				 list1 = list1.next;
            				 
            			 }else{
            				 curr.next = list2;
            				 list2 = list2.next;
            			 }
            			 curr =curr.next;
            		 }
            		                                        
            		 if(list1 == null && list2 == null){      //appending the remaining elements of longer list
            			 return head;
            		 }else if(list1 == null){
            			 while(list2 != null){
            				 curr.next = list2;
            				 list2 =list2.next;
            				 curr =curr.next;
            			 }
            		 }else{
            			 while(list1 != null){
            				 curr.next = list1;
            				 list1 = list1.next;
            				 curr=curr.next;
            			 }
            		 }
            		 
            		 return head;
            	 }
            	 
             }
             public static Node mergesort(Node head){
            	 if(head == null || head.next ==null){
            		 return head;
            	 }else{
            		 Node mid = getMiddleNode(head);
            		 Node head_right = mid.next;
            		 mid.next = null;
            		 Node left = mergesort(head);
            		 Node right = mergesort(head_right);
            		 return mergeTwoSortedLists(left,right);
            	 }
             }
             
             
 
}
