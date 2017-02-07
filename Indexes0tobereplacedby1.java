import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Indexes0tobereplacedby1 {
	
		public static List<Integer> findthe0(int[] arr,int m) {
			List<Integer> result = new ArrayList<Integer>();
			if(arr == null || arr.length==0) return result; //-1 empty array
			int[] left = new int[arr.length];
			int[] right = new int[arr.length];
			
			
			int count = 0;
			for(int i=0;i<arr.length;i++){
				left[i]=count;
				if(arr[i]==1) count++ ;else count =0;
			}	
			count = 0;
			for(int i=arr.length-1;i>=0;i--){
				right[i]=count;
				if(arr[i]==1) count++ ;else count=0;
			}
			
		
			for(int j = 0;j<m;j++){
				int index=0;
				int max_on_left_plus_right = Integer.MIN_VALUE;
				for(int i=1;i<arr.length-1;i++){
					if(arr[i]==0){
						int sum = left[i]+right[i];
						max_on_left_plus_right=Math.max(max_on_left_plus_right, sum);
						if(sum == max_on_left_plus_right) 
							index=i;
							 
					}
				}
				left[index]=0;
				right[index]=0;
				result.add(index);
			}
			
			
			return result;
			
		}

		public static void main(String[] arg){
			int[] arr1 =  new int[] {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
			int m = 2;
			List<Integer> result = findthe0(arr1,m);
			System.out.println(result);
		}
}
