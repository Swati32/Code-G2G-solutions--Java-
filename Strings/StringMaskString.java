package Strings;

public class StringMaskString {
	
	
	public static String Mask(String s , String mask){
		if(s == null || mask == null){
			return s;
		}else{
			int[] count = new int[256];
			int size = s.length();
			for(int i=0 ; i<mask.length(); i++){
				count[(int)mask.charAt(i)]++;
			}
			String mutated = "";
			for(int i=0 ;i<size;i++){
				char ch = s.charAt(i);
				if(count[(int)ch] == 0){
					mutated += ch;
				}
			}
			return mutated;
		}
	}
	
	public static void main(String[] arg){
		String s1 = "geeksforgeeks";
		String s2 = "mask";
		System.out.println(Mask(s1,s2));
	}
}
