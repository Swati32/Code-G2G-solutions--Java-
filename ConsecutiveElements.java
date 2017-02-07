
public class ConsecutiveElements {
  public static boolean isConsecutive(int[] arr){
	  if(arr == null || arr.length <1) return false;
	  int max = arr[0];
	  int min = arr[0];
	  for(int i=1;i<arr.length;i++){
		  if(arr[i]>max)
			  max = arr[i];
		  else if(arr[i]<min)
			  min = arr[i]; //arr[i] ki jagah arr[min] mtlb gadhepane ki bhi limit hoti he 
	  }
	  if(max-min+1 == arr.length) return true ; else return false;
  }
  
  public static void main(String[] arg){
	  int[] arr = new int[]{7, 6, 1, 1, 3, 4};
  	  boolean result =  isConsecutive(arr);
  	  System.out.println(result);
  }
}
