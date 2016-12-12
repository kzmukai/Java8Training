package ch03.ex02;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * 
 * ReentrantLockを利用する場合には、次のイディオムでロックとアンロックする必要があります。
 *
 * myLock.lock(); 
 * 
 * 　　　try{
 * 　　　　　 何らかの処理 
 * 　} fainaly{
 *  　　　　　myock.unlock();
 * }
 * 
 * 次のように呼び出すことの出来るwithLockメソッドを提供しなさい。
 * 
 * withLock(myLock, () ->{何らかの処理})
 *
 */
public class LockUtill {
	
	public static void withLock(Lock lock, Runnable runner) {
		Objects.requireNonNull(lock, "lock is null.");
		Objects.requireNonNull(runner, "runner is null.");
		lock.lock();
		try {
			runner.run();
		} finally {
			lock.unlock();
		}
	}

}
