import java.util.ArrayList;
import java.util.List;

public class MaxProfitStocks {
	
	public static List<List<Integer>> findMaxProfit(int[] arr){
		 List<List<Integer>> result  = new ArrayList<List<Integer>>();
		 int minima = 0;
		 int max_so_far = 0;
		 
		 for(int i=1 ; i<arr.length;i++){
			 if(arr[i]<arr[minima] && max_so_far != minima){
				 List<Integer> pair = new ArrayList<Integer>();
				 pair.add(minima);
				 pair.add(max_so_far);
				 max_so_far = -1;
				 minima = i;
				 result.add(pair);
				 
			 }else if(max_so_far == -1){
				 max_so_far = i;
			 }else if(arr[max_so_far] <arr[i])
				 max_so_far = i;
		 }
		 
		 if(arr[arr.length-1] != minima) {
			 List<Integer> pair = new ArrayList<Integer>();
			 pair.add(minima);
			 pair.add(max_so_far);
			 result.add(pair);
		 }
		 
		 return result;
	}
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {30,40,50,100};
		List<List<Integer>> result = findMaxProfit(arr1);
		System.out.println(result);
	}

}
