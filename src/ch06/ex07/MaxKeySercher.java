package ch06.ex07;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author budougumi0617
 * @note ConcurrentHashMap<String,Long>内で、 最大値を持つキーを見つけなさい
 *       （同じ最大値を持つキーがあれば、どちらのキーでも構いません）。
 */
public class MaxKeySercher {

	public static ConcurrentHashMap<String, Long> SerchMaxKey() throws IOException  {
		List<String> words;
		ConcurrentHashMap<String, Long> map;
		String contents = new String(Files.readAllBytes(Paths.get("C:\\workspace\\repo.git\\Java8Training\\Resource\\wordTexst.txt")), StandardCharsets.UTF_8);
		words = Arrays.asList(contents.split("[\\P{L}]+"));

		map = (ConcurrentHashMap<String, Long>)words.stream()  
		    .filter(w -> w.length() >= 4)
		    .map(String::toLowerCase)
		    .collect(
		        Collectors.toConcurrentMap( 
		            Function.identity(),
		            w -> 1L,
		            Long::sum
		        )
		    );
		return map;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		ConcurrentHashMap<String, Long> map = SerchMaxKey() ;
		Map.Entry<String, Long> maxCount = map.reduceEntries(
			    1,
			    (e1, e2) -> e1.getValue() > e2.getValue() ? e1: e2
			);
			System.out.println("一番使用されていた単語 ：" + maxCount.getKey());
	}

	
}
