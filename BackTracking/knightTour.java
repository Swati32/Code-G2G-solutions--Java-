package BackTracking;

public class knightTour {
	
	public static void solveKT(){
		int[][] sol = new int[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				sol[i][j] = -1; //-1 meaning unvisited
			}
		}
		sol[0][0]=0;
	    if(solveKTrecur(0,0,sol,1)){
	    	
	    	printsolutionKT(sol);
	    }else{
	    	System.out.println("No possible tours");
	    }
	}
	public static boolean solveKTrecur(int i,int j, int[][] sol,int move){
		if(move >= 64){
			return true;
		}else{
			
			//printsolutionKT(sol);
			int[] xmoves = {2, 1, -1, -2, -2, -1, 1, 2};
			int[] ymoves = {1, 2, 2, 1, -1, -2, -2, -1};
			for(int k=0;k<8;k++){
				if(isValidMove(i+xmoves[k],j+ymoves[k],sol)){
					i=i+xmoves[k];
					j=j+ymoves[k];
					sol[i][j] = move;
					if(solveKTrecur(i,j,sol,move+1)){
						return true;
					}else{
						sol[i][j] = -1;
						i=i-xmoves[k];
						j=j-ymoves[k];
					}
				}
			}
		 return false;	
		}
	}
	public static boolean isValidMove(int x,int y,int[][] sol){
		return (x >= 0 && x < 8 && y >= 0 &&
				y < 8 && sol[x][y] == -1);
	}
	
	public static void printsolutionKT(int[][] sol){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(sol[i][j]+"  "); //-1 meaning unvisited
			}
			System.out.println();
		}
	}
	
	public static void main(String[] arg){
		solveKT();
	}
}
