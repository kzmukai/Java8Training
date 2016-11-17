package ch01.ex03;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import ch01.ex02.DirectoryInfoSearcher;

public class TargetExtentionSercherTest {

	private String[] resultStrings = { ".\\src\\ch01\\ex03\\sample\\test1.txt", ".\\src\\ch01\\ex03\\sample\\test2.txt", ".\\src\\ch01\\ex03\\sample\\test3.txt"};
	
	@Test
	public void getSubDirectoryTest() {
		TargetExtentionSercher teDirSearcher = new TargetExtentionSercher();

		File file = new File(".\\src\\ch01\\ex03\\sample\\");
		File[] fileArray = teDirSearcher.getSubDirectory(file,"txt");

		for (int i = 0; i < fileArray.length; i++) {
			// ".\分飛ばす
			int beginIndex = 2;
			int endIndex = fileArray[i].toString().length();

			if(!resultStrings[i].equals(fileArray[i].toString())){
				assertTrue(false);
			}
		}
		assertTrue(true);
	}

}
