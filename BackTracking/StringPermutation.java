package BackTracking;

public class StringPermutation {
	public static void printallPermutations(String s, int k){
		if(k>=s.length()){
			System.out.println(s);
		}else{
			for(int i=k;i<s.length();i++){
				String swapped = swap(s,k,i);
				printallPermutations(swapped,k+1);
			}
		}
	}
	
	public static String swap(String s,int a,int b){
		char[] arr = s.toCharArray();
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		String swapped= new String(arr);
		return swapped;
	}
	
	
	public static void main(String[] arg){
		String test = "ABC";
		printallPermutations(test,0);
	}
}
