package ch03.ex07;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

public class ComparatorMakerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	
	 @Test
	    public void testNoReserve() {
		  Comparator<String> cmp = ComparatorMaker.comparator(true, true, true);
		 
		  assertThat(cmp.compare("a","b"),is(1));
		  assertThat(cmp.compare("b","b"),is(0));
		  assertThat(cmp.compare("b","a"),is(-1));
		 
	    }
	 
	 @Test
	  public void testReversed() {
		  Comparator<String> cmp = ComparatorMaker.comparator(false, true, true);
		 
		  assertThat(cmp.compare("a","b"),is(-1));
		  assertThat(cmp.compare("b","b"),is(0));
		  assertThat(cmp.compare("b","a"),is(1));
		 
	    }

	 @Test
	  public void testUppserCase() {
		  Comparator<String> cmp = ComparatorMaker.comparator(true, false, true);
		
		 assertTrue(cmp.compare("A","b")>0);
		 assertTrue(cmp.compare("b","B")<0);
		 assertTrue(cmp.compare("B","B")==0);
		 
	    }
	 
	 @Test
	  public void testSpace() {
		  Comparator<String> cmp = ComparatorMaker.comparator(true, false, true);
		 assertTrue(cmp.compare("AA","A A")==0);
		 
	    }
	 @Test
	  public void testNoSpace() {
		  Comparator<String> cmp = ComparatorMaker.comparator(true, false, false);
		  
		 assertTrue(cmp.compare("AA","A A")!=0);
		 
	    }
}
