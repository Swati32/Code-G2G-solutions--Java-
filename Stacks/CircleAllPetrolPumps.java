package Stacks;

import java.util.ArrayList;

import sun.misc.Queue;

public class CircleAllPetrolPumps {
	public static class PetrolPump{
		int petrol;
		int distanceToNext;
		
		public PetrolPump(int m,int n){
			petrol = m;
			distanceToNext = n;
		}
	}
	public static int findStartingPointCrappy(ArrayList<PetrolPump> p) throws InterruptedException{
		if(p == null || p.size() == 0 || p.size() == 1){
			return 0;
		}else{
			Queue<Integer> q = new Queue<Integer>();
			int leftover = 0;
			int total = p.size();
			int visited =0;
			int start = 0;
			q.enqueue(0);
			System.out.println(total);
			while(start<total){
				
				PetrolPump curr = p.get(start);
				System.out.println(curr.distanceToNext+ " "+ curr.petrol);
				while(curr.petrol -curr.distanceToNext+leftover >0 && visited < total){
					q.enqueue(start);
					leftover = curr.petrol -curr.distanceToNext;
					start++;
					visited++;
					start=start%total;
					
				}
				if(visited == total){
					return q.dequeue();
				}else{
					int j = q.dequeue();
					start= j+1;leftover = 0;visited=0;
				}
				
			}
			return -1;
		}
	}
	public static int findStartingPoint(ArrayList<PetrolPump> p) throws InterruptedException{
		if(p == null || p.size() == 0 || p.size() == 1){
			return 0;
		}else{
			int start = 0;
		    int   end = 1;
		    int total = p.size();
		    PetrolPump curr_pump = p.get(start);                               //get first pump
		    int curr_petrol = curr_pump.petrol - curr_pump.distanceToNext;     //get leftover petrol
		    while (end != start || curr_petrol < 0){           //Loop kab end karna he ? When start=end && curr_petrol >=0 jab tak nai we keep looping
		    	 while (curr_petrol < 0 && start != end)       //mtlb ya toh loop pura ho gaya ya curr_petrol>0   
		         {
		    		 curr_pump = p.get(start);   
		    		 curr_petrol = curr_petrol+(curr_pump.petrol - curr_pump.distanceToNext);
		             start = (start + 1)%total;                         //last element ab start ho gaya
		             if (start == 0)
		             return -1;
		         }
		    	 curr_pump = p.get(end);                                     
		    	 curr_petrol = curr_pump.petrol - curr_pump.distanceToNext;
		    	 end = (end + 1)% total;                                          
		    }
		    return -1;
		}
	}
	
	
	public static void main(String[] arg) throws InterruptedException{


	}
	

}
