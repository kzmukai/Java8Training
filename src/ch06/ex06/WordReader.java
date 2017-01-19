package ch06.ex06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * マップを更新するメソッドとして、merge の代わりにcomputeIfAbsent を使用して、 練習問題5
 * と同じアプリケーションを作成しなさい。この方法の利点は何ですか。
 */

public class WordReader implements AutoCloseable {
	private final BufferedReader reader;
	private List<String> words = Collections.emptyList();

	public WordReader(File file) throws IOException {
		this(file, StandardCharsets.UTF_8);
	}

	public WordReader(File file, Charset charset) throws IOException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
	}

	public void close() throws IOException {
		reader.close();
	}

	public String getWord() throws IOException {
		while (words.isEmpty()) {
			String line = reader.readLine();
			if (line == null) {
				return null;
			}
			words = new LinkedList<String>(Arrays.asList(line.split("[\\P{L}]+")));
		}
		return words.remove(0);
	}

	public static ConcurrentHashMap<String, Set<File>> getWordMapInfo() throws InterruptedException {

		ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService pool = Executors.newCachedThreadPool();
		for (File file : new File("C:\\workspace\\repo.git\\Java8Training\\Resource\\6_5\\")
				.listFiles(f -> f.getName().endsWith(".txt"))) {
			pool.submit(() -> {
				try {
					try (WordReader reader = new WordReader(file)) {
						String word;
						while ((word = reader.getWord()) != null) {
							map.computeIfAbsent(word, key -> ConcurrentHashMap.newKeySet()).add(file);
						}
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				latch.countDown();
			});
		}
		return map;
	}

	public static void main(String[] args) throws InterruptedException {

		ConcurrentHashMap<String, Set<File>> map = getWordMapInfo();
		Thread.sleep(5000);
		System.out.println("show result;");
		for (Map.Entry<String, Set<File>> en : map.entrySet()) {
			System.out.println("keyword : " + en.getKey() + ",  value : " + en.getValue());
		}
	}
}
