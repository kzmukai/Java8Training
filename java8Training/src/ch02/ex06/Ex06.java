package ch02.ex06;
/**
 * ページの2.3 節「filter、map、flatMap メソッド」のcharacterStream メソッ ドは、最初にArrayList 
  * を埋めて、それからそのリストをストリームに変換するとい う具合に、多少ぎこちないです。代わりに、ストリームを使用して、1 行で書きなさい。 
  * 適切な方法は、0 からs.length() - 1 までの整数のストリームを作成して、それを s::charAt メソッド参照でマップすることです。 
  */ 


import java.util.stream.*;

public class Ex06{

	   public static void main(final String... args) {
	        characterStream("Hello").forEach(System.out::println);
	    }

	    /**
	     * 与えられた文字列を 1 文字ずつ char にした Stream に変換する.
	     *
	     * @param str 対象文字列
	     * @return Stream
	     */
	    public static Stream<Character> characterStream(String str) {
	        return IntStream.range(0, str.length()).mapToObj(str::charAt);
	    }
}

