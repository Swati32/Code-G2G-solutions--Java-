package Dynamic;

import java.util.Scanner;

public class UglyNumbers {
	public static int findNthUgly(int n){
		if(n==0){
			return 0;
		}else{
			int[] ugly = new int[n];
			
			int i2,i3,i5;
			int next_2,next_3,next_5;
			
			ugly[0] = 1;
			i2=i3=i5=0;
			
			for(int i=1 ; i<n ; i++){
				next_2 = ugly[i2]*2;
				next_3 = ugly[i3]*3;
				next_5 = ugly[i5]*5;
				
				int next_ugly = Math.min(next_2,Math.min(next_3, next_5));
				
				if(next_ugly == next_2) i2++;
				if(next_ugly == next_3) i3++;
				if(next_ugly == next_5) i5++;
				
				ugly[i] = next_ugly;
				
			}
			return ugly[n-1];
		}
	}
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		System.out.println(findNthUgly(sc.nextInt()));
	}
}
