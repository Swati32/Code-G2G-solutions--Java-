package Stacks;

public class MinTimeToRotOranges {
	
	public static int findMinTime(int[][] arr,int rows,int columns){
		if(arr==null||arr.length==0){
			return 0;
		}else{
			
			int iteration  = 0;
			while(true){
				int totalFresh = 0;
				int converted  = 0;
				boolean[][] visited = markAllUnvisited(rows,columns);
				
				for(int i=0;i<rows;i++){
					for(int j=0;j<columns;j++){
						int cell = arr[i][j];
						if(cell==1){
							totalFresh++;
						}else if(cell==2 && visited[i][j]){
							totalFresh++;
						}else if(cell==2){
							int freshrotten = checkSurroundings(arr,rows,columns,i,j,visited);
							converted+=freshrotten; 
						}
					}
				}
				
				iteration++;
				if(totalFresh==0){
					return iteration-1;
				}else if(totalFresh == converted){
					return iteration;
				}else if(totalFresh>0 && converted == 0){
					return -1;
				}
			}
		}
		
	}
	public static int checkSurroundings(int[][] arr,int rows,int columns,int i,int j,boolean[][] visited){
		int converted = 0;
		if(i-1>=0 && arr[i-1][j]==1){ arr[i-1][j]=2 ; visited[i-1][j] = true;converted++;}
		if(j-1>=0 && arr[i][j-1]==1){ arr[i][j-1]=2 ; visited[i][j-1] = true;converted++;}
		if(i+1<rows && arr[i+1][j]==1){ arr[i+1][j]=2 ; visited[i+1][j] = true;converted++;}
		if(j+1<columns && arr[i][j+1]==1){ arr[i][j+1]=2 ; visited[i][j+1] = true;converted++;}
		
		return converted;
	}
	
	public static boolean[][] markAllUnvisited(int rows,int columns){
		boolean[][] visited = new boolean[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				visited[i][j]=false;
			}
		}
		return visited;
	}
	
	
	public static void main(String[] arg){
		int[][] arr = new int[][]{ {2, 1, 0, 2, 1},
								   {1, 0, 1, 2, 1},
							       {1, 0, 0, 2, 1}};
       						       
	    System.out.println(findMinTime(arr,arr.length,arr[0].length));				       
	}

}

