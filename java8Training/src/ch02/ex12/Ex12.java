package ch02.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 51 ページの2.13「並列ストリーム」で説明したように、AtomicInteger の配列を更新 することで、並列なStream
 * <String>内の短い単語をすべて数えなさい。個々のカウ ントを安全に増やすためにアトミックであるgetAndIncrement メソッドを使用しな
 * さい。
 */

public class Ex12 {
	private static final int MAX_STRING_LENGTH = 12;

	public static void main(String[] args) throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("C:\\test.txt")), StandardCharsets.UTF_8);
		Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));
		AtomicInteger[] counters = new AtomicInteger[MAX_STRING_LENGTH];
		Arrays.setAll(counters, n -> new AtomicInteger(0));
		words.parallel().forEach(s -> {
			if (s.length() < MAX_STRING_LENGTH) {
				counters[s.length()].getAndIncrement();
			}
		});
		// カウント結果の表示
		System.out.println(Stream.of(counters).mapToInt(AtomicInteger::get).reduce(0, (t, u) -> t + u));
	}
}
