import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class UnionIntersection {
       public static int[] Union(int[] A,int[] B){
    	   List<Integer> union =  new ArrayList<Integer>();
    	   if(A == null || A.length == 0 ) return B;
    	   if(B == null || B.length == 0) return A;
    	    
    	   int i=0 ;int j=0; 	   
    	   while(i<A.length && j<B.length){
    		   if(A[i] == B[j]){
    			   union.add(A[i]);
    			   i++;j++;
    		   }else if(A[i]<B[j]) {               //i ki jagah j type kia....concentrate
    			   union.add(A[i]);
    			   i++;
    		   }else{
    			   union.add(B[j]);
    			   j++;
    		   }
    	   }
    	   
    	   if(i >= A.length){
    		   while(j<B.length) {
    			   union.add(B[j]); j++;
    		   }
    	   }else if(j >= B.length){
    		   while(i<A.length) {
    			   union.add(A[i]);i++;
    		   }
    	   }
    	  
    	  
    	  int[] union_array = union.parallelStream().mapToInt(Integer::intValue).toArray();
    	  return union_array;
      }
       
       public static int[] intersect(int[] A , int[] B){
    	   if(A == null || A.length == 0 ) return new int[]{};
    	   if(B == null || B.length == 0) return new int[]{};
    	   
    	   List<Integer> intersection = new ArrayList<Integer>();
    	   int i=0; int j=0;
    	   while(i<A.length && j<B.length){
    		   if(A[i]==B[j]){
    			   intersection.add(A[i]);
    			   i++; j++;
    		   }else if(A[i]<B[j]) i++;
    		   else j++;
    	   }
    	   
    	   int[] intersection_array = intersection.parallelStream().mapToInt(Integer::intValue).toArray();
    	   return intersection_array;
       }
       
       
       
   	public static void main(String[] arg){
    	int[] arr = new int[]{1, 3, 4, 5, 7};
    	int[] arr2 = new int[]{2, 3, 5, 6};
    	int[] result = Union(arr,arr2);
    	int[] result2 = intersect(arr,arr2);
    	System.out.println(Arrays.toString(result));
    	System.out.println(Arrays.toString(result2));
    }
}
