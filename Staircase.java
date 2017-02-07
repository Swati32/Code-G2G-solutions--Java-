
public class Staircase {
	static void StairCase(int n) {
        for(int i=0;i<n;i++){
            for(int j=n-i-2;j>=0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("#");
            }
            System.out.println();
        }
	}
	
	public static void main(String[] arg){
		StairCase(5);
	}

}
