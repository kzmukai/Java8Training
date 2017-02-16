package ch08.ex08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/**
 * CheckedQueue クラスの利点を示すプログラムを書きなさい。 javadoc: ...キューには不正な型の要素が含まれないことが保証されます。
 * →実行時に要素の型チェックを行うQueue
 * 
 * 
 */

public class CheckedQuecheck {

	public static void main(String[] args) {
		Queue<Path> queue = new ArrayDeque<Path>();
		queue = Collections.checkedQueue(queue, Path.class);
		getMoreWork(queue); // ← このメソッド内でキャストエラー
		Object value;
		while ((value = queue.poll()) != null) {
			System.out.println(((Path) value).isAbsolute());
		}
	}

	private static void getMoreWork(Queue queue) {
		queue.offer(Paths.get("alice.txt")); // 正しい型の要素を追加
		queue.offer("war-and-peace.txt"); // 間違った型の要素を追加
	}
}
