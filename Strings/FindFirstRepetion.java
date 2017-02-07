package Strings;

import java.util.Arrays;

public class FindFirstRepetion {
	static class Count{
		int count= 0;
		int firstindex = -1;
	}
	public static int findFirstRepetitionIndex(String s){
		if(s==null||s.length() == 0){
			return 0;
		}else{
			
			Count[] counts = new Count[256];
			for(int i=0;i<256;i++){
				counts[i] = new Count();
			}
			
			for(int i=0 ; i< s.length() ;i++){
				int ch = Character.getNumericValue(s.charAt(i));
				if(counts[ch].firstindex== -1){
					counts[ch].firstindex = i;
				}
				counts[ch].count++;
			}
			
			Count result = new Count();
			for(int i=0;i<256;i++){
				if(counts[i].count== 1 && result.firstindex == -1){
					result =counts[i];
				}
			}
			
			return result.firstindex;
		}
	
	}
	
	
	static String printHoldings(String portfolioString) {
        String st[] = portfolioString.split("@");
         Arrays.sort(st);
         
         String res  = "";
       
        for(int i = 0; i < st.length; i++)
        {
             String[] newRes = (st[i].split(","));         
             res += "[" + newRes[0]+" ,"+newRes[1]+" ,"+newRes[2]+"],";
            
        }
        
        res = res.substring(0, res.length()-1); 
        return res;
    }
	
	public static void main(String[] arg){
		String s = "GeeksforGeeks";
		int index = findFirstRepetitionIndex(s);
		if(index == -1){
			System.out.println("No such character");
		}else{
			System.out.println(s.charAt(index));
		}	
		
		String test = "BLK,BlackRock,65@JPM,JPMorgan,78@BK,Bank of New York Mellon,13@WFC,Wells Fargo & Co,25";
		System.out.println(printHoldings(test));
	}
}
