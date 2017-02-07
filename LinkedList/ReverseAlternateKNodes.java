
package LinkedList;

public class ReverseAlternateKNodes {
	public static Node reverseAlternateKNodes(Node head,int k){
		if(head == null || head.next == null){
			return head;
		}else{
			
			Node kplus1Node = null;
			Node iter = head;
			for(int i=1;i<k && iter!=null;i++){
				iter= iter.next;
			}
			if(iter.next !=null){
				kplus1Node = iter.next;
				iter.next = null;
			}
			Node reversed_listhead= reverse(head);
			head.next = kplus1Node;
			iter = kplus1Node;
			for(int i=1;i<k && iter!=null;i++){
				iter= iter.next;
			}
			if(iter != null){
				iter.next = reverseAlternateKNodes(iter.next,k);
			}		
			return reversed_listhead;
		}
	}
	
	
	public static Node reverse(Node head){
		if(head == null || head.next == null){
			return head;
		}else{
			Node iter = head;
			Node prev = null;
			while(iter != null){
				Node temp = iter.next;
				iter.next = prev;
				prev = iter;
				iter = temp;
			}
			return prev;
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
 			llist1.head = reverseAlternateKNodes(llist1.head,4);
 			llist1.printList();
 		
 	}

}
