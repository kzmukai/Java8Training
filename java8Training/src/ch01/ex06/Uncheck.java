package ch01.ex06;

/**
 * 練習問題06
 * 
 * Runnable 内でチェックされる例外を処理しなければならないことが、いつも面倒だと
 * 思っていませんか。チェックされるすべての例外をキャッチし、それをチェックされない 例外へ変える uncheck
 * メソッドを書きなさい。たとえば、次のように使用します。
  * <blockquote><pre>
 * new Thread(uncheck(() -> 
 *    { System.out.println("Zzz"); Thread.sleep(1000); })).
 *    start();
 *       // catch (InterruptedException)が必要ありません!
 * </pre></blockquote>
 *
 */
public class Uncheck {
	
	
	public interface RunnableWithException {
	    public void run() throws Exception;
	}
	
	
	public static Runnable uncheck(RunnableWithException func) {
	    return () -> {
	        try {
	            func.run();
	        } catch (Exception ex) {
	            throw new RuntimeException(ex);
	        }
	    };
	}
	
}
