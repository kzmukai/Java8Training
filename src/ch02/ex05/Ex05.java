package ch02.ex05;

import java.util.stream.Stream;

/**
 * 
 *  * Stream.iterate を使用して乱数の無限ストリームを生成しなさい。このとき、 
  * Math.random を呼び出すのではなく、線形合同生成機（linear congruential generator） 
  * を直接実装すること。そのような生成器では、x0 = seed で始めて、a、c、m の適切 
  * な値に対して、xn+1 = (axn +c) % m を生成します。パラメータa、c、m、seed を受け 
  * 取り、Stream<Long>を生成するメソッドを実装しなさい。a = 25214903917、c = 11、 
  * m = 248 を試してみなさい。 
 * 
 */
public class Ex05 {

	  public static void main(final String... args) {
	        final long a = 25214903917L;
	        final int c = 11;
	        final long m = (long) Math.pow(2, 48);
	        final Stream<Long> stream = Stream.iterate(System.currentTimeMillis(), x -> ((a * x + c) % m)).skip(1);
	        stream.limit(10).forEach(System.out::println);
	    }
}

