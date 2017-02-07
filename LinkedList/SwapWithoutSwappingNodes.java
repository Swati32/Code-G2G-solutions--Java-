package LinkedList;

public class SwapWithoutSwappingNodes {
	public static void swap(Node head,int x,int y){
		if(head==null) return;
		Node x_node,y_node;
		Node x_prev = null;
		Node y_prev =null;

		
		x_node = head;
		y_node = head;
		
		while(x_node !=null){
			if(x_node.data == x) 
				break;
			x_prev = x_node;
			x_node = x_node.next;
		}
		
		
		while(y_node !=null){
			if(y_node.data == y) 
				break;
			y_prev = y_node;
			y_node = y_node.next;
		}
		if(x_node != null && y_node!=null ){
			
			y_prev.next = x_node;
			x_prev.next= y_node;
			
			Node temp = x_node.next;
			x_node.next = y_node.next;
			y_node.next = temp;
			
			if(x_node == head) head = y_node ; 
			else if( y_node == head) head = x_node;
			
		}else{
			System.out.println("Swap not possible.Missing element in Linked List");
		}
		
	}
	public static void main(String[] arg){
		LinkedList l = new LinkedList();
	    l.insert(6);
        l.insert(1);
        l.insert(3);
        l.insert(2);
        l.insert(7);
        l.insert(9);
        l.insert(5);
        l.insert(11);
        
        l.printList();
        swap(l.head,3,2);
        System.out.println("");
        l.printList();
	}

}
