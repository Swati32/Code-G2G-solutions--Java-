import java.util.HashMap;
public class MajorityElement {
	public static String majorityBrute(int[] arr){
		String result = "None";
		if(arr == null || arr.length ==0)
			return result;
		for(int i=0;i<arr.length;i++){
			int count = 1;
			for (int j=i+1;j<arr.length;j++){
				if(arr[i] == arr[j])
					count++;
			}
			if(count>(arr.length/2))
				return Integer.toString(arr[i]);
		}		
		return result;
	}
	
	public static String majorityHash(int[] arr){
		String result ="None";
		if(arr == null || arr.length ==0)
			return result;
		if(arr.length == 1)
			return Integer.toString(arr[0]);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i=0;i<arr.length;i++){
		 if(map.containsKey(arr[i])){
			 int count  = map.get(arr[i])+1;
			 if(count>(arr.length/2)) return Integer.toString(arr[i]);
			 map.put(arr[i],count);
		 }else{
			 map.put(arr[i],1);
		 }
		
		}
		return result;
	}
	
	public static void main(String[] arg){
		int[] arr= new int[] {1,2,3,3,4,3,3};
		System.out.println(majorityBrute(arr));
		System.out.println(majorityHash(arr));
	}

}
