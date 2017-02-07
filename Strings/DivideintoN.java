package Strings;

public class DivideintoN {
	public static void divideintoN(String s,int N){
		if(s == null){
			return;
		}else{
			int size = s.length();
			int parts = (size% N == 0) ? size/N : size/N +1 ;
			for(int i = 1 ; i<= size; i++){
				System.out.print(s.charAt(i-1));
				if(i%(parts) == 0) System.out.println();
			}
		}
	}
	public static void main(String[] arg){
		String s = "GeeksforGeeks";
		divideintoN(s,4);
	}
}
