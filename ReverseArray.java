import java.util.Arrays;

public class ReverseArray {

	public static int[] reverse(int[] arr){
		if(arr == null || arr.length<2)
			return arr;
		int i=0;
		int j=arr.length-1;
		while(i<j){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		return arr;
	}
	
	public static String reverseString(String arr){
		if(arr == null || arr.length()<2)
			return arr;
		StringBuilder str = new StringBuilder(arr);
		
		int i=0;
		int j=arr.length()-1;
		while(i<j){
			char temp = str.charAt(i);
			str.setCharAt(i,str.charAt(j));
			str.setCharAt(j,temp);
			i++;
			j--;
		}
		return str.toString();
	}
	
	public static void main(String[] arg){
		int[] arr =  new int[] {1,2,3,4,5};
		int[] result = reverse(arr);
		System.out.println(Arrays.toString(result));
		String s = "SwatiS";
		String resultb = reverseString(s);
		System.out.println(resultb);
	}
	
}

/*String myName = "domanokz";
char[] myNameChars = myName.toCharArray();
myNameChars[4] = 'x';
myName = String.valueOf(myNameChars);*/