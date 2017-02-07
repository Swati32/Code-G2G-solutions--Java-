package LinkedList;

import java.util.HashMap;

import LinkedList.ArbitaryPointerToNextHigher.Nodem;

public class CloneLinkedList {
        static class NodeM{
        	int data;
        	NodeM next;
        	NodeM random;
        	
        	public NodeM(int data){
        		this.data = data;
        		this.next = null;
        		this.random = null;		
        	}
        }
        
        static class LinkesListRandom{
        	NodeM head;
        	
        	public void insert(int data){
    			if(head == null){
    				head = new NodeM(data);
    			}else{
    				NodeM curr = head;
    				while(curr.next !=null){
    					curr=curr.next;
    				}
    				curr.next =new NodeM(data);
    			}
    		}
        	void print()
            {
                NodeM temp = head;
                while (temp != null)
                {
                    NodeM random = temp.random;
                    int randomData = (random != null)? random.data: -1;
                    System.out.println("Data = " + temp.data +
                                       ", Random data = "+ randomData);
                    temp = temp.next;
                }
            }
        }
        public static LinkesListRandom clone(NodeM head){
        	LinkesListRandom l = new LinkesListRandom();
        	NodeM curr = head;
        	NodeM iter = null;
        	while(curr != null){
        		NodeM temp = curr.next;
        		l.insert(curr.data);
        		if(iter==null)  iter = l.head;else iter=iter.next;
        		curr.next = iter;
        		iter.random = curr;
        		curr =temp;
        	}
        	curr = head;
        	iter = l.head;
        	while(iter != null){ 
         		iter.random = iter.random.random.next;
        		iter = iter.next;
        	}
        	return l;
        }
        
        public static LinkesListRandom cloneHash(NodeM head){
        	LinkesListRandom l = new LinkesListRandom();
        	HashMap<Integer,NodeM> map= new HashMap<Integer,NodeM>();
        	NodeM curr = head;
        	NodeM iter = null;
        	while(curr != null){
        		l.insert(curr.data);
        		if(iter==null)  iter = l.head;else iter=iter.next;
        		map.put(curr.data, iter);
        		curr =curr.next;
        	}
        	iter = l.head;
        	while(iter != null){ 
         		iter.random = map.get(iter.data);
        		iter = iter.next;
        	}
        	return l;
        }
        public static void main(String[] arg){
        	LinkesListRandom list= new LinkesListRandom();
       	 	list.insert(17);       
       	 	list.insert(23);
       	    list.insert(60);
       	 	list.insert(78);
       	 	list.insert(92);
       	 	
            list.head.random = list.head.next.next;
            list.head.next.random =list.head;
            list.head.next.next.random = list.head.next.next.next;
            list.head.next.next.next.random = list.head.next.next.next.next;
            list.head.next.next.next.next.random = list.head.next;
            
            list.print();
            System.out.println("Clone");
            //LinkesListRandom clone = clone(list.head);
            //clone.print();
            LinkesListRandom clone2 = clone(list.head);
            clone2.print();
        }
        
}
