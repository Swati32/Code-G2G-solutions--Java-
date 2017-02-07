package Strings;

public class areRotations {

	public static boolean areRotation(String s1, String s2){
		if(s1 == null && s2==null){
			return true;
		}else if(s1== null||s2==null){
			return false;
		}else{
			String concatenated = s1.concat(s1);
			return concatenated.contains(s2);
		}
	}
	public static void main(String[] arg){
		String s1 = "Geeks";
		String s2 = "fukre";
		System.out.println(areRotation(s1,s2));
	}
}
