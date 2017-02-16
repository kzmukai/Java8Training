package ch08.ex01;

/**
 * 
 * int 値と符号なし操作を使用して、0 から232 − 1 までの間の数値の加算、減算、除算、
 * 比較を行うプログラムを書きなさい。divideUnsigned とremainderUnsigned が 必要な理由を示しなさい。
 *
 */

public class Int {

	public static void main(String arges[]) {

		// 加算
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE + 1;
		System.out.println(Integer.toUnsignedString(a + b));

		// 減算
		int c = Integer.MAX_VALUE + 2;
		int d = 1;
		System.out.println(Integer.toUnsignedString(c - d));

		int e = Integer.MAX_VALUE + Integer.MAX_VALUE + 1;
		int f = 4;
		System.out.println("商 : " + (e / f) + " 余り : " + (e % f));

		//比較
		int g = 1;
		int bh = -1; 
		System.out.println(Integer.compareUnsigned(a, b)); 

	}
}
