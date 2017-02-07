import java.util.Arrays;

public class LargestSubarray0n1 {
	public static int[] LargestSub(int[] arr){
		if(arr ==null ||arr.length<3) return null;
		
		
	}
	
    public static void main(String[] arg){
  	  int[] arr= new int[]{1, 0, 1, 1, 1, 0, 0};
  	  int[] triplet = LargestSub(arr);
  	  if(triplet == null){
  		 System.out.println("No such Subarray");
  	  }else{
  		  System.out.println(Arrays.toString(triplet));
  	  }
    }

}
