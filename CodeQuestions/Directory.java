package CodeQuestions;

import java.util.Stack;

public class Directory {
	static class Dir {
		  int level;
		  int PathLengthTillHere;
		}

		static int getLongestAbsolutePathInFileSystem(String fileSystem_) {
		  Stack<Dir> st = new Stack<Dir>();
		  int longestPath = 0;
		  
		  for(String rec : fileSystem_.split("\n")){
			  int level = rec.lastIndexOf(" ");
			  while(!st.isEmpty()&& level<= st.peek().level){
				  st.pop();
			  }
			  if(rec.contains(".")){
				  if(rec.contains(".gif")||rec.contains(".png")||rec.contains(".jpeg")){
					  longestPath = Math.max(longestPath, st.peek().PathLengthTillHere);
				  }
			  }else{
				  int name_length = rec.trim().length()+1;
				  Dir new_directory = new Dir();
				  new_directory.level=level;
				  new_directory.PathLengthTillHere = (st.isEmpty())?name_length:st.peek().PathLengthTillHere+ name_length;
				  st.push(new_directory);
			  }
		  }
		  return longestPath;
		}
		public static void main(String[] args) {
	       String S="dir1\n dir11\n dir12\n  Picture.jpeg\n  dir121\n  file.txt\ndir2\n file2.gif";
	       System.out.println(getLongestAbsolutePathInFileSystem(S));
	   }

}
