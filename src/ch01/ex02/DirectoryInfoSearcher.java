package ch01.ex02;
/**
*java.io.File クラスのlistFiles(FileFilter) メソッドとisDirectory メ 
* ソッドを使用して、指定されたディレクトの下のすべてのサブディレクトリを返すメソッ ドを書きなさい。FileFilter 
* オブジェクトではなく、ラムダ式を使用しなさい。同じ ことを、メソッド参照を用いて行いなさい。 
*/ 

import java.io.File;

public class DirectoryInfoSearcher {

	
	/**
	 * ラムダ式を用いて指定されたディレクトの下のすべてのサブディレクトリを取得する。
	 * 
	 * @param dir java.io.File
	 * @return　サブディレクトリ
	 */
	public File[] getSubDirectory(File dir) {
		if (dir == null) {
			throw new NullPointerException();
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException();
		}
		return dir.listFiles(f -> f.isDirectory());
	}
	
	/**
	 * メソッド参照を用いて指定されたディレクトの下のすべてのサブディレクトリを取得する。
	 * 
	 * @param dir java.io.File
	 * @return　サブディレクトリ
	 */
	public File[] getsubDirectoryByMethod(File dir) {

		if (dir == null) {
			throw new NullPointerException();
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException();
		}
		return dir.listFiles(DirectoryInfoSearcher::dirFilter);
	}
	private static boolean dirFilter(File file){
		return file.isDirectory();
	}

}
