package ch09.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReverseWord {
	public static void main(String[] args) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("C:\\wordTexst.txt"));
		StringBuilder content = new StringBuilder(new String(bytes));
		content.reverse();
		Files.write(Paths.get("C:\\Result3.txt"), content.toString().getBytes(StandardCharsets.UTF_8));

	}
}
