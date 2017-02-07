
public class MinDistanceBetweenTwoPoints {
	public static int findMinDistance(int[] arr, int x ,int y){
		if(arr == null || arr.length <2) return -1;
		int ind_x = -1;
		int ind_y = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0 ; i<arr.length ;i++){
		   if(arr[i] == x){
				if(ind_y > 0) {
					min = Math.min(min, Math.abs(ind_y-i));
				    ind_y= -1;
				}
				ind_x=i;
		   }else if(arr[i]==y){
			   if(ind_x > 0) {
					min = Math.min(min, Math.abs(ind_x-i));
				    ind_x= -1;
				}
				ind_y=i;
		   }
		}
		
		return min;
	}
	public static void main(String[] arg){
		int[] arr1 =  new int[] {2, 5, 3, 5, 4, 4, 2, 3};
		int x = 3;
		int y = 2;
		int result = findMinDistance(arr1,x,y);
		System.out.println(result);
		
	}
}
