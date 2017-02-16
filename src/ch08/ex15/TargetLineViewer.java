package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 
 *Files.linesとPattern#asPredicateを使用して、与えられた正規表現に一致するすべての行を表示する grep のようなプログラムを書け。
 * 
 */

public class TargetLineViewer {

	public static void main(String[] args) { 
		Path path = Paths.get("C:target.txt");
	    Pattern pattern = Pattern.compile(args[0]);
	    try (Stream<String> stream = Files.lines(path)) {
	        stream.filter(pattern.asPredicate())
	            .forEach(System.out::println);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }

		
	}
	
}
