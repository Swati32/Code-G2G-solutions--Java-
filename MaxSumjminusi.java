
public class MaxSumjminusi {
    public static int max(int[] arr){
    	if(arr == null || arr.length <2) return -1;
    	if(arr.length == 2) return 1;
    	int max = -1;
    	if(arr[0] <arr[arr.length-1]) return arr.length-1;
    	int i= 1;
    	int j= arr.length-2;
    
    	while(i<j){
           if(arr[i]<arr[j+1]) return j+1-i;
    	   if(arr[i-1]<arr[j]) return j+1-i;
    	   if(arr[i]<arr[j]) return j-i;
    	   j--;i++;
        }
    	
    	return max;
    }
    
    public static void main(String[] arg){
		  int[] arr = new int[]{6, 5, 4, 3, 2, 1};
	  	  int result =  max(arr);
	  	  System.out.println(result);
	  }
}
