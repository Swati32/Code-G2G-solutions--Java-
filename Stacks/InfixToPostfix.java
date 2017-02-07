package Stacks;

public class InfixToPostfix {
	private String output="" ;
	private String input ;
	private Stack operations;
	 public InfixToPostfix(String in) {
	      input = in;
	      int stackSize = input.length();
	      operations = new Stack(stackSize);
	   }
	public void processOperator(char a, int precedence){
		if(operations.isEmpty()){
			operations.push(a);
			operations.print();
		}else{
			
				while(!operations.isEmpty()){
					
					char previous = operations.pop();
					int  prev_precedence = 0;
					if(previous == '('){
						operations.push('(');
						break;
					}else if(previous == '^'){
						prev_precedence=3;
					}else if((previous == '*')||(previous=='/')){
						prev_precedence=2;
					}else{
						prev_precedence=1;
					}
					
					if (prev_precedence < precedence) { 
						operations.push(previous);
						break;
					}else{
						output = output+previous;
					}
					
			   }
			   operations.push(a);
			   operations.print();
				
		}
	}
	
	public void processParanthesis(char a){
		while (!operations.isEmpty()) {
	         char chx = operations.pop();
	         if (chx == '(') 
	         break; 
	         else output = output + chx; 
	      }
	}
	public String IntoPos(String s){
		
		for(int i=0;i<s.length();i++) {
			System.out.println(i+" "+s.charAt(i));
			char a = s.charAt(i);
			switch(a){
				case '+':
				case '-':
				     processOperator(a,1);
					 break;	
				case '*':
				case '/':
					 processOperator(a,2);
					 break;
				case '^':
					 processOperator(a,3);
					 break;
				case '(':
					 operations.push(a);
					 break;
				case ')':
				     processParanthesis(a);
				     break;
				default :
					output = output + a;
					break;
			}	
		
		}
		
		while(!operations.isEmpty()){
			char a = operations.pop();
			output = output + a;
		}
		return output;
	}
	
	public static void main(String[] arg){
		String input = "(1+2)*4/5-7+3/6";
		InfixToPostfix obj = new InfixToPostfix(input);
		obj.output = obj.IntoPos(obj.input);
		System.out.println("Postfix is " + obj.output + '\n');
	}

	class Stack {
		private int capacity;
	    private char[] stackArray;
	    private int top;
	    
	    public Stack(int size){
	    	capacity = size;
	    	stackArray  = new char[size];
	    	top = -1;
	    }
	    
	    public void push(char m){
	    	if(top < capacity-1){
	    		top =top+1;
	    		stackArray[top] = m;
	    	}else{
	    		System.out.println("Stack Overflow");
	    	}
	    }
	    
	    public char pop(){
	    	if(top>-1){
	    		char last=  stackArray[top];
	    		top=top-1;
	    		return last;
	    	}else{
	    		System.out.println("Empty Stack");
	    		return Character.MIN_VALUE;
	    	}
	    }
	    
	    public char peek(){
	    	return stackArray[top];
	    }
	    
	    public boolean isEmpty(){
	    	return (top==-1);
	    }
	    
	    public int size(){
	    	return top;
	    }
	    
	    public void print(){
	    	for(int i=0;i<=top;i++){
	    		System.out.print(stackArray[i]+"-->");
	    	}
	    	System.out.println();
	    }
		
	}
	
}
