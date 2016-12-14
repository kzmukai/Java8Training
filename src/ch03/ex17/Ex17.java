package ch03.ex17;

import java.util.function.Consumer;

/**
 * first とsecond を並列に実行し、どちらかのメソッドが例外をスローしたら handler
 * を呼び出すdoInParallelAsync(Runnable first, Runnable second, Consumer<Throwable>
 * handler) を実装しなさい。
 */
public class Ex17 {

	
	public  static Runnable handle(Runnable runner, Consumer<Throwable> handler) {
	    return () -> {
	        try {
	            runner.run();
	        } catch (Throwable th) {
	            handler.accept(th);
	        }
	    };
	}
	
	
	public static void doInParallelAsync(Runnable first, Runnable second,
		    Consumer<Throwable> handler)
		{
		    new Thread(handle(first,  handler)).start();
		    new Thread(handle(second, handler)).start();
		}
}
