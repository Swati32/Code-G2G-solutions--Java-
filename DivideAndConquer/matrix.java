package DivideAndConquer;

public class matrix {

	public static void multiply(int[][] A,int[][] B){
		int[][] C = new int[A.length][B.length];
		
	    for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				C[i][j]=0;
				for(int k=0;k<A.length;k++){
					C[i][j] += A[i][k] * B[k][j];
				}
			}
	    }
	    for(int i=0;i<C.length;i++){
			for(int j=0;j<C[0].length;j++){
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
	    }
	    
	    
	}
	public static void main(String[] arg){
		int[][] A = {{1,2,4},
					 {1,2,4},
					 {1,2,4},
					 {1,2,4}};
		
		int[][] B={{1,2,4},
				 {1,2,4},
				 {1,2,4}};
		multiply(A,B);
		
		
		
	}
}
