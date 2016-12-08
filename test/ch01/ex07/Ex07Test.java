package ch01.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex07Test {

	@Test
	public void andThentest() {

		  Runnable first = () -> { System.out.println("preThread1  " ); };
	        Runnable second = () -> { System.out.println("preThread2  " ); };
	
	        new Thread(AndThen.andThen( first,second)).start();
	        
	}

}
