import java.util.HashMap;

public class FindingOdd {
	public static int majorityHash(int[] arr){
		int result =0 ;
		if(arr == null || arr.length == 0 ){
			return result;
		}
		if(arr.length == 1)
			return arr[0];
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
		}
		
		for(int key : map.keySet()){
			
			if(map.get(key) % 2 == 1)
				return key;
		}
		return result;
	}
	
    public static int oddXOR(int[] arr){
    	int result =0 ;
		if(arr == null || arr.length == 0 ){
			return result;
		}
		if(arr.length == 1)
			return arr[0];
		
		for( int i =0 ;i<arr.length;i++){
			result = result ^ arr[i];	
		}
		
		return result;
		
    }
	
	public static void main(String[] arg){
		int[] arr= new int[] {1,1,2,2,3,3,4,3,3};
		//System.out.println(majorityBrute(arr));
		System.out.println(majorityHash(arr));
		System.out.println(oddXOR(arr));
	}

}
