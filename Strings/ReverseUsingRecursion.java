package Strings;

public class ReverseUsingRecursion {

	public static void reverse(String s){
		if(s == null){
			return;
		}else{
			int N  = s.length();
			int i =0;
			printreverse(s,i,N);
		}
	}
	public static void printreverse(String s, int i, int N){
		if(i==N){               // you have boundary issues ! if not gonna be N-1 since you are not printing here 
			return;             // I mean think , just think once before writing !
		}else{
			printreverse(s,i+1,N);
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String[] arg){
		String s = "GeeksforGeeks";
		reverse(s);
	}
}
