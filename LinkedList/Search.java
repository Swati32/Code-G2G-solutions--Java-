package LinkedList;

public class Search {
	public static int getPosition(Node head,int data){
		if(head == null) return -1;
		Node p = head;
		int count = 0;
		while(p !=null){
			if(p.data==data) return count;
			count++;
			p=p.next;
		}
		return -1;
	}
       
	public static int findposrecursive(Node n ,int data){
		if(n.data==data) return 0;
		if(n.next !=null){
			int pos = findposrecursive(n.next,data);
			if(pos > 0) return pos+1; else return pos;
		}else
			return -1;
	}
	public static void main(String[] arg){
		LinkedList l= new LinkedList();
	    l.insert(6);
        l.insert(1);
        l.insert(3);
        l.insert(2);
        l.insert(7);
        l.insert(9);
        l.insert(5);
        l.insert(11);
        
        
		System.out.println(getPosition(l.head,100));
		System.out.println(findposrecursive(l.head,100));
	}
}
