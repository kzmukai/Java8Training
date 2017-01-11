package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

/**
* Predicate<LocalDate>を受け取り、TemporalAdjuster を返すnext メソッド 
* を実装しなさい。返されたTemporalAdjuster は、next メソッドに渡された述語を 
* 満足する翌日の日付を生成します。たとえば、次のコードを見てください。 
*
* today.with(next(w -> getDayOfWeek().getValue() < 6))  
 このコードは、今日より後にあって平日となる最初の日付を返します。 
*/ 

public class GettingTemp {

	public static void main (String arges[]){
		LocalDate today = LocalDate.now();
		LocalDate weekday = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
		System.out.println(weekday);
		
	}
	
	public static TemporalAdjuster next(Predicate<LocalDate> pred) {
	    return t -> {
	        LocalDate w = (LocalDate)t;
	        do {
	            w = w.plusDays(1);
	        } while (!pred.test(w));
	        return w;
	    };
	}
}
