import java.util.Arrays;

public class NoTwoAdjMaxSum {
        public static int findNoTwoAdjMaxSum(int[] arr){
        	int max =Integer.MIN_VALUE;
        	if(arr == null || arr.length == 1)
        		return 0;
        	if(arr.length == 1)
        		return arr[0];
        	int incl=0;
        	int excl=0;
            
        	for(int i=0;i<arr.length;i++){
        		int prev= incl;
        		incl = excl + arr[i];
        		excl = Math.max(prev, excl);
        		
        	}
        	
        	
        	max= Math.max(incl, excl);
        	return max;
        }
        
        public static void main(String[] arg){
	    	int[] arr = new int[]{3,2,7,10,5};
	    	
	    	int result = findNoTwoAdjMaxSum(arr);
	    	System.out.println(result);
	 }
        
}
