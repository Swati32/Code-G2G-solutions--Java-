package Strings;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicatesfromGivenString {
	public static String removeDuplicates(String s){
		if(s == null || s.length() <2){
			return s;
		}else{
			int size = s.length();
			String result = "";
			
			LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
			// LinkedHashSet<Character> lhs = new LinkedHashSet<>();
			
			for(int i=0;i<size;i++){
				map.put(s.charAt(i),1);
			}
			
			//for(Character ch : lhs)
			for(Character c : map.keySet()){
				result = result+c ;
			}
			return result;
		}
	}

	public static String removeDuplicates1(String input){
	    String result = "";
	    int size = input.length();
	    for (int i = 0; i < size; i++) {
	        if(!result.contains(String.valueOf(input.charAt(i)))) {
	            result += String.valueOf(input.charAt(i));
	        }
	    }
	    return result;
	}
	
	public static void main(String[] arg){
		String s = "GeeksforGeeks";
		System.out.println(removeDuplicates(s));	
		System.out.println(removeDuplicates1(s));	
	}

}
