package ch06.ex09;

import java.util.Arrays;

/**
 * フィボナッチ（Fibonacci）数の計算を並列化するためにparallelPrefix メソッドを使 用することができます。n
 * 番目のフィボナッチ数は、F = 1 1 1 0 とした場合の、Fn を計算した結果の行列の左上の値です。2 × 2 の行列で配列を埋めなさい。乗算のメソッ
 * ドを持つMatrix クラスを定義し、行列の配列を作成するためにparallelSetAll を
 * 使用し、行列の乗算をするためにparallelPrefix を使用しなさい。
 */

public class Matrix {
	/**
	 * 要素の配列<br>
	 * 1オリジンなのでインデックス 0 は使わない
	 */
	private double[][] a = new double[2 + 1][2 + 1];

	/** default コンストラクタ */
	public Matrix() {
	}

	/** 全ての要素を指定するコンストラクタ */
	public Matrix(double a11, double a12, double a21, double a22) {
		a[1][1] = a11;
		a[1][2] = a12;
		a[2][1] = a21;
		a[2][2] = a22;
	}

	/** 要素の取得 */
	public double get(int row, int column) {
		return a[row][column];
	}

	/** 要素の設定 */
	public void set(int row, int column, double value) {
		a[row][column] = value;
	}

	/** 乗算 */
	public Matrix multiply(Matrix other) {
		Matrix result = new Matrix();
		for (int row = 1; row <= 2; row++) {
			for (int column = 1; column <= 2; column++) {
				result.a[row][column] = 0;
				for (int i = 1; i <= 2; i++) {
					result.a[row][column] += a[row][i] * other.a[i][column];
				}
			}
		}
		return result;
	}


	public static void main(String[] args) throws InterruptedException {

		final Matrix F = new Matrix(1, 1, 1, 0);
		Matrix[] array = new Matrix[100];
		Arrays.parallelSetAll(array, i -> F); 
		Arrays.parallelPrefix(array, Matrix::multiply); 
		Arrays.stream(array).forEach(m -> System.out.println(m.get(1, 1)));
	}
}