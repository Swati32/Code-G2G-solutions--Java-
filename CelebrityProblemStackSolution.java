
public class CelebrityProblemStackSolution {
	
		 
	public static boolean knows(boolean[][] MATRIX,int a, int b)
		{
		    return MATRIX[a][b];
		}
	
	public static int FindCelebrity(boolean[][] MATRIX,int n){
		int i=0;
		int j=n-1; 
		int celebCand1=-1;
		int celebCand2=-1;
		//knows(i,j) means i knows j
		
		while(i<j){ 
			
			if(knows(MATRIX,i,j)) 
				i++;
			else 
				j--;
		}
		
		for(int k=0 ;k<n; k++){
			if(i!=k && knows(MATRIX,i,k)) return 0;
		}
			
		return i+1;
	}
		
	
	
	public static void main(String[] arg) {
		boolean[][] MATRIX= new boolean[][]{{true, true, true, false},
			   {false, false, true, false},
			   {false, false, false, false},
			   {false, false, true, false}};
		int n =4;
		int celebrity = FindCelebrity(MATRIX,n);
		if(celebrity >0)
			System.out.println(celebrity);
		else
			System.out.println("No Celebrity");
	}
}
