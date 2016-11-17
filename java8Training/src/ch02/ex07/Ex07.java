package ch02.ex07;


import java.io.IOException;
import java.util.stream.Stream;

/**
 * 
 * 上司が、メソッドとしてpublic static <T> boolean isFinite( Stream<T> * stream)
 * を作成するように求めています。それは、よくない考えでしょうか。まずは作 成してから、考えてみなさい。
 *
Streamには有限か無限かを調べるメソッドはない。
実行結果の返しかたがわからない。
よって：「良くない考え」

 */

public class Ex07 {


		private static final long SEED = 0l;
		private static final long GAP = 1000l;

		public static void main(String[] args) throws IOException {
			System.out.println(isFinite(createInfiniteStream()));
		}

		private static Stream<Long> createInfiniteStream() {
			return Stream.iterate(SEED, (v) -> {
				try {
					Thread.sleep(GAP);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return v + 1;
			});
		}

		public static <T> boolean isFinite(Stream<T> stream) {
			return false; 
			
		}
	}
