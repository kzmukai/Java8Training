package ch03.ex09;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

public class CompTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void conpfield1() {
		
		OneFieldOnly ofa1 = new OneFieldOnly("a");
		OneFieldOnly ofa2 = new OneFieldOnly("a");
		OneFieldOnly ofb = new OneFieldOnly("b");
		
		
		 Comparator<OneFieldOnly> cmp = (Comparator<OneFieldOnly>) Comp.lexicographicComparator("field");
		 
		 assertThat(cmp.compare(ofa1, ofa2),is(0));
		 assertThat(cmp.compare(ofa1, ofb),is(-1));
		 assertThat(cmp.compare(ofb, ofa1),is(1));
	}

	
	private class OneFieldOnly {

	    private final String field;

	    OneFieldOnly(String value) {
	        field = value;
	    }
	}
}
