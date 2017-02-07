
public class DynamicMinJumps {
	public static int FindMinJumpsFromHereRecursion(int[] arr, int start){
		if(arr == null||arr.length==0) return 0;
		//base case
		if(start==arr.length-1) return 0;
		if(start+arr[start] >= arr.length-1) return 1;
		
		
		int min = Integer.MAX_VALUE;
		for(int i=start+1;i<= start+arr[start];i++){
			min = Math.min(min, FindMinJumpsFromHereRecursion(arr,i));
		}
		return min+1;
	}

	public static int FindMinJumpsFromHereDynamic(int[] arr){
		if(arr == null||arr.length==0) return 0;
		int[] minFromHere  = new int[arr.length];
		minFromHere[arr.length-1] = 0;
		for(int i = arr.length-2 ; i>=0 ; i--){      // decreasing toh i--  hona chahie idiot i++ likhi thi
			if(arr[i]+i >= arr.length-1)
				minFromHere[i] = 1;
			else{
				int min =Integer.MAX_VALUE;
				for(int j=i+1;j<=i+arr[i];j++)
					min = Math.min(min, minFromHere[j]);
				minFromHere[i] = min +1;
			}
		} 
		
		return minFromHere[0];
	}
	public static void main(String[] arg){
		int[] arr1 =  new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int result = FindMinJumpsFromHereRecursion(arr1,0);
		System.out.println(result);
		result = FindMinJumpsFromHereDynamic(arr1);
		System.out.println(result);
	}
}
