package ch02.ex13;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


    /**
/**
 * 
 * 練習問題12 に対して次の点を変更し、その問題を解きなさい。変更点として、短い文字列 はフィルターで取り出し、Collectors.groupingBy
 * とCollectors.counting と一緒にcollect メソッドを使用しなさい。
 */

public class Ex13 {

	    public static void main(final String... args) {
	        Map<Integer, Long> result = Stream.of("aaa", "bb", "c", "dddd", "eeeee", "fffffff")
	                .parallel().filter(s -> s.length() < 12)
	                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
	        for (final Map.Entry entry : result.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
	}