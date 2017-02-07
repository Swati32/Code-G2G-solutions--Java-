import java.util.Arrays;

public class FindOddOccurenceinAllEvenButOne {
	
		
	    public static int[] findodd(int[] arr){
	    	if(arr == null || arr.length ==0 ) return arr;
	    	int[] missing= new int[2];
	    	int left = 0;
	    	int right = arr.length-1;
	    	int last  = arr.length-1;
	    	int found = 0;
	    	while(found<2){          //you wrote found ==2 instead of found<2 and you dry run through it all without correcting it.That was stupid!
	    		if(left == right){
	    			missing[found++] = arr[left++];
	    			right=last;
	    		}else{
	    			if(arr[left] != arr[right]) right--;
	    			else{
	    			    int temp =  arr[last];
	    			    arr[last] = arr[right];
	    			    arr[right]=temp;
	    			    left++;
	    			    last--;
	    			    right=last;
	    			}
	    		}
	    		
	    	}
	    	return missing;
	    }
		
		
		public static void main(String[] arg){
			int[] arr1 =  new int[] {12, 23, 34, 12, 12, 23, 12, 45};
			int result[] = findodd(arr1);
			System.out.println(Arrays.toString(result));
		}
}
