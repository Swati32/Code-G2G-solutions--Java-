package LinkedList;

public class DelMafterNnodes {
	
	public static void deleteMnodesFromN(Node head,int n,int m){
		if(head==null||m==0||n<1) return;
		
		Node to = head;
		for(int i=1;i<=m+1 && to !=null;i++){
			to =to.next;
		}
		Node from = head;
		for(int i=1;i<n &&  from.next!=null  ;i++){
			if(to == null) {
				to=null ;
			}else {
				to= to.next;
			}
			from=from.next;
		}
		from.next=to;
	}

	public static void main(String[] arg){ 
	  	  LinkedList l = new LinkedList();
	  	  l.insert(7);
	  	  l.insert(2);
	  	  l.insert(2);
	  	  l.insert(7);
	  	  l.insert(7);
	  	  l.insert(7);
	  	  l.insert(2);
	  	  l.insert(9);
	  	  l.insert(9);
	  	  
	  	  
	  	  l.printList();
	  	  //removeDuplicates(l.head);
	  	deleteMnodesFromN(l.head,1,8);
	  	  System.out.println();
	  	  l.printList();
	  	  
	    }
}
