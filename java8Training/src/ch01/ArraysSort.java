package ch01;

import java.util.Arrays;
import java.util.Comparator;

/*
練習問題1 
Arrays.sortメソッド内で呼び出されているコンパレータのコードは，sortメソッドを 
呼び出したスレッドで実行されるでしょうか.  
それとも，別のスレッドで実行されるでしょうか． 
*/

/**
 * 回答、System.outした結果がmainと出力されるため、
 * 呼び出したスレッドで実行される。
 * 
 *
 */

public class ArraysSort {

	public static void main(String[] args) {

		//確認用
		Integer[] intArray = {5, 4, 3, 6, 1};
		Arrays.sort(intArray, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				System.out.println(Thread.currentThread().getName());
				return 0;
			}
		});
	}
	

}
