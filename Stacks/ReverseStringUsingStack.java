package Stacks;

public class ReverseStringUsingStack {
	static class Stack {
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
	
	public static String reverse(String s){
		int size = s.length();
		String output = "";
		Stack str = new Stack(size);
		for(int i = 0;i<size;i++){
			str.push(s.charAt(i));
		}
		for(int i = 0;i<size;i++){
			 output = output+str.pop();
		}
		return output;
	}
	
	public static void main(String[] arg){
		String input = "Payal";
		input = reverse(input);
		System.out.println(input);
	}
	
	
}
