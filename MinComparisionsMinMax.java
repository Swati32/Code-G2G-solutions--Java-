
public class MinComparisionsMinMax {
	
	public static Pair findminmax(int[] arr, int start,int end){
		Pair p = new Pair();
		if(arr == null || arr.length==0) return p;
		if(start == end){ //basecase1
			p.setMin(arr[start]);
			p.setMax(arr[start]);                      //messed here start ki jagah 0
			return p;
		}
		if(end-start == 1){//basecase2                   //meesedd here start-end ki jagah end-start
				if(arr[start]>arr[end]){
					p.setMax(arr[start]);
					p.setMin(arr[end]);
				}else{
					p.setMax(arr[end]);
					p.setMin(arr[start]);
				}
			
		   return p;	//messed here returnhi bhul gai lagana in base case
		}
		
		int mid = (end-start)/2;
		mid = start + mid;
		
		Pair p1 = findminmax(arr,start,mid);
		Pair p2 = findminmax(arr,mid+1,end);
		
		if(p1.getMax()>p2.getMax()) p.setMax(p1.getMax()); else p.setMax(p2.getMax());
		if(p1.getMin()<p2.getMin()) p.setMin(p1.getMin()); else p.setMin(p2.getMin());
		
		return p;
	}	
	
	public static void main(String[] arg){
		int[] arr = new int[]{1,3,1,1,0,-3};
		System.out.println(1<-3);
		Pair p = findminmax(arr,0,arr.length-1);
		if(p==null)
			System.out.println("Empty Array");
		else
		    System.out.println(p.getMax() +" " +p.getMin());
	}
}

