package LinkedList;

public class ArbitaryPointerToNextHigher {
	static class Nodem{
		int data ;
		Nodem next;
		Nodem nextHigher;
		Nodem(int data){
			this.data=data;
			next = null;
			nextHigher =null;
		}
	}
	
	static class LinkedListArb{
		Nodem head;
		public void insert(Nodem newNode){
			if(head == null){
				head = newNode;
			}else{
				Nodem curr = head;
				while(curr.next !=null){
					curr=curr.next;
				}
				curr.next = newNode;
			}
		}
		
	    public void printList()
	    {
	        Nodem n = head;
	        while (n != null)
	        {
	        	String higher = (n.nextHigher == null)?"Null":Integer.toString(n.nextHigher.data);
	            System.out.print("("+n.data+","+higher+")->");
	            n = n.next;
	        }
	        System.out.println();
	    }
	}
	
	public static Nodem getMiddleNode(Nodem head){
      	 if(head == null) {
      		 return head;
      	 }else{
      		 Nodem slow=head;
      		 Nodem fast=head;
      		 while(fast!=null && fast.nextHigher !=null && fast.nextHigher.nextHigher !=null){
      			 slow=slow.nextHigher;
      			 fast=fast.nextHigher.nextHigher;
      		 }
      		 return slow;
      	 }
    }
	public static Nodem MergeSort(Nodem head){
		if(head == null ||head.nextHigher == null){
			return head;
		}
		Nodem mid = getMiddleNode(head);
		Nodem righthead = mid.nextHigher;
		mid.nextHigher =null;
		Nodem right = MergeSort(righthead);
		Nodem  left = MergeSort(head);
		
		return Merge(left,right);
		
	}
	 
	public static Nodem Merge(Nodem left,Nodem right){
		if(left == null){
			return right;
		}else if(right == null){
			return left;
		}else{
			Nodem result=null;
			if(left.data<right.data){
				result=left;
				result.nextHigher=Merge(left.nextHigher,right);
			}else{
				result=right;
				result.nextHigher=Merge(left,right.nextHigher);
			}
			return result;
		}
	}
	
	public static Nodem findNextHigher(Nodem head){
		if(head==null){
			return head;
		}else{
			Nodem temp = head;
			while(temp!=null){                               //Initializing all the nodes same as next
				temp.nextHigher = temp.next;
				temp = temp.next;
			}
			
			return MergeSort(head);
			
		}
	}
	
	public static Nodem findNextHigheronRight(Nodem head){
		if(head==null || head.next == null){  //Careful with base cases love ! You can't mess them up :(
			return head;
		}else{
			head.nextHigher = findNextHigheronRight(head.next);
				if(head.nextHigher.data < head.data){
				return head;
			}
			return head.nextHigher;
		}
	}
	public static void main(String[] arg){
		LinkedListArb l = new LinkedListArb();
		 l.insert(new Nodem(12));       
	     l.insert(new Nodem(2));
	     l.insert(new Nodem(13));
	     l.insert(new Nodem(8));
	     l.insert(new Nodem(7));
	     l.insert(new Nodem(9));
	       
	    l.printList();
	    Nodem res = findNextHigher(l.head);               //dont modify list head unless you need to ! Small things, big difference :(
        l.printList();
	    //Nodem res= findNextHigheronRight(l.head);
	    //l.printList();
	}

}
