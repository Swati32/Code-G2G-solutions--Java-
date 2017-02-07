package LinkedList;

public class CountFrequency {
	
	public static int count(Node head,int n){
		if(head==null) return 0;
		int count =0 ;
		Node p =head;
		while(p!=null){
			if(p.data==n)
				count++;
			p=p.next;
		}
		
		return count;
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
        
       
        int count=count(l.head,9);
        System.out.println(count);

}


}
