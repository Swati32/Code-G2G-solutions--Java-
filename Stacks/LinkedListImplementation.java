package Stacks;

public class LinkedListImplementation {
	static class stackNode{
			int data;
			stackNode next;
			
			public stackNode(int data){
				this.data= data;
				this.next = null;
			}
		
	}
	
	static class Stack{
		stackNode top ;
		public Stack(){
			this.top = null;
		}
		
		public void push(int data){
			if(top == null){
				top = new stackNode(data);
			}else{
				stackNode newNode =  new stackNode(data);
				newNode.next = top;
				top = newNode;
			}
			
		}
		
		public int pop(){
			if(top == null){
				System.out.println("Empty Stack");
				return -1;
			}else{
				int result = top.data;
				top =top.next;
				return result;
			}
		}
	
	}
	
	public static void main(String[] arg){;
		Stack s = new Stack();
		s.push(1);
		s.push(8);
		s.push(20);
		s.push(23);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
}
