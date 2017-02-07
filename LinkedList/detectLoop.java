package LinkedList;

import java.util.HashMap;

public class detectLoop {
	
	public static boolean isThereLoop(Node head){
		if(head == null ) return false;
		Node p = head;
		Node q = head.next;
		while(q.next.next != null){
			if(p == q) return true;
			p=p.next;
			q=q.next.next;
		}
		return false;
	}
	
	public static boolean isThereLoopHash(Node head){
		if(head == null ) return false;
		Node p = head;
		HashMap<Node,Integer> map= new HashMap<Node,Integer>();
		while(p != null){
			if(map.containsKey(p)) return true;
			map.put(p, 1);
			p=p.next;
		}
		return false;
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
        l.insert(9);
        
        //l.head.next.next.next.next = l.head;
       
        System.out.println(isThereLoop(l.head));
        System.out.println(isThereLoopHash(l.head));
	}  


}
