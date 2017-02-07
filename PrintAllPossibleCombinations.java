import java.util.Arrays;

public class PrintAllPossibleCombinations {
	
	public static void print_all_recursion(int[] arr,int r){ 
             int[] data= new int[r];
             findcombination(arr,data,0,arr.length-1,0,r);
             
	}
	
	public static void findcombination(int arr[], int data[], int start, int end,int index, int r){
		System.out.println(Arrays.toString(data)+" "+ start+" " +end + " " +index+" "+ r);
		if(index==r){
			System.out.println(Arrays.toString(data)); return;
		}
		
		for(int i=start;i<=end && end-i+1 >= r-index; i++){ //=end wali condtion  important he....also end-i+1 >= r-index 
			data[index]=arr[i];
			findcombination(arr,data,i+1,end,index+1,r); 
		}
	}
	public static void main(String[] arg){
	   int[] arr1 =  new int[] {1, 2, 3, 4, 5};	
	   int r = 3;
	   int data[] = new int [r];
		
	   print_all_recursion(arr1,r);
	}

}
