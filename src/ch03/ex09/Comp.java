package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * 
  * 指定された順序で、指定されたフィールドを比較するコンパレータを生成する lexicographicComparator(String... 
  * fieldNames) メソッドを書きなさい。 たとえば、lexicographicComparator("lastname", "firstname") 
  * は、2 つ のオブジェクトを受け取り、リフレクションを使用して、lastname フィールドの値を 取得します。2 つのオブジェクトのlastname 
  * フィールドが異なれば、その差を返しま す。同じであれば、firstname フィールドに移ります。すべてのフィールドが同じであ れば、0 を返します。 
  */ 


public class Comp {
	
	private static Object getFieldValue(Object target, String fieldName) {
	    for (Class<?> clazz = target.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
	        Field field;
	        try {
	            field = clazz.getDeclaredField(fieldName);
	            field.setAccessible(true);
	            return field.get(target);
	        } catch (IllegalAccessException ex) {
	            throw new RuntimeException(ex);
	        } catch (NoSuchFieldException ex) {
	        }
	    }
	    throw new RuntimeException();
	}

	
	public static Comparator<?> lexicographicComparator(String... fieldNames) {
	    return (t, u) -> {
	        for (String fieldName : fieldNames) {
	            Object tf = getFieldValue(t, fieldName);
	            Object uf = getFieldValue(u, fieldName);
	            if (tf.equals(uf)) {
	                continue;
	            }
	            return ((Comparable)tf).compareTo(uf);
	        }
	        return 0;
	    };
	}
}
