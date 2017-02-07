package LinkedList;

public class RecursivePrint {
	
	public static void printrecursively(Node head){
		if(head ==null){
			return;
		}else if(head.next==null){
			System.out.print(head.data+" ");
		}else{
			printrecursively(head.next);
			System.out.print(head.data+" ");
		}
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
		
		printrecursively(llist1.head);
	}
}
