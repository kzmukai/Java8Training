package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 71 ページの3.8 節「例外の取り扱い」のdoInOrderAsync を実装し、2 つ目のパラメー
 * タはBiConsumer<T, Throwable>としなさい。うまいユースケースを示しなさい。 3 つ目のパラメータは必要ですか。
 */
public class Ex16 {

	
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
	    new Thread(
	        () ->  {
	            T result = null;
	            try {
	                result = first.get();
	                second.accept(result, null);
	            } catch (Throwable th) {
	                second.accept(result, th);
	            }
	        }
	    ).start();
	}
	
	//うまいユースケースを示しなさい
	//分かりません
}
