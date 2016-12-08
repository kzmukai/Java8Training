package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

/**
 * ラムダ式が次のような拡張¥texttt{for}ループ内の値をキャプチャした場合には、どうなりますか。
 *
 * <blockquote>
 * 
 * <pre>
 * String[] names = { "Peter", "Paul", "Mary" };
 * List<Runnable> runners = new ArrayList<>();
 * for (String name : names)
 *     runners.add(() -> System.out.println(name));
 * </blockquote>
 * </pre>
 * 
 * ＞ANSER Peter 、Paul、Mary
 * 
 * これは、正当なコードでしょうか。
 * ＞正当なコード
 * 各ラムダ式は異なる値をキャプチャするのでしょう か。それとも、すべてのラムダ式が最後の値をキャプチャするのでしょうか。従来の
 * ＞各ラムダ式は異なる値をキャプチャする.
 * 
 * <pre>
 * for (int i = 0; i < names.length; i++)
 * </pre>
 * 
 * ループを使用すると、どうなるでしょうか。
 * iを使うとコンパイルエラー
 * 
 *テスなし。
 */
public class Ex08 {

	public static void main(final String... args) {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		runners.stream().forEach(Runnable::run);

      for (int i = 0; i < names.length; i++) {
    	  int j = i; 
    	  runners.add(() -> System.out.println(names[j]));
          }
      runners.stream().forEach(Runnable::run);
  }

}
