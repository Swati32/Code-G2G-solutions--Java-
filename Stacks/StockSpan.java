package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	public static int[] findspan(int[] price){
		int[] span = new int[]{} ;
		if(price == null || price.length == 0){
			return span;
		}else{
			span = new int[price.length];
			Stack<Integer> st = new Stack<Integer>();
			span[0]=1;
			st.push(0);
			for(int i=1;i<price.length;i++){
				while(!st.isEmpty() && price[st.peek()]<=price[i])
					st.pop();
				if(st.isEmpty()){
					span[i] = i+1;
				}else{
					span[i]=i-st.peek();
				}
				st.push(i);
			}
		}
		
		return span;
	}

	public static void main(String[] arg){
		int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
		int[] span = findspan(prices);
		System.out.println(Arrays.toString(span));
	}
}
