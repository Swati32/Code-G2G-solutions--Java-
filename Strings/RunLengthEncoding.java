package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class RunLengthEncoding {
	public static String encode(String s){
		if(s == null||s.length() == 0){
			return s;
		}else{
			int size = s.length();
			int count =1;
			StringBuilder sb = new StringBuilder();
			for(int i=1 ; i<size-1;i++){
				if(s.charAt(i-1) == s.charAt(i)){
					count++;
				}else{
					sb.append(s.charAt(i-1)).append(Integer.toString(count));
					count = 1;
				}
			}
			sb.append(s.charAt(size-1)).append(count);
			return sb.toString();
		}
	}



	public static void main(String[] arg){
		String s1 = "wwwwhhhhhhhhaaaatttttt";
		System.out.println(encode(s1));
	}
}
