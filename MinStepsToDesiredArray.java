import java.util.Arrays;

public class MinStepsToDesiredArray {

	public static int findMinStepsto(int[] arr){
		if(arr==null || arr.length == 0 ) return -1;
		
		int steps = 0;
		while(true){
			int count = 0;
			for(int i=0;i<arr.length;i++){       //order is important pahle you count odds and reduce them
				if(arr[i]%2 == 1) steps++;       //cause we add to step before we divide them all by 0, that step has already happened 
				arr[i]=arr[i]/2;
				if(arr[i]==0) count++;
			}
	
			if(count == arr.length) break;
			steps++;
		}
		return steps;
	}
	
	
	public static void main(String[] arg){
		   int[] arr1 =  new int[] {4,5,6,7,0,2,3};	
		   
		   int n = findMinStepsto(arr1);
		   System.out.println(n);
		}
}
