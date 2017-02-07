package Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class printBinary {
	public static void print(int n){
		Queue<String> q = new LinkedList();
		q.add("1");
		int count = 0;
		while(count < n){
			String last = q.remove();
			System.out.print(last+" ");
			q.add(last+"0");
			q.add(last+"1");
			count++;
		}
	}
	
	public static void main(String[] arg){
		print(5);
	}
}
