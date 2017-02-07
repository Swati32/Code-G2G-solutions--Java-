package Stacks;

public class TwoStacks {
        private int[] arr;
        private int max_capacity;
        private int top1;
        private int top2;
        
        public TwoStacks(int max){
        	max_capacity = max;
        	arr= new int[max];
        	top1=0;
        	top2=arr.length-1;
        }
        public void pushtop1(int m){
        	if(top1>top2){
        		System.out.println("Stack Full1 - Element cannot be inserted)");
        	    return;
        	}else{
        		arr[top1++] = m;
        	}
        }
        public void pushtop2(int m){
        	if(top1>top2){
        		System.out.println("Stack Full2 - Element cannot be inserted)");
        	    return;
        	}else{
        		arr[top2--] = m;
        	}
        }
        public int pop1(){
        	if(top1<0){
        		System.out.println("Stack Empty1");
        	    return -1;
        	}else{
        		return arr[--top1];
        	}
        }
        
        public int pop2(){
        	if(top2>=max_capacity-1){
        		System.out.println("Stack Empty2");
        	    return -1;
        	}else{
        		return arr[++top2];
        	}
        }
        
        public static void main(String[] arg){
        	TwoStacks t= new TwoStacks(8);
        	t.pushtop1(1);
        	t.pushtop1(2);
        	t.pushtop1(5);
        	t.pushtop1(7);
        	
        	t.pushtop2(32);
        	t.pushtop2(34);
        	t.pushtop2(85);
        	t.pushtop2(89);
        	
        	System.out.println(t.pop1());
        	System.out.println(t.pop1());
        	System.out.println(t.pop1());
        	System.out.println(t.pop1());
        	System.out.println(t.pop2());
        	System.out.println(t.pop2());
        	System.out.println(t.pop2());
        	System.out.println(t.pop2());
        	System.out.println(t.pop2());
        	System.out.println(t.pop2());
        	
        }
        
}
