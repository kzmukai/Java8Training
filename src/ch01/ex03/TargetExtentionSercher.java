package ch01.ex03;

/** 
 * java.io.File クラスのlist(FilenameFilter) を使用して、指定されたディレ
 * クトリの下の指定された拡張子を持つ、すべてのファイルを返すメソッドを書きなさい。 FilenameFilter
 * ではなく、ラムダ式を使用しなさい。エンクロージングスコープからキャプチャされる変数はどれですか。
 */
import java.io.File;

public class TargetExtentionSercher {

	public File[] getSubDirectory(File dir, String exten) {

		if (dir == null) {
			throw new NullPointerException();
		}

		if (exten == null) {
			throw new NullPointerException();
		}

		if (!dir.isDirectory()) {
			throw new IllegalArgumentException();
		}

		return dir.listFiles((file) -> (!file.isDirectory() && isTargetExtension(file, exten)));
	}

	private static boolean isTargetExtension(File file, String exten) {

		if (file == null || !file.isFile() || exten == null) {

			return false;
		}

		int index = file.getName().lastIndexOf(".");

		if (0 > index && index > file.getName().length()) {
			return false;
		}

		String targetString = file.getName().substring(index + 1).toLowerCase();

		if (targetString.equals(exten)) {
			return true;
		}

		return false;
	}
}