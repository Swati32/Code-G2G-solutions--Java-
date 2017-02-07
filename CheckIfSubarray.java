import java.util.Arrays;
import java.util.HashMap;

public class CheckIfSubarray {
	public static boolean sortMethod(int[] arr1,int[] arr2){
		if(arr1 == null || arr1.length == 0) return false;
		if(arr2 == null || arr2.length == 0) return false;
		if(arr1.length == 1 & arr2.length == 1 ) return (arr1[0]==arr2[0]?true:false);
		if(arr1.length<arr2.length) return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i]==arr2[j]) {
				i++;
				j++;			
			}else{
				i++;
			}
		}
		
		if(j==arr2.length) return true; else return false;	
	}
	public static boolean HashMethod(int[] arr1,int[] arr2){
		if(arr1 == null || arr1.length == 0) return false;
		if(arr2 == null || arr2.length == 0) return false;
		if(arr1.length == 1 & arr2.length == 1 ) return (arr1[0]==arr2[0]?true:false);
		if(arr1.length<arr2.length) return false;
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr1.length;i++){
			if(map.containsKey(arr1[i]))
				map.put(arr1[i], map.get(arr1[i])+1);
			else
				map.put(arr1[i], 1);
	    }
        for(int i=0;i<arr2.length;i++){
        	if(map.containsKey(arr2[i]))
        	{
        		if(map.get(arr2[i]) <= 0) return false;
        		map.put(arr2[i], map.get(arr2[i])-1);
        	}else
        		return false;
        }
		
		return true;
	}
	
	public static void main(String[] arg){
		int[] arr1 =  new int[] {1,2,3,4};
		int[] arr2 =  new int[] {1,2,3};
		System.out.println(sortMethod(arr1,arr2));
		System.out.println(HashMethod(arr1,arr2));
		
	}

}
