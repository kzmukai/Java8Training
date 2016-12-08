package ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileSorterTest {

	
	private String[] resultStrings = { "ch01","ex04","2test.txt","3test.txt","test1.txt"};
	
	@Test
	public void test() {
		FileSorter fs = new FileSorter();
		File file = new File(".\\src\\ch01\\ex04\\sample\\test1.txt");
		File file1 = new File(".\\src\\ch01\\ex04\\sample\\2test.txt");
		File file2 = new File(".\\src\\ch01\\ex04\\sample\\3test.txt");
		File file3 = new File(".\\src\\ch01\\ex04");
		File file4 = new File(".\\src\\ch01");
		
		
		
		File[] files ={file,file1,file2,file3,file4}; 
		
		fs.sortFileFromDirectry(files);
		
		for(int i = 0; i < files.length ; i++){
			
			if(!resultStrings[i].equals(files[i].getName())){
				
			}
		}
	}
}
