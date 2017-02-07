package Stacks;

import java.util.Stack;

public class MatchBraces {
	public static boolean isBalanced(String s){
		if(s.length()==0 || s== "") {
			return true;
		}else{
			Stack braces = new Stack();
			for(int i=0;i<s.length();i++){
				char ch = s.charAt(i);
				if(ch == '{' || ch == '[' || ch =='('){
					braces.push(ch);
				}else{
					char last = (char)braces.pop();
					if(!isMatchingBrace(ch,last)){
						return false;
					}
				}
				
			}
			return true;
		}
		
	}
	
    public static boolean isMatchingBrace(char ch1,char ch2){
    	switch(ch1){
    	case '}' : return(ch2=='{')?true :false;
    	case ']' : return(ch2=='[')?true :false;
    	case ')' : return(ch2=='(')?true :false;
    	}
    	return false;
    }
    
    public static void main(String[] arg)
    {
    	String input = "[(])";
    	System.out.println(isBalanced(input));
    }
}
