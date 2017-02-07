package CodeQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EagleNest {
	class Nest{
		int Hieght;
		int index;
		public Nest(int Hieght,int index ){
			this.Hieght = Hieght;
			this.index = index;
		}
	}
	
	public int solution(int[] H) {
        if(H ==null || H.length == 0){
          return  0;   
        }else{
            PriorityQueue<Nest> maxHeap = new PriorityQueue<Nest>(10,new maxComparator());
            for(int i=0;i<H.length;i++){
            	Nest n =  new Nest(H[i],i);
            	maxHeap.offer(n);
            }

            long[] nestStore = new long[H.length];
            int i=0;
            long sum = 0;
            while(!maxHeap.isEmpty()){
               Nest n = maxHeap.poll();
               sum += sum+1;
            }
            
            return (int)(sum%1000000007);
        }
    }
	
	class maxComparator implements Comparator<Nest> {
        public int compare(Nest x,Nest y){
            return y.Hieght-x.Hieght;
        }
    }
	
	
	public static void main(String[] arg){
		int[] H = new int[]{4, 6, 2, 1, 5 };
		EagleNest e = new EagleNest();
		System.out.println(e.solution(H));
	}
}
