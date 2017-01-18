package ch06.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 *
 * 多数のスレッドが更新する最大長の文字列を管理するプログラムを書きなさい。 AtomicReference と適切な累積関数を使用しなさい
 */
public class StringManager {

	public static AtomicReference<String> maxLengthString = new AtomicReference<String>();

	public static List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get("c://target.txt")),
				StandardCharsets.UTF_8);
		return Arrays.asList(contents.split("[\\P{L}]+"));
	}

	public static void updateString(String s) {
		if (maxLengthString.get() == null)
			maxLengthString.set(s);
		maxLengthString.getAndAccumulate(s,
				(oldString, newString) -> newString.length() > oldString.length() ? newString : oldString);
	}

	public static String searchMaxLengthStringByParalell(Stream<String> strings) {
		strings.parallel().forEach(s -> updateString(s));
		return maxLengthString.get();
	}

	public static void main(String[] args) {

		try (Stream<String> strings = getWordsList().stream()) {
			searchMaxLengthStringByParalell(strings);
			System.out.println("max string was \"" + maxLengthString.get() + "\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
