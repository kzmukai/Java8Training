package ch01.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class UncheckTest {

	@Test
	public void UncheckedRunnableNoThrowExceptuinTest() {
		new Thread(Uncheck.uncheck( () -> { System.out.println("Sample"); Thread.sleep(1000);} )).start();
	}

}
