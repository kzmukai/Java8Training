package ch03.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.junit.internal.runners.statements.ExpectException;

/*
* static メソッドである<T, U> Future<U> map(Future<T>, Function<T,
* U>) を提供しなさい。Future インタフェースのすべてのメソッドを実装した無名クラ スのオブジェクトを返しなさい。get
* メソッドで、関数を呼び出しなさい。
*/
public class Ex21 {
	public static <T, U> Future<U> map(Future<T> future, Function<T, U> mapper) {
		return new Future<U>() {
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			public boolean isCancelled() {
				return future.isCancelled();
			}

			public boolean isDone() {
				return future.isDone();
			}

			public U get() throws InterruptedException, ExecutionException {
				return mapper.apply(future.get());
			}

			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				return mapper.apply(future.get(timeout, unit));
			}
		};
	}
}