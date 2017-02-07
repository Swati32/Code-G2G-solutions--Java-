package BackTracking;

public class RatMaze {
	static int N = 4;
	public void solveMaze(int[][] maze){
		int	sol[][] =  {{0, 0, 0, 0},
            			{0, 0, 0, 0},
            			{0, 0, 0, 0},
            			{0, 0, 0, 0}};
		
		sol[0][0] = 1;
		if(recurPath(0,0,sol,maze)){
			printsolution(sol);
		}else{
			System.out.println("No path from source to destination");
		}
	}
	public static boolean recurPath(int x,int y,int[][] sol,int[][] maze){
		if(x==N-1 && y==N-1){
			return true;
		}else{
			int[] xmoves = {1,0};
			int[] ymoves = {0,1};
			for(int k=0;k<2;k++){
				int i=x+xmoves[k]; 
				int j=y+ymoves[k];
				if(isValid(i,j,maze)){
					sol[i][j] = 1;
					if(recurPath(i,j,sol,maze)){
						return true;
					}else{
						sol[i][j]=0;
					}
				}
			}
			return false;
		}
	}
	
	public static void printsolution(int[][] sol){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(sol[i][j]+"  "); //-1 meaning unvisited
			}
			System.out.println();
		}
	}
	
	public static boolean isValid(int x, int y,int[][] maze){
		return (x<N && x>=0 && y>=0 && y<N && maze[x][y] == 1);
	}
	public static void main(String[] arg){
		 RatMaze r = new RatMaze();
		 // 0s are dead end 
		 // Source 0,0 Destination 3,3
		int[][] maze=  {{1, 0, 0, 0},
		            	{1, 1, 0, 1},
		            	{0, 1, 0, 0},
		            	{1, 1, 1, 1}};
		 
		r.solveMaze(maze);
	}
}
