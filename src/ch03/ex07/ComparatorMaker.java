package ch03.ex07;

import java.util.Comparator;

/** 
  * Comparator<String>を生成するメソッドを書きなさい。普通の順序、逆順、大文字 
  * 小文字を区別、大文字小文字を区別しない、空白を含める、空白を除外する、あるいは、 
  * これらの組み合わせとすることができるComparator<String>にしなさい。メソッド は、ラムダ式を返すようにしなさい。 
  */ 


public class ComparatorMaker{
	
	
	public static Comparator<String> comparator(
		    boolean reverse,       // 逆順
		    boolean ignoreCase,    // 大文字・小文字を区別しない
		    boolean excludeSpace)  // 空白を除外
		{
		    return (t, u) -> {
		        int sign = reverse ? -1: 1;
		        if (ignoreCase) {
		            t = t.toLowerCase();
		            u = u.toLowerCase();
		        }
		        if (excludeSpace) {
		            t = t.replaceAll("\\s", "");
		            u = u.replaceAll("\\s", "");
		        }
		        // 比較
		        return sign * t.compareTo(u);
		    };
		}	
	
}