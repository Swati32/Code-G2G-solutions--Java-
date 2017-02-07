package Stacks;

public class DLLImplementationOfStack {
	static class DLLNode{
		private int data;
		private DLLNode next;
		private DLLNode prev;
		public DLLNode(int m){
			this.data=m;
			next=prev=null;
		}
	}
	
	static class DLLStack{
		DLLNode head=null;
		DLLNode mid=null;
		int count=0;
		
		public void push(int m){
			if(head == null){
				head = new DLLNode(m);
				mid = head;
				count++;
			}else{
				
				DLLNode newNode = new DLLNode(m);
				newNode.next = head; //set new eleent ka next as head
				head.prev = newNode; //set head ka prev as newnode
				head = newNode;      //shift head to newNode
				count++;
				if(count%2 != 0){
					mid=mid.prev; //shift middle number of elements becomes odd
				}
			}
		}
		public boolean isEmpty(){
			return (count == 0);
		}
		
		public int pop(){
			if(count==0){
				System.out.println("System Underflow");
				return -1;
			}else{
				int elem = head.data;
				head = head.next;
				count--;
				if(count %2 !=0){
					mid= mid.prev; //odd - get the next element from stack
				}else{
					mid= mid.next; //even - get the previous element from stack
				}
				
				return elem;
			}
		}
		public int findMiddle(){
			if(count==0){
				System.out.println("System Underflow");
				return -1;
			}else{
				return mid.data;
			}
		}
		
		
		public void deleteMiddle(){
			if(count==0){
				System.out.println("System Underflow - No element to delete");
				return;
			}else{
				if(mid == head){
					mid=mid.next;
					count = 0;
					return;
				}else{
					    DLLNode temp = mid;
						mid.prev.next= mid.next;
						temp.next.prev = temp.prev;
						count--;
						if(count %2 !=0){
							mid= mid.prev; //odd - get the next element from stack
						}else{
							mid= mid.next; //even - get the previous element from stack
						}
				}	
			}		
		}
			
		
	}
	
	
	public static void main(String[] arg){
		DLLStack dll = new DLLStack();
		dll.push(5);
		dll.push(10);
		dll.push(16);
		dll.push(6);
		dll.push(7);
		System.out.println(dll.pop());
		System.out.println(dll.findMiddle());
		dll.deleteMiddle();
		System.out.println(dll.findMiddle());
		dll.deleteMiddle();
		
	}
}
