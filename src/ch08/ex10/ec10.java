package ch08.ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ec10 {

	public static void search(String dir) throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get(dir))) {
			paths.filter(p -> !p.toFile().isDirectory()).filter(p -> {
				try {
					System.out.println(p);
					return Files.lines(p).anyMatch(s -> s.contains("transient") || s.contains("volatile"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return false;
			}).forEach(System.out::println);
		}
	}

	public static void main(String[] args) {
		try {
			search("C:\\test\\src.zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
