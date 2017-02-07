package Dynamic;

public class LongestCommonSubstring {
    
	
	//Recursive Solution
	// if Last Strings are common L[i]= L[i-1] +1;
	//else if String are not common L[i] = max(L[i-1]removing last character from first string ,L[i-1]removing last character from first string)
	//Time complexity of the above naive recursive approach is O(2^n)
	//cause for each node you are analyzing whether you can keep it or chuck it 
	
	public static int findLongestCommonSubstring(String S1,String S2){
		if(S1==null||S2==null || S1.length() ==0 || S2.length() ==0){
			return 0;
		}else{
			
			return lcs(S1,S2,S1.length()-1,S2.length()-1);
		}
	}
	public static int lcs(String S1,String S2,int m,int n){
		if(m<0||n<0){
			return 0;
		}else{
			if(S1.charAt(m) == S2.charAt(n)){
				return 1+lcs(S1,S2,m-1,n-1);
			}else{
				return Math.max(lcs(S1,S2,m-1,n),lcs(S1,S2,m,n-1));
			}
		}
	}
	
	//DP Solution
	// Time Complexity of the below implementation is O(mn) which is much better than the worst case time complexity of Naive Recursive implementation. 
	
	public static int findLongestCommonSubstringDynamic(String S1,String S2){
		if(S1==null||S2==null || S1.length() ==0 || S2.length() ==0){
			return 0;
		}else{
			int[][] LCS = new int [S1.length()][S2.length()];
			for(int i=0;i<LCS.length;i++){
				for(int j=0;j<LCS[0].length;j++){
					if(i==0||j==0){
						LCS[i][j] = (S1.charAt(i) == S2.charAt(j)) ? 1:0;
					}else{
						if(S1.charAt(i) == S2.charAt(j)){
							LCS[i][j] = 1+LCS[i-1][j-1];
						}else{
							LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
						}
					}
				}
			}
			return LCS[S1.length()-1][S2.length()-1];
		}
	}
	
	//Extension of DP solution Above
	public static void printLongestCommonSubstring(String S1,String S2){
		if(S1 == null || S2 == null || S1.length() ==0 || S2.length() == 0){
			return;
		}else{
			int[][] LCS = new int[S1.length()][S2.length()];
			for(int i=0;i<LCS.length;i++){
				for(int j=0;j<LCS[0].length;j++){
					if(i==0 || j==0){
						LCS[i][j] = (S1.charAt(i)==S2.charAt(j))? 1:0;
					}else{
						if(S1.charAt(i)==S2.charAt(j)){
							LCS[i][j] = 1+LCS[i-1][j-1];
						}else{
							LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
						}
					}
				}
			}
			//Common Character Index
			int cindex = LCS[LCS.length-1][LCS[0].length-1];
			char[] common = new char[cindex];
			cindex--;
			int m = LCS.length-1;
			int n = LCS[0].length-1;
			
			while(m>=0 && n>=0 && cindex>=0){
				if(S1.charAt(m) == S2.charAt(n)){
					common[cindex] = S1.charAt(m);
					cindex--;m--;n--;
				}else if(m-1>=0 && n-1>=0 && LCS[m-1][n]>LCS[m][n-1]){
					m--;
				}else{
					n--;
				}
			}
			
			for(int i=0;i<common.length;i++){
				System.out.print(common[i]);
			}
		}
	}
	public static void main(String[] arg){
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(findLongestCommonSubstring(s1,s2));
		System.out.println(findLongestCommonSubstringDynamic(s1,s2));
		printLongestCommonSubstring(s1,s2);
	}
}
