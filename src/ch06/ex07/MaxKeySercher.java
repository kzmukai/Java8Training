package ch06.ex07;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author budougumi0617
 * @note ConcurrentHashMap<String,Long>内で、
 *       最大値を持つキーを見つけなさい
 *       （同じ最大値を持つキーがあれば、どちらのキーでも構いません）。
 */
public class MaxKeySercher {
	public static Entry<String, Long> resultEntries;

	public static String getKeyHasMaxValue(ConcurrentHashMap<String, Long> map) {
		resultEntries = map.reduceEntries(1, (entry1, entry2) -> entry1.getValue()
				.compareTo(entry2.getValue()) > 0 ? entry1 : entry2);
		return resultEntries.getKey();
	}
}

