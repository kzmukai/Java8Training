package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/** 
  * ウェブページの内容を読み込んで、ファイルに保存するプログラムを作成しなさい。 URL.openStream とFiles.copy を使用しなさい。 
  */ 

public class SavingURL {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://www.google.co.jp/");
		try (InputStream stream = url.openStream()) {
		    Files.copy(stream, Paths.get("C://google"), StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
