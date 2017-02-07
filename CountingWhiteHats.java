
public class CountingWhiteHats {

public static int findwhite(int[] arr){
    if(arr ==null ||arr.length ==0)
        return 0;
        
    int total = arr.length; 
   
    int max = 0;
    int black = -1;
    int white = -1;
    int count=0;
    for(int i=0 ;i<arr.length ;i++){
        if(total<= arr[i]) return -1; // total > m
        max = Math.max(max, arr[i]);
        if(black == -1 ) {
        	black = max;
        	
        }
        if( i!= 0 && arr[i] == arr[i-1]) count++;
        if(max != black ) 
         {   
        	 if(black+1 != max) return -1;   //black m white m-1
             if(white==-1) {                // no other values than m & m-1
                 white = black;
                 black = max;
             }else
                 return -1;
         }
    }
    if(count == total-1 && arr[0] !=0) return total; //all whites
    
    return black;
}
public static void main(String[] arg)
    {
	    int arr[] = new int[]{2,2,2};
        int whitehats =  findwhite(arr);
        System.out.println(whitehats);
    }
}
