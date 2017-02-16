package ch08.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 *
 * * 第2 章の初めで、リスト内の長い単語をwords.stream().filter(w -> w.length() > 12).count()
 * で数えました。ラムダ式を用いて、ストリームを使用 しないで、同じことを行いなさい。長いリストに対してはどちらの操作が速いですか。
 * 
 * 結果
 * 0.074 //Stream
 * 0.004 //removeIf
 */

public class WordCount {

	private static final int LENGTH_THRESHORLD = 12; 
	 	private static final int MAX = 1000; 

	public static void main(String[] args) throws IOException {
		
		
		String contents = new String(Files.readAllBytes(Paths.get("./Resource/wordTexst.txt")), StandardCharsets.UTF_8);
		List<String> words = new ArrayList<String>(Arrays.asList(contents.split("[\\P{L}]+")));
		double result = 0;
		for (int i = 0; i < MAX; i++) {
			result += measure(l -> l.stream().filter(w -> w.length() > LENGTH_THRESHORLD).count(), words);
		}
		System.out.println(result / MAX);

		result = 0;
		for (int i = 0; i < MAX; i++) {
			result += measure(l -> l.removeIf(w -> w.length() <= LENGTH_THRESHORLD), words);
		}
		System.out.println(result / MAX);

	}

	private static long measure(Function<List<String>, ?> consumer, List<String> l) {
		long start = System.currentTimeMillis();
		consumer.apply(l);
		return System.currentTimeMillis() - start;
	}

}
