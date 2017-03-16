package ch09.ex06;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class ReverseLine {
	
		     public static void main(String[] args) throws IOException { 
		    	 List<String> lines = Files.readAllLines(Paths.get(("C:\\wordTexst.txt")));
		    	 Collections.reverse(lines);
		    	 Files.write(Paths.get("C:\\Result1.txt"), lines);
		     } 

}


