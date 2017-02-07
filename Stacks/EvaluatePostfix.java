package Stacks;

public class EvaluatePostfix {
	
	private Stack s;
	
	class Stack{
	   private int[] stackarray;
	   private int top;
	  
	   
	   public Stack(String m){
		   int size = m.length();
		   stackarray = new int[size];
		   
		   top=-1;
	   }
	   
	   public void push(int m){
		   stackarray[++top]=m;
	   }
	   
	   public int pop(){
		   return stackarray[top--];
	   }
	   
	   public boolean isEmpty(){
		   return (top==-1);
	   }
	   
	   public int peek(){
		   return stackarray[top];
	   }
	   
	   public void print(){
		   for(int i=0;i<=top;i++){
			   System.out.print(stackarray[i]);
		   }
		   System.out.println();
	   }
	}
	public boolean isDigit(char m){
		return (m >= '0'&& m<='9')? true:false;
	}
	
	public int evaluatePostFix(String m){
		  if(m==null) return 0;
	      s = new Stack(m);
	      for(int i=0;i<m.length();i++){
	    	  char ch = m.charAt(i);
	    	  
	    	  
	    	  if(isDigit(ch)){
	    		  s.push(Character.getNumericValue(ch));
	    	  }else{
	    		  int num1 = s.pop();
	    		  int num2 = s.pop();
	    		  
	    		  switch(ch){
	    		  	case '+' : s.push(num1+num2);
	    		  	break;
	    		  	case '-' : s.push(num2-num1);
	    		  	break;
	    		  	case '/' : s.push(num1/num2);
	    		  	break;
	    		  	case '*' : s.push(num1*num2);
	    		  	break;
	    		  }
	    	 }
	    	  
	      }
	      return s.pop();
	}
	
	public static void main(String[] arg){
		String input  = "231*+9-";
		EvaluatePostfix exp = new EvaluatePostfix();
		System.out.println("Evaluation Result "+exp.evaluatePostFix(input));
	}
}