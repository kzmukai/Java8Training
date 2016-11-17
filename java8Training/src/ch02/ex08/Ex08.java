package ch02.ex08;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
 * メソッドを作成しなさい。そのメソッドは、ストリームであるfirst と second
 * から要素を交互に取り出し、どちらかのストリームから要素がなくなったら停止 します。
 */

public class Ex08 {

	
	
	    public static void main(final String... args) {
	        final Stream<String> first = Stream.of("a", "b", "c");
	        final Stream<String> second = Stream.of("A", "B", "C", "D", "E");
	        zip(first, second).forEach(System.out::println);
	    }

	    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
	        final List<T> firstList = first.collect(Collectors.toList());
	        final List<T> secondList = second.collect(Collectors.toList());
	        final int limit = Math.min(firstList.size(), secondList.size());
	        final Stream.Builder<T> builder = Stream.builder();
	        for (int i = 0; i < limit; i++) {
	            builder.add(firstList.get(i));
	            builder.add(secondList.get(i));
	        }
	        return builder.build();
	    }
	}