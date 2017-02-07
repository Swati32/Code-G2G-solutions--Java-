package Queue;

public class QueueImplementation {
	
	static class QueueArray{
		int[] queue ;
		int front;
		int rear;
		int capacity;
		int size = 0;
		
		public QueueArray(int cap){
			capacity=cap;
			queue = new int[capacity];
			front=0;
			rear=0; 
		}
		
		public void Enqueue(int m){
			if(size==0){
				queue[front++]=queue[rear++]=m; 
				size++;
			}else if(size== capacity){  //full
				System.out.println("Queue reached max capacity");
			}else{
				queue[rear++]= m;
				rear =  rear%capacity;
				size++;
			}
		}
		
		public int Dequeue(){
			if(size == 0){
				System.out.println("Empty Queue");
				return -1;
			}else{
				int elem = queue[front++];
				front = front%capacity;
				size--;
				return elem;
			}
		}
		public boolean isEmpty(){
			return (size == 0);
		}
		public boolean isFull(){
			return (size == capacity);
		}
	}
		
	
	public static void main(String[] arg){
		QueueArray q = new QueueArray(5);
		q.Enqueue(12);
		q.Enqueue(14);
		q.Enqueue(1);
		q.Enqueue(5);
		q.Enqueue(23);
		System.out.println(q.Dequeue());
		System.out.println(q.Dequeue());
		q.Enqueue(52);
		q.Enqueue(56);
		q.Enqueue(58);
	}
}


