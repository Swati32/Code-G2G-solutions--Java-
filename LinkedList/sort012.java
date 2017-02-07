package LinkedList;

public class sort012 {

	public static Node sort(Node head){
		if(head == null || head.next == null) {
			return head;
		}else{
			Node iter = head;
			Node ones_first =null;
			Node Zeroes_first = null;
			Node twos_first =null;
			Node ones_curr =null;
			Node Zeroes_curr = null;
			Node twos_curr =null;
			
			while(iter !=null){
				if(iter.data == 0){
					if(Zeroes_first==null){
						Zeroes_first = Zeroes_curr =iter;
					}else{
						Zeroes_curr.next = iter;
						Zeroes_curr = Zeroes_curr.next;
					}
				}else if(iter.data==1){
					if(ones_first==null){
						ones_first=ones_curr=iter;
					}else{
						ones_curr.next = iter;
						ones_curr=ones_curr.next;
					}
				}else if(iter.data==2){
					if(twos_first==null){
						twos_first=twos_curr=iter;
					}else{
						twos_curr.next=iter;
						twos_curr=twos_curr.next;
					}
				}else{
					System.out.println("Unexpected element found "+iter.data+". Sorting Aborted !");
					return head;
				}
				iter = iter.next;
			}
			if(twos_curr !=null){
				twos_curr.next = null;   //very very important else loop will become cyclic
			}
			if(Zeroes_first!=null){
					head = Zeroes_first;
					if(ones_first!=null){
					Zeroes_curr.next = ones_first;
					ones_curr.next=twos_first;
					}else{
						Zeroes_curr.next = twos_first;
					}
			}else{
				if(ones_first!=null){
					head = ones_first;
					ones_curr.next = twos_first;
				}else{
					head=twos_first;
				}
			}
			
			return head;
		}
		
	}
	
	public static void main(String[] arg){
		LinkedList llist1 = new LinkedList();
		llist1.insert(2);
		llist1.insert(2);
		llist1.insert(2);
		llist1.insert(5);
		llist1.insert(2);
		llist1.insert(2);
		llist1.insert(2);
		llist1.printList();
		System.out.println();
		llist1.head = sort(llist1.head);
		System.out.println();
		llist1.printList();
	}
}
