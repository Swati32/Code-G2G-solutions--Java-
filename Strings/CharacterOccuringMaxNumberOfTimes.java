package Strings;

public class CharacterOccuringMaxNumberOfTimes {
    public static char maxOccurences(String s){
    	if(s==null){
    		return ' ';
    	}else{
    		int[] count = new int[256];
    		for(int i=0; i<s.length(); i++){
    			count[(int)(s.charAt(i))]++;
    		}
    	
    		int max_index = 0;
    		for(int i=1;i<256;i++){
    			if(count[i]>count[max_index]){
    				max_index = i;
    			}
    		}
    		
    		return((char)(max_index));
    	}
    }
	public static void main(String[] arg){
		String s = "GeeksforGeeks";
		System.out.println(maxOccurences(s));
	}
}
