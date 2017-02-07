import java.util.Arrays;

public class CountElementsOn {
	public static void countElements(int[] arr){
		if(arr==null||arr.length==0){
			System.out.println("Empty array");
		}else{
			for(int i=0;i<arr.length;i++){
				arr[i] = arr[i]-1;
			}
			
			for(int i=0;i<arr.length;i++){
				arr[arr[i]%arr.length] = arr[arr[i]%arr.length]+arr.length;
			}
			
			for(int i=0;i<arr.length;i++){
				System.out.println(i+1 +" "+arr[i]/arr.length);
			}
		}
	}
	public static void countElements2(int[] arr){
		if(arr == null || arr.length == 0){
			System.out.println("Empty Array");
		}else{
			int i=0;
			int n= arr.length;
			while(i<n){
				if(arr[i]<=0){
					i++;                      //doesnt have anything we are interested in , move on
				}else{
					
					int nextElem = arr[i]-1; //we wanna set increase count of corresponding elemnt by 1 which mean arr[next]--;
					if(arr[nextElem]>0){       //but before that lets see if we have something else there
						arr[i]= arr[nextElem]; //bring it here
						arr[nextElem]=-1;
					}else{
						arr[nextElem]--;
						arr[i]=0; //why because work here is done ...element here and all elements that could have been reched from here have been already taken care of.
						i++;
					}
					
				}
			}
			
			
			for(int j=0;j<n;j++){
				System.out.println(j+1 +" "+Math.abs(arr[j]));
			}
		}
	}
	public static void main(String[] arg){
		int[] arr = {1,3,3,2,4};
		countElements(arr);
		int[] arr1 = {1,3,3,2,4};
		countElements2(arr1);
	}
}
