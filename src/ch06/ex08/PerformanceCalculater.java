package ch06.ex08;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * みなさんのコンピュータでは、Arrays.parallelSort は、配列がどのくらいの大き さであればArrays.sort より速くなりますか。
 * 
要素数 : 9216
Single : 0.00196359秒
Multi  : 0.002056091秒
要素数 : 10240
Single : 0.002937544秒
Multi  : 0.001810505秒
 要素数 : 10240くらいから？
 *
 */
public class PerformanceCalculater {

	public static void CalculateSpeed() {
		String[] bigArray = new String[16 * 1024];
		Random random = new Random();
		for (int i = 0; i < bigArray.length; i++) {
			bigArray[i] = Double.toString(random.nextDouble());
		}
		final int COUNT = 64; 
		for (int n = 8 * 1024; n <= bigArray.length; n += 1024) {
			String[] array;
			long startTime;
			System.out.println("要素数 : " + n);
			long totalTime = 0;
			for (int i = 0; i < COUNT; i++) {
				array = Arrays.copyOf(bigArray, n);
				startTime = System.nanoTime();
				Arrays.sort(array);
				totalTime += System.nanoTime() - startTime;
			}
			System.out.println("Single : " + (totalTime / COUNT) / 1E9 + "秒");
			totalTime = 0;
			for (int i = 0; i < COUNT; i++) {
				array = Arrays.copyOf(bigArray, n);
				startTime = System.nanoTime();
				Arrays.parallelSort(array);
				totalTime += System.nanoTime() - startTime;
			}
			System.out.println("Multi  : " + (totalTime / COUNT) / 1E9 + "秒");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CalculateSpeed();
	}
}
