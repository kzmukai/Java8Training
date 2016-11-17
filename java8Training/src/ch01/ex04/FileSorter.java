package ch01.ex04;

import java.io.File;
import java.util.Arrays;

/**
 * 練習問題4 Fileオブジェクトの配列が与えられたとします。その配列をソートして、ファイルの前
 * にディレクトリが来るようにし、ファイルとディレクトリのそれぞれのグループではパス
 * 名でソートされるようにしなさい。Comparatorではなく、ラムダ式を使用しなさい。
 */
public class FileSorter {

	enum FILETYPE {
		DIR, FILE, OTHER
	}

	public void sortFileFromDirectry(File[] files) {

		if (files == null) {
			throw new NullPointerException();
		}

		Arrays.sort(files, (file1, file2) -> {

			FILETYPE fileType1 = getFileType(file1);
			FILETYPE fileType2 = getFileType(file2);

			if (fileType1 == fileType2) {
				return file1.getName().compareTo(file2.getName());
			} else if (fileType1 == FILETYPE.DIR && fileType2 == FILETYPE.FILE) {
				return -1;
			} else if(fileType1 == FILETYPE.FILE && fileType2 == FILETYPE.DIR)  {
				return 1;
			}
			//その他が有った場合は、そのままにしておく
			return -1; 
		});

	}

	private FILETYPE getFileType(File file) {

		if (file.isDirectory()) {
			return FILETYPE.DIR;
		} else if (file.isFile()) {
			return FILETYPE.FILE;
		} else {
			return FILETYPE.OTHER;
		}
	}

}
