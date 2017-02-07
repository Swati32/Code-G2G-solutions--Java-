package Stacks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Stacks.CircleAllPetrolPumps.PetrolPump;

public class CirclePumps {

	public static class PetrolPump{
		int petrol;
		int distanceToNext;
		
		public PetrolPump(int m,int n){
			petrol = m;
			distanceToNext = n;
		}
	}
	public static int findStartingPoint(ArrayList<PetrolPump> pumps){
		
		int front = 0;         		//rear ---->back of your queue+1 why do we need it ? next element we are trying to reach fron curr
		int curr=0;                 //rear can be reduced its basically curr+1
		int leftover_petrol= 0;
		int rear=1;
		
		int total = pumps.size();
		Queue<Integer> q = new LinkedList<Integer>(); 					// --->when you enter something is queue, mean your reached it already.Thats your current point.
		
		
		while(front != rear ){ 			
			PetrolPump	p = pumps.get(curr)	;				  			
			leftover_petrol=( p.petrol -p.distanceToNext);
			
			
			while(leftover_petrol >= 0 && front!=rear ){
				q.add(curr);
				curr=rear;
				rear++;
				rear = rear%total;
				p = pumps.get(curr)	;
				leftover_petrol = leftover_petrol+( p.petrol -p.distanceToNext);
				
			}
			
			if(front!=rear){
				//remove this starting point
				
				if(!q.isEmpty()){
					PetrolPump	old = pumps.get(q.remove());
					leftover_petrol -= old.petrol - old.distanceToNext;
				}
				
				//set next starting point
				if(q.isEmpty())
				{
					curr  = front=rear;
				}else{
					front = rear = q.peek();
				}
				rear++;
				rear= rear%total;
				if(front == 0) break;
			}
			
			
		}
		
		return (front==rear)?front:-1;
	}
	
	public static void main(String[] arg){
		ArrayList<PetrolPump> p = new ArrayList<PetrolPump>();
		
		p.add(new PetrolPump(4,6));
		p.add(new PetrolPump(2,3));
		p.add(new PetrolPump(6,5));
		p.add(new PetrolPump(7,3));
		p.add(new PetrolPump(4,4));
		
		System.out.println(findStartingPoint(p));
	}
}
