package ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 条件的なロギングを提供することで、遅延ロギング技法を強化しなさい。<br>
 * 典型的な 呼び出しは、logIf(Level.FINEST, () -> i == * 10, () -> "a[10] = " + a[10])<br>
 * となります。ロガーがメッセージをロギングしないのであれば、その条件を評価 しないようにしなさい。<br>
 */

public class LazyLogger {
	private final Logger logger;

	public LazyLogger(Logger logger) {
		if (logger == null) {
			throw new NullPointerException("logger: null");
		}
		this.logger = logger;
		//デフォルトのログレベル
	//	setLogLevel(Level.ALL);
	}

	public void setLogLevel(Level level) {
		logger.setLevel(level);
	}

	public void logIf(Level level, BooleanSupplier condition, String message) {
		if (logger.isLoggable(level)) {
			if (condition.getAsBoolean()) {
				logger.log(level, message);
			}
		}
	}
}