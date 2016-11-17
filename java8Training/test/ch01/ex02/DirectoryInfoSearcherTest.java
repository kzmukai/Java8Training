package ch01.ex02;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class DirectoryInfoSearcherTest {

	private String[] resultStrings = { "settings", "bin", "src", "test" };

	@Test
	public void getSubDirectoryTest() {

		DirectoryInfoSearcher dirSearcher = new DirectoryInfoSearcher();

		File file = new File(".\\");
		File[] fileArray = dirSearcher.getSubDirectory(file);

		for (int i = 0; i < fileArray.length; i++) {
			// ".\分飛ばす
			int beginIndex = 2;
			int endIndex = fileArray[i].toString().length();
			String resultsr = fileArray[i].toString().substring(beginIndex, endIndex);
			if (!resultStrings[i].equals(resultsr)) {
				assertTrue(false);
			}
		}
	}

	@Test
	public void getsubDirectoryByMethodTest() {
		DirectoryInfoSearcher dirSearcher = new DirectoryInfoSearcher();

		File file = new File(".\\");
		File[] fileArray = dirSearcher.getsubDirectoryByMethod(file);

		for (int i = 0; i < fileArray.length; i++) {
			
			int beginIndex = 2;// ".\分飛ばす
			int endIndex = fileArray[i].toString().length();
			String resultsr = fileArray[i].toString().substring(beginIndex, endIndex);
			if (!resultStrings[i].equals(resultsr)) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}


}
