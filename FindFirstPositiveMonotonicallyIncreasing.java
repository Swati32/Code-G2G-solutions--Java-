
public class FindFirstPositiveMonotonicallyIncreasing {

	public static int f(int x) { return (x*x - 10*x - 20); }
	
	public static int findFirstPositive(){
		int x =0;
		if(f(x) == 0) return 0;  //you shouldnt have started it with 0 it was such a stupid mistake infinite loop me jayega
		x=1;
		while(f(x)<0){ 
			x= 2*x;
		}
		int high = x;
		int high_by_2 =x/2;
		
		
		int res = binarySearch(high_by_2 , high);
		return res;
	}
	
	public static int binarySearch(int start,int end){
		int mid = start + ((end-start)/2);
		if(f(mid)>0) {
			if(f(mid-1)<0) return mid;
			return binarySearch(start,mid-1);
		}else{
			return binarySearch(mid+1,end);
		}
	}
	
	public static void main(String[] arg){
		System.out.println(findFirstPositive());
	}
	
}
