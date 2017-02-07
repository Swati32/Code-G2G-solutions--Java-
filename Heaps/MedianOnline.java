package Heaps;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

public class MedianOnline {
	static float Median = 0;
	static class Heap{
		PriorityQueue<Integer>  maxHeap	;
		PriorityQueue<Integer>  minHeap ;
		public class MaxComparator implements Comparator<Integer>
		{
			public int compare( Integer x, Integer y )
			{
				return y - x;
			}
		}
		public Heap(){
			minHeap=new PriorityQueue<Integer> (10,new MaxComparator());
			maxHeap=new PriorityQueue<Integer> ();
		}
		public void insertMaxHeap(int elem){
			maxHeap.offer(elem)	;
		}
		public void insertMinHeap(int elem){
			minHeap.offer(elem)	;
		}
		public int extractMinHeap(){
			if(minHeap.isEmpty()){
				return -1;
			}else{
				return minHeap.poll();
			}	
		}
		public int extractMaxHeap(){
			if(maxHeap.isEmpty()){
				return -1;
			}else{
				return maxHeap.poll();
			}
		}
		
		public int compare(){
			if(minHeap.isEmpty() && maxHeap.isEmpty()){
				return 0;
			}else if(minHeap.isEmpty()){
				return -1;
			}else if(maxHeap.isEmpty()){
				return 1;
			}else{
				if(minHeap.size()== maxHeap.size()){
					return 0;
				}else if(minHeap.size()>maxHeap.size()){
					return 1;
				}else{
					return -1;
				}
			}
		}
		public int topMin(){
			if(minHeap.isEmpty()){
				return 0;
			}else{
				return minHeap.peek();
			}
		}
		
		public int topMax(){
			if(maxHeap.isEmpty()){
				return 0;
			}else{
				return maxHeap.peek();
			}	
		}
	}
	
	public static void UpdateMedian(Heap h ,int elem){
		//First thing you want to do - Compare sizes of heaps in order to determine where should elem go
		// compare 1-minHeap is Larger
		// compare 0- BothHeaps are equal
		// compare -1 - MaxHeap is Larger
		
		switch (h.compare()){
			case 1:
				if(elem<Median){
					h.insertMaxHeap(h.extractMinHeap());
					h.insertMinHeap(elem);
				}else{
					h.insertMaxHeap(elem);
				}
				Median = (float)(h.topMin()+h.topMax())/2;
				break;
			case 0:
				if(elem>Median){
					h.insertMaxHeap(elem);
					Median = h.topMax();
				}else{
					h.insertMinHeap(elem);
					Median = h.topMin();
				}
				break;
			case -1:
				if(elem >Median){
					h.insertMinHeap(h.extractMaxHeap());
					h.insertMaxHeap(elem);
				}else{
					h.insertMinHeap(elem);
				}
				Median = (float)(h.topMin()+h.topMax())/2;
				break;
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Heap heap = new Heap();
		while(sc.hasNext()){
			UpdateMedian(heap,sc.nextInt());
			System.out.println("Median:"+Median);
		}
		
	}
}
