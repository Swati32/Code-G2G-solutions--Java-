import java.util.Arrays;

public class ArrayRotation {
	public static int[] rotateArray(int[] arr,int d){
		int temp=0;
		if(d==arr.length||d==0) return arr;
        if(d>arr.length) d=d%arr.length;
		int step = gcd(arr.length,d);
		System.out.println(step);  
		int i=0;
		while(i<d){
			System.out.println(Arrays.toString(arr)); 
			int j=i;
			temp =arr[i];
			if(step==1){
				temp=arr[0];
				j=0;
			}
			while(j<arr.length-step){
				arr[j]=arr[j+step];
				j=j+step;
			}
			arr[j]=temp;
			i++;
		}
		
		return arr;
	}

    public static int gcd(int a,int b){
    	if(b==0)
    		return a;
    	else return gcd(b,a%b);
    }
    
    public static void main(String[] arg){
    	int[] arr = new int[]{1,2,3,4,5,6,7,8};
    	int d = 2;
    	int[] result = rotateArray(arr,d);
    	System.out.println(Arrays.toString(result));
    }
}
