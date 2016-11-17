package ch02.ex04;

/** 
  * 配列int[] values = {1, 4, 9, 16} があるとします。Stream.of(values) 
  * は、何になるでしょうか。代わりに、int のストリームをどうやって取得できるでしょ 
  * うか。
  * 
  *  // java.util.stream.ReferencePipeline$Head@2a139a55
  *  
  *  //[I@1fb3ebeb
  *  
  *  	// 1 4 9 16
  *  
  */ 



import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };
		Stream<int[]> stream = Stream.of(values);
		System.out.println(stream);
		stream.forEach(System.out::println);

		IntStream intStream = IntStream.of(values);
		intStream.forEach(System.out::println);
	}
}
