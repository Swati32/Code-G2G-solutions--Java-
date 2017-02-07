package Strings;

public class printPermutationsOfString {

	public static void permuations(String s){
		if(s == null){
			return;
		}else{
			int N = s.length();
			int fixed = 0;
			print_all_permutations(s,fixed,N);
		}			
	}
	public static void print_all_permutations(String s , int fixed , int N){
		if(fixed == N-1){
			System.out.println(s);
			return;
		}else{
			for( int i=fixed ;i<N;i++){                            //idiocy ki limit hoti he. you cant do stupid mistakes like i<N-1
				String swapped = swap(s,fixed,i);                  // come on you can do better. I mean this is plain stupid !
				print_all_permutations(swapped ,fixed+1 ,N);
			}
		}
	}
	public static String swap(String s, int pos1, int pos2){
		if(s == null){
			return s;
		}else{
			char[] arr = s.toCharArray();
			char temp = arr[pos1];
			arr[pos1] = arr[pos2];
			arr[pos2] = temp;
			String swapped = new String(arr);
			return swapped;
		}
	}
	public static void main(String[] arg){
		String s  ="ABC";
		permuations(s);
				
	}
}
