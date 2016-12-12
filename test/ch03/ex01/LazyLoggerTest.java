package ch03.ex01;

import static org.junit.Assert.*;

import java.util.logging.Logger;
import java.util.function.BooleanSupplier;
import java.util.logging.Level;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;

public class LazyLoggerTest {

	LazyLogger lazyLogger = new LazyLogger(Logger.getGlobal());
	
	
	/**
	 * 
	 * ログが出力されるため、
	 * 条件は評価される。
	 * 
	 */

	@Test
	public void testFalse() {

		lazyLogger.setLogLevel(Level.FINE);

		BooleanSupplierTest bs = new BooleanSupplierTest(true);

		lazyLogger.logIf(Level.INFO, bs, "sample");
		
		
		assertThat( bs.isEvaluated,is(true));
	}
	
	
	/**
	 * 
	 * ログが出力されないため、 条件は評価されない。
	 * 
	 */
	
	@Test
	public void testTrue() {

		lazyLogger.setLogLevel(Level.SEVERE);
		BooleanSupplierTest bs = new BooleanSupplierTest(true);
		lazyLogger.logIf(Level.INFO, bs, "sample");
		assertThat( bs.isEvaluated,is(false));
	}

	public class BooleanSupplierTest implements BooleanSupplier {

	    private boolean resultBoolean = true;
	    private  boolean isEvaluated = false;

		public boolean isEvaluated() {
			return isEvaluated;
		}

		BooleanSupplierTest(Boolean bool) {
			resultBoolean = bool;
		}

		BooleanSupplierTest() {

		}

		@Override
		public boolean getAsBoolean() {

			isEvaluated = true;

			return resultBoolean;
		}

	}

}
