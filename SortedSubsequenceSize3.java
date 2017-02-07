import java.util.Arrays;

// Basically kia kya ?
//left-> right gaye min_so_far ka index maintain kia , agar koi min se chota he  toh min ko reset karo aur sarr ko -1
//agar koi min se bada he toh sarr ki value min index daal do 
//right <- left gaye max_so_far ka index maintain kia , agar ko index  max se bada he toh max rest karo aur woh elem ko  -1 set karo
//agar woh element elem chota he max se toh isko set kar do with max so far ke index se
//toh basically minus one indicates is se chota koi element nai he left me(sarr)
// ya isse bada koi element nai he right me(marr)

public class SortedSubsequenceSize3 {
          public static int[] findTriplet(int[] arr){
        	  if(arr ==null ||arr.length<3) return null;
        	  int[] sol = new int[3];
        	  int min_so_far_index = 0;
        	  int[] sarr = new int[arr.length];
        	  sarr[0] = 0;
        	  for(int i=0 ;i<arr.length;i++){
        		  if(arr[i] > arr[min_so_far_index]) sarr[i] = min_so_far_index;
        		  else{
        			  min_so_far_index = i;
        			  sarr[i]= -1;
        		  }
         	  }
        	  int max_so_far_index = arr.length-1;
        	  int[] marr = new int[arr.length];
        	  for(int i=arr.length-1 ;i>=0;i--){
        		  if(arr[i] < arr[max_so_far_index]) marr[i] = max_so_far_index;
        		  else{
        			  max_so_far_index = i;
        			  marr[i]= -1;
        		  }
         	  }
        	  
        	  for(int i=0;i<arr.length;i++){
        		  if(sarr[i] != -1 && marr[i] != -1){
        			  sol[0] = arr[sarr[i]];
        			  sol[1] = arr[i];
        			  sol[2] = arr[marr[i]];
        		  }
        	  }
        	  return sol;
          }
          
          public static void main(String[] arg){
        	  int[] arr= new int[]{12, 11, 10, 5, 6, 2, 30};
        	  int[] triplet = findTriplet(arr);
        	  if(triplet == null){
        		 System.out.println("No such Triplet");
        	  }else{
        		  System.out.println(Arrays.toString(triplet));
        	  }
          }
}
