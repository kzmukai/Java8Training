package ch05.ex07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 
 * （指定された日付の午前10 時から午前11 時といった）カレンダーイベントに適した、時 刻のインターバルを表すTimeInterval 
 * クラスを実装しなさい。2 つのインターバルが 重なっているかを検査するメソッドを提供しなさい。 
 */ 
public class Interval {
	
//	public static void main(String[] args) {
//		Interval in = new Interval(LocalDate.now() ,LocalTime.now(),LocalTime.now());
//	System.out.println(in.isOverlap(in));
//	}
    /** 開始 */
    public  LocalDateTime from;
    /** 終了 */
    public LocalDateTime to;

    public  Interval(LocalDate date, LocalTime from, LocalTime to) {
        this(date.atTime(from), date.atTime(to));
    }

    public Interval(LocalDateTime atTime, LocalDateTime atTime2) {
    	
        if (from.isAfter(to)) {
            throw new IllegalArgumentException();
        }
        this.from = from;
        this.to = to;
    }
    
    public boolean isOverlap(Interval other) {
        LocalDateTime start = from.isAfter(other.from) ? from : other.from;
        LocalDateTime end   = to  .isBefore(other.to)  ? to   : other.to;
        return start.isBefore(end);
    }
}