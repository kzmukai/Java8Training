package ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * ページの2.1 節「イテレーションからストリーム操作へ」のfor ループの並列バー
 * ジョンを書きなさい。リストのセグメントごとに処理を行う別々のスレッドを多数生成
 * し、処理が終わるごとに結果を合計するようにしなさい（みなさんは、単一カウンターを 更新するためにスレッドを使用したくはないでしょう。なぜですか）。
 */

public class Ex01 {

	public static void main(final String... args) {
		final String contents;
		try {
			contents = new String(Files.readAllBytes(Paths.get("C:\\test.txt")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
		final List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));


	   final Counter count = new Counter();
       for (String w : words) {
           new Thread(() -> {
               if (w.length() > 12) {
            	   count.count++;
               }
               final int done;
               synchronized (Counter.class) {
                   done = ++count.done;
               }
               if (done == words.size()) {
                   System.out.println(count.count);
               }
           }).start();
       }
   }
}
   class Counter{
       int count = 0;
       int done = 0;
   }


