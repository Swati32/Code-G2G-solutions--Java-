 import java.util.ArrayList;
import java.util.List;

public class DuplicatesOntimeO1space {
        public static List<Integer> repeating(int[] arr){
        	List<Integer> solutionlist= new ArrayList<Integer>();
        	if(arr == null ||arr.length<2) return solutionlist;
        	int count = 0;
        	int next_index = 0;
        	while(count<arr.length){
        		count++;
        		int temp = arr[next_index];
        		if(arr[next_index]>0) arr[next_index] = -1; else arr[next_index] += -1;
        		if(arr[next_index] == -2)  solutionlist.add(next_index);
        		if(temp>0) next_index =temp; else next_index = count;
        	}
        	return solutionlist;
        }
        
        public static void main(String[] arg){
        	int[] arr = new int[]{4, 2, 5, 5, 2, 3,3,3, 1};
        	
        	List<Integer> result = repeating(arr);
        	System.out.println(result);
        	
        }
}
