package ch09.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * 212 ページの9.1.1 節「try-with-resources 文」の最後にあるScanner とPrinter
 * を生成しているコードを、try-with-resources 文を使用しないで実装しなさい。両方のオブジェ
 * クトが適切に生成された場合には、両方のオブジェクトをきちんとクローズしなさい。次 の事柄を考慮すること。 Scanner
 * のコンストラクタは、例外をスローする。 PrintWriter のコンストラクタは、例外をスローする。 hasNext、next、println
 * のメソッドは、例外をスローする。 in.close() は、例外をスローする。 out.close() は、例外をスローする。
 */

public class NoTryWithResource {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = Files.newBufferedReader(Paths.get("C:\\wordTexst.txt"));
		try {
			BufferedWriter out = Files.newBufferedWriter(Paths.get("C:\\Result1.txt"));
			try {
				String line;
				while ((line = in.readLine()) != null) {
					out.write(line.toLowerCase());
					out.newLine();
				}
			} finally {
				out.close();
			}
		} finally {
			in.close();
		}

	}
}
