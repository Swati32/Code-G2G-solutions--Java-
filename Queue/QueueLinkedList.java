package Queue;

public class QueueLinkedList {
	static class QueueNode{
		int data;
		QueueNode next;
		QueueNode(int data){
			this.data = data;
			next=null;
		}
	}
	static class QueueLinked{
		QueueNode front;
		QueueNode rear;
		
		public void enQueue(int m){
			if(front == null){
				front = rear = new QueueNode(m);
			}else{
				rear.next = new QueueNode(m);
				rear = rear.next;           //you forgot this.How can you be so stupid....you idiot !
			}
		}
		
		public int deQueue(){
			if(front == null){
				System.out.println("Queue is Empty");
				return -1;
			}else{
				int m = front.data;
				front = front.next;
				return m;
			}
		}
	}
	
	public static void main(String[] arg){
		QueueLinked q = new QueueLinked();
		q.enQueue(1);
		q.enQueue(11);
		q.enQueue(91);
		q.enQueue(23);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
