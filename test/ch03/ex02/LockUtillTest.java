package ch03.ex02;

import static org.junit.Assert.*;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.BeforeClass;
import org.junit.Test;

public class LockUtillTest {

	
	@Test
	public void test() {
		ReentrantLock lock = new ReentrantLock(); 
		LockUtill.withLock(lock, () -> { 
		 			for (int i = 0; i < 1000; i++) { 
		 				System.out.println("i:"+i); 
		 			} 
		 		}); 

	}

}
