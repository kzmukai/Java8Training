package ch01.ex07;

/**
 * static メソッド andThen を書きなさい。andThen メソッドは、2 つの Runnable イ ンスタンスをパラメータとして受け取るようにし、
 * 最初の Runnable を実行した後に 2 つ目の Runnable を実行する Runnable
 * を返すようにします。main メソッドでは、 andThen への呼び出しに 2 つのラムダ式を渡して、返されたインスタンスを実行するよ
 * うにしなさい。
 * 
 * テストなし、
 * 
 */

public class AndThen {
	
	public static Runnable andThen(Runnable pre, Runnable post) { 
		 		return () -> { 
		 			pre.run(); 
		 			post.run(); 
		 		}; 

}
	
	public static void main(String[] args) { 
		 		new Thread(andThen( 
		 				()->{System.out.println("preThread1  " );}, 
		 				()->{System.out.println("postThread2  " );} 
		 				) 
		 				).start(); 
		 	} 

	

}
