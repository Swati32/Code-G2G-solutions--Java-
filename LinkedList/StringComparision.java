package LinkedList;

public class StringComparision {
     static class StringNode{
    	 char data;
    	 StringNode next;
    	 
    	 public StringNode(char d){
    		 this.data=d;
    		 this.next=null;
    	 }
    	 
     }
     
     static class LinkedListString{
    	 StringNode head;
    	 
    	 public void insert(StringNode s){
    		 if(head == null){
    			head =s;
    		 }else{
    			 StringNode curr = head;
    			 while(curr.next != null){
    				 curr=curr.next;
    			 }
    			 curr.next = s;
    		 }
    	 }
     }
     
     public static int compareStrings(StringNode head1,StringNode head2){
    	 if(head1 == null && head2 == null)
    		 return 0;
    	 else{
    		 while(head1 != null && head2 != null){
    			 
    			 if(head1.data !=head2.data){
    				 break;
    			 }
    			 head1 = head1.next;
    			 head2 = head2.next;
    			
    		 }
    		 if(head1 != null && head2 !=null) {               //neither reached the end
    			 return ((head1.data > head2.data )?  1:-1);
    		 }else if(head1 != null && head2 == null){
    			 return 1;
    		 }else if(head1 == null && head2 != null){
    			 return -1;
    		 }
    		 return 0;
    	 }
     }
      
     public static void main(String[] arg){
    	 LinkedListString list1 = new LinkedListString();
    	 LinkedListString list2 = new LinkedListString();
    	 
    	 list1.insert(new StringNode('a'));
    	 list1.insert(new StringNode('b'));
    	 list1.insert(new StringNode('c'));
    	 list1.insert(new StringNode('d'));
    	 
    	 list2.insert(new StringNode('a'));
    	 list2.insert(new StringNode('b'));
    	 list2.insert(new StringNode('c'));
    	 
    	 
    	 System.out.println(compareStrings(list1.head,list2.head));
     }
     
}
