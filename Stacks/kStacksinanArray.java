package Stacks;

public class kStacksinanArray {
	static class KStacks{
		int[] stack_array;
		int[] top;
		int[] nextElement;
		int Capacity;
		int free;
		public KStacks(int k ,int Capacity){
			stack_array = new int[Capacity];
			this.Capacity =Capacity;
			top = new int[k];
			nextElement = new int[Capacity];
			free = 0;
			for(int i=0;i<k;i++){
				top[i]= -1;
			}
			for(int i=0;i<Capacity-1;i++){
				nextElement[i]= i+1;
			}
			nextElement[Capacity-1]= -1;
		}
		public boolean isFull(){
			return (free==-1);
		}
		
		
		public void push(int elem,int k  ){
			if(isFull())	{
				System.out.println("Stackoverflow - Element cannot be inserted");
			}else{
			      	int  i = free; 
			      	free = nextElement[i];
			      	nextElement[i] = top[k];
					top[k] = i;
					stack_array[i] =elem;
				
			}
		}
		public boolean isEmpty(int k)  
		{  
			return (top[k] == -1); 
		}
		public int pop(int k){
			  
		    if (isEmpty(k))
		    {
		    	System.out.println("Stack Underflow");
		        return -1 ;
		    }else{
		    	int i = top[k];
		    	top[k] = nextElement[i];
		    	nextElement[i] = free;
		    	free = i;
		    	return stack_array[i];
		    }
		}
		
		
	}
	
	public static void main(String[] arg){
		int k = 3, capacity = 10;
		KStacks ks = new KStacks(k,capacity);
		ks.push(15, 2);
		ks.push(45, 2);
		 
		
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);
		 
		
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		 
		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
		
	}
}	


