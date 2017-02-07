package Queue;

public class PriorityQueue {
	public static class Pnode{
		int data;
		int priority;
		Pnode next;
		public Pnode(int data,int priority){
			this.data =data;
			this.priority = priority;
			this.next = null ;
		}
	}
	
	public static class pqueue{
		Pnode front;
		Pnode rear;
		
		public void insert(int data,int priority){
			if(front==null){
				front  = rear = new Pnode(data, priority);
			}else{
				rear.next = new Pnode(data, priority);
				rear = rear.next ;
			}
		}
		
		public int getHighestPriority(){
			if(front ==null){
				return -1;
			}else{
				Pnode curr = front;
				Pnode max = new Pnode(1, -1);
				while(curr != null){
					if(max.priority<curr.priority){
						max = curr;
					}
					curr=curr.next;
				}
				return max.data;
			}
		}
		
		public void deleteHighestPriority(){
			if(front ==null){
				return;
			}else{
				Pnode curr = front;
				Pnode max = new Pnode(1, -1);
				Pnode prior_max = new Pnode(1, -1);
				while(curr.next !=null){
					if(curr.next.priority>max.priority){
						prior_max= curr;
						max=curr.next;
					}
					curr=curr.next;
				}
				if(front.priority>max.priority){
					front= front.next;
				}else{
					prior_max.next = prior_max.next.next;
				}
			}
			
		}
		
		
	}
	public static void main(String[] arg){
		pqueue p = new pqueue();
		p.insert(1,9);
		p.insert(2,7);
		p.insert(21,2);
		p.insert(12,0);
		p.insert(42,3);
		
		System.out.println(p.getHighestPriority());	
		p.deleteHighestPriority();
		System.out.println(p.getHighestPriority());	
		p.deleteHighestPriority();
		System.out.println(p.getHighestPriority());	
		p.deleteHighestPriority();
		System.out.println(p.getHighestPriority());	
		p.deleteHighestPriority();
		System.out.println(p.getHighestPriority());	
		p.deleteHighestPriority();
		System.out.println(p.getHighestPriority());	
	}

}
