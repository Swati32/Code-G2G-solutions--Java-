//BOUNDARIES

//Push karte time  push until stack2<stack1
//Pop karte time stack1 0 pahucha ya stack2 capacity-2 se jyada hua mtlb empty he.why ?kyunki we increment baad me...
//toh at any point elemnt is one less(stack1) ya one more(stack2).


public class twoStacks {
	private int[] stackarray;
	private int stack1_last=0;
	private int stack2_last=0;
	private int Capacity = 0;
	public twoStacks(int Capacity){
		stackarray = new int[Capacity];
		this.Capacity = Capacity;
		stack2_last = Capacity-1;
	}
    
	public void push1(int n){
		if(stack2_last<stack1_last)
			System.out.println("Max Capacity Reached - Element cannot be added");
		else{
			stackarray[stack1_last] = n;
			stack1_last ++;
			System.out.println("Added new Element "+n);
		}
			
	}
	public void push2(int n){
		if(stack2_last<stack1_last)
			System.out.println("Max Capacity Reached - Element cannot be added");
		else{
			stackarray[stack2_last] = n;
			stack2_last--;
			System.out.println("Added new Element "+n);
		}
			
	}
	
	public int pop1(){
		if(stack1_last==0){
			System.out.println("Empty Stack 1");
            return -1;
		}else{
			int n = stackarray[stack1_last-1] ;
			stack1_last --;
			return n;
		}
	}
	
	
	public int pop2(){
		if(stack2_last>Capacity-2){
			System.out.println("Empty Stack 2");
            return -1;
		}else{
			int n = stackarray[stack2_last+1] ;
			stack2_last ++;
			return n;
		}
	}
	//push1(int x) –> pushes x to first stack
	//push2(int x) –> pushes x to second stack

	//pop1() –> pops an element from first stack and return the popped element
	//pop2() –> pops an element from second stack and return the popped element

	
}
