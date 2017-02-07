package BackTracking;

import java.util.Arrays;

public class TugOfWar {

	int MinDiff = Integer.MAX_VALUE;
	int Total =0;
	public void Tug(int[] arr){
		if(arr == null || arr.length <=1){
			return;
		}else{
			boolean[] current =  new boolean[arr.length];
			boolean[] sol     =  new boolean[arr.length];
			
			for(int i=0;i<arr.length;i++){
				sol[i]= false;
				current[i] = false;
			}
			
			for(int i=0;i<arr.length;i++){
				Total+=arr[i];
			}
			
			TugRecursive(arr, 0, current, sol, 0 , 0);
			System.out.println(Arrays.toString(sol));
			System.out.println("Members in group 1");
			for(int i=0;i< arr.length ;i++){
				if(sol[i]){
					System.out.print(arr[i]+" ");
				}
			}
			
			System.out.println();
			System.out.println("Members in group 2");
			for(int i=0;i< arr.length ;i++){
				if(!sol[i]){
					System.out.print(arr[i]+" ");
				}		
			}
		}
	}
	
	public void TugRecursive(int[] arr,int currnode, boolean[] current,boolean[] sol, int sumtillnow , int counttillnow){
		if(currnode>arr.length-1){
			return;
		}else if( counttillnow == arr.length/2){
			
			if(MinDiff>(Math.abs(sumtillnow-(Total-sumtillnow)))){
				MinDiff= Math.abs(sumtillnow-(Total-sumtillnow));
				for(int i=0;i<arr.length;i++)                            //you always copy elements of array, you cannot day one array is to next remember they are references
					sol[i] = current[i];
			}
			return;
		}else{
			current[currnode]=true;
			TugRecursive(arr,currnode+1,current,sol,sumtillnow+arr[currnode],counttillnow+1);
			current[currnode]=false;
			TugRecursive(arr,currnode+1,current,sol,sumtillnow,counttillnow);
		}
	}
	public static void main(String[] arg){
		int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		TugOfWar t= new TugOfWar();
		t.Tug(arr);
	}
}
