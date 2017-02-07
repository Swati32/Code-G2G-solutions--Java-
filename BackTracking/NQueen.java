package BackTracking;

public class NQueen {
    static final int N=4;
	
	public static void solveNQueens(){
		int[][] sol = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sol[i][j]=0;
			}
		}
		
		if(recurNQueen(sol,0)){
			printsolution(sol);
		}else{
			System.out.println("Queens cannot be placed");
		}
	}
	public static boolean recurNQueen(int[][] sol,int placed){
		if(placed == N){
			return true;
		}else{
			for(int i=0;i<N;i++){
				if(isValidPlacement(i,placed,sol)){
					sol[i][placed] =1;
					if(recurNQueen(sol,placed+1)){
						return true;
					}else{
						sol[i][placed] = 0;
					}
				}
			}
			return false;
		}
	}
	
	public static boolean isValidPlacement(int x,int y, int[][] sol ){
		
		for(int i=y-1;i>=0;i--){             ///you wanna keep row constant change column
			if(sol[x][i] ==1){                // to see if any column had 1 for this ROW !!!!
				return false;
			}
		}
		
		
		for(int i=x-1,j=y-1;i>=0 && j>=0;i--,j--){
			if(sol[i][j] ==1){
				return false;
			}
		}
		
		
		
		for(int i=x-1,j=y+1;i<N && j<N && i>=0 && j>=0;i--,j++){
			if(sol[i][j] ==1){
				return false;
			}
		}
		return true;
	}
	public static void printsolution(int[][] sol){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(sol[i][j]==1)
					System.out.print(1+"  "); //-1 meaning unvisited
				else
					System.out.print(0+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String arg[]){
		
		solveNQueens();
	}
}
