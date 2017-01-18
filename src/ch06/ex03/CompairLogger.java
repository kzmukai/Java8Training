package ch06.ex03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
*
* 1,000 個のスレッドを生成し、各スレッドは、ある1 つのカウンターを100,000 回だけ 1 ずつ増加させます。AtomicLong
* とLongAdder を使用した場合の性能を比較しな さい。
結果
 経過時間 : 1.990926451秒
カウンタ : 100000000
経過時間 : 2.218504441秒
カウンタ : 100000000
*/
public class CompairLogger {

	
	public static void main(String[] args) throws InterruptedException {
		
		final int TASK = 1000;
		final int COUNT = 100_000;

		AtomicLong globalCounter = new AtomicLong(0);
		CountDownLatch latch = new CountDownLatch(TASK);
		ExecutorService pool = Executors.newCachedThreadPool();
		long startTime = System.nanoTime();
		for (int n = 0; n < TASK; n++) {
		    pool.submit(
		        () -> {
		            for (int i = 0; i < COUNT; i++) {
		                globalCounter.incrementAndGet();
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		latch.await();
		System.out.println("経過時間 : " + (System.nanoTime() - startTime)/1E9 + "秒");
		System.out.println("カウンタ : " + globalCounter);
		
		

		LongAdder globalCounterforLongAdder = new LongAdder();
		CountDownLatch latchforLongAdder = new CountDownLatch(TASK);
		ExecutorService poolforLongAdder = Executors.newCachedThreadPool();
		long startTimeforLongAdder = System.nanoTime();
		for (int n = 0; n < TASK; n++) {
			poolforLongAdder.submit(
		        () -> {
		            for (int i = 0; i < COUNT; i++) {
		            	globalCounterforLongAdder.increment();
		            }
		            latchforLongAdder.countDown();
		        }
		    );
		}
		poolforLongAdder.shutdown();
		latchforLongAdder.await();
		System.out.println("経過時間 : " + (System.nanoTime() - startTime)/1E9 + "秒");
		System.out.println("カウンタ : " + globalCounter);
		
	}
}
