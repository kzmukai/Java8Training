package ch03.ex20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ListMapTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testMap() {
		List<Integer> iList = new ArrayList<>();

		for (int i = -128; i < 128; i++)
			iList.add(i);

		List<String> sList = ListMap.map(iList, (i) -> i.toString());

		int i = -128;
		for (String s : sList) {
			assertEquals(String.valueOf(i), s);
			i++;
		}

	}
}