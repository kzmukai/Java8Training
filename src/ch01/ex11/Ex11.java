package ch01.ex11;
/**
 * 
 * void f() メソッドを持つ、I とJ の2 つのインタフェースがあり、両方を実装してい るクラスがあるとします。I インタフェースのf 
 * メソッドが抽象、デフォルト、static の どれかであり、J インタフェースのf メソッドが抽象、デフォルト、static のどれかであ 
 * る場合、すべての組み合わせで何が起きるでしょうか。同じように、スーパークラスS を 拡張し、I 
 * インタフェースを実装した場合に、スーパークラスもインタフェースもvoid f() メソッドを持っていたら、どうなるかを調べなさい。 
 *
 *
 *テストなし
 */
	
	public class Ex11 implements I, J {
	        @Override
	        public void f() {
	            J.super.f();  
	        }
	    }

	    interface I {
	        void f();
	    }

	    interface J {
	        default void f() {

	        };
	    }

