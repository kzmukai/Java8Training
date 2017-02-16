package ch08.ex07;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.Test;

public class Ex07Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		String[] array = { "abc", null, "xyz", null, "ab", "123" };
		String[] expectedResultArray = { "xyz", "abc", "ab", "123", null, null };
	
		  Arrays.sort(array, Ex07.reversedNullsLast());
		  for (int i = 0; i < array.length; i++) { 
			 			assertThat(array[i], is(expectedResultArray[i])); 
			  		} 
	}

}
