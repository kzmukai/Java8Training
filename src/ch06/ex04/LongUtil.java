package ch06.ex04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class LongUtil {
	
	public static void main(String[] args) throws InterruptedException {
		long[] values = new long[1000_0000];
		for (int i = 0; i < values.length; i++) {
		    values[i] = (long)(1000_0000 * Math.random());
		}
		
		final int TASK = 1000;
		final int COUNT = 10000;
		LongAccumulator max = new LongAccumulator(Math::max, Long.MIN_VALUE);
		CountDownLatch latch = new CountDownLatch(TASK);
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int n = 0; n < TASK; n++) {
		    int start = COUNT * n;
		    int end   = Math.min(start + COUNT, values.length);
		    pool.submit(
		        () -> {
		            for (int i = start; i < end; i++) {
		                max.accumulate(values[i]);
		            }
		            latch.countDown();
		        }
		    );
		}
		pool.shutdown();
		latch.await();
		System.out.println("最大値 : " + max);
	}
}
