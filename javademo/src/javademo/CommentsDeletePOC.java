package javademo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommentsDeletePOC{    

	public static void main( String a[] ) throws IOException    
	{    
		String filename="HeadFirst.java";
		String content = new String(Files.readAllBytes(Paths.get("C:\\LegalOneDev\\Workspace\\javademo\\src\\javademo\\HeadFirst.java")));
		System.out.println(content.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)",""));  
	}    


	static String readFile(String fileName) {    

		File file = new File(fileName);    

		char[] buffer = null;    

		try {    
			BufferedReader bufferedReader = new BufferedReader( new FileReader(file));    

			buffer = new char[(int)file.length()];    

			int i = 0;    
			int c = bufferedReader.read();    

			while (c != -1) {    
				buffer[i++] = (char)c;    
				c = bufferedReader.read();    
			}    

		} catch (IOException e) {    
			e.printStackTrace();    
		}    

		return new String(buffer);    
	}    

}    
