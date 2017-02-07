import java.util.Deque;
import java.util.LinkedList;

public class MaxofAllSubarraysSizeK {
         public static void bruteForce(int[] arr,int k){
        	 if(arr == null || arr.length < k) System.out.println("Array Size less than window size");
        	 for(int i = 0; i<= arr.length-k;i++){
        		 int max = arr[i];
        		 for(int j = i+1; j<i+k; j++){
        			 if(arr[j]>max) max= arr[j];
        		 }
        		 System.out.println(max+" ");
        	 }
         }
         
         public static void queueMethod(int[] arr,int k){
        	 if(arr == null || arr.length < k) System.out.println("Array Size less than window size");
        	 Deque<Integer> deque = new LinkedList<Integer>();
        	 for(int i=0 ;i <k;i++){
        		 while(!deque.isEmpty() && arr[deque.getLast()]<arr[i]){
        			 deque.removeLast();
        		 }
        		 deque.addLast(i);
        	 }
        	 
        	 for(int i=k;i<arr.length;i++){
        		 System.out.println(arr[deque.getFirst()]);
        		 while(!deque.isEmpty() && deque.getFirst() <= i-k)
        			 deque.removeFirst();
        		 while(!deque.isEmpty() && arr[deque.getLast()]<=arr[i]) //arr[] ki jagah simply deque.getLast() bole toh inedx se compare kar rahi thi
        			 deque.removeLast();
        		 deque.addLast(i);	 
        	 }
        	 System.out.println(arr[deque.getFirst()]);
        	 
         }
         
         public static void main(String[] arg){
        	 int[] arr = new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
   	  	     int windowSize= 3;
   	  	     bruteForce(arr,windowSize);
   	  	     System.out.println("Using queue");
   	  	     queueMethod(arr,windowSize);
         }
         
         
}
