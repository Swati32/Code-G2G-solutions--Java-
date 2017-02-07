import java.util.Arrays;

//YOU SO SCREWED UP THIS QUESTION !!!! IDIOT !!!!!!!!!!!!

public class MaximumLengthBitonicArray {
	public static int findMaximumLengthBitonicArray(int[] arr){           //Boundary Conditions You need to figure out a way to deal with it better
		if(arr==null || arr.length <0) return 0;
		if(arr.length ==1 ) return 1;
		int[] increasing = new int[arr.length];
		int[] decreasing = new int[arr.length];
		int max = Integer.MIN_VALUE;
		//dealing with extreme ends
        if(arr.length>1 && arr[1]>arr[0]) {increasing[0]=1;decreasing[0]=0;} else {increasing[0]=0;decreasing[0]=1;}
        if(arr.length>1 && arr[arr.length-1]<arr[arr.length-2]) {decreasing[arr.length-1]=1 ; increasing[arr.length-1]=0;}
        else {decreasing[arr.length-1]=0;	increasing[arr.length-1]=1;}
        
        decreasing[arr.length-1] =0;
		for(int i=1;i<arr.length-2;i++)
			if(arr[i-1] <arr[0]) increasing[i] = increasing[i-1]+1;else increasing[i]=0;
		for(int i =arr.length-2;i>=1;i--)
			if(arr[i]>arr[i+1]) decreasing[i]=decreasing[i+1]+1;else decreasing[i]=0;
		
		System.out.println(Arrays.toString(increasing));
		System.out.println(Arrays.toString(decreasing));
		for(int i=0;i<arr.length;i++)
			max=Math.max(max, increasing[i]+decreasing[i]);
		return max;
	}

	public static void main(String[] arg){
		int[] arr1 =  new int[] {20, 4, 1, 2, 3, 4, 2, 10};
		int result = findMaximumLengthBitonicArray(arr1);
		System.out.println(result);
		
	}
}
