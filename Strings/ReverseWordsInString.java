package Strings;

public class ReverseWordsInString {
	
	public static String reverseWords(String s){
		if(s == null){
			return s;
		}else{
			StringBuilder sb = new StringBuilder(s.length()+1);
			String[] words = s.split(" ");
			for(int i=0 ; i<words.length ; i++){
				sb.append(reverse(words[i]));
				sb.append(" ");
			}
			return reverse(sb.toString());
		}
	}
	
	public static String reverse(String s){
		if(s == null){
			return s;
		}else{
			StringBuilder sb = new StringBuilder();
			for(int j=s.length()-1 ; j>=0 ;j--){
				sb.append(s.charAt(j));
			}
			return sb.toString();
		}
	}
	
	public static void main(String[] arg){
		String s1 = "geeks for weeks";
		System.out.println(reverseWords(s1));
	}

}
