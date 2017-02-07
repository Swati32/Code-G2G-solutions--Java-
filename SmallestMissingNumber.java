
public class SmallestMissingNumber {
	public static int findSmallestMissingNumber(int[] arr,int m){
		if(arr == null ||arr.length == 0) return 0;
		if(m<arr.length) return -1;
		int expected = m;
		for(int  i =0 ; i<arr.length ; i++){
			if(m-arr[i] != expected) return m-expected; //thoda soch ke likha karo run karne se pahle dry run lia karo
			expected=expected-1;
		}
		return -1;
	}
	
	public static void main(String[] arg){
		  int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10};
		  int m = 11;
	  	  int result =  findSmallestMissingNumber(arr,m);
	  	  System.out.println(result);
	  }
}
