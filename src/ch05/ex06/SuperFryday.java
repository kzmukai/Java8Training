package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

/**
 * 世紀のすべての13 日の金曜日を列挙しなさい。
 */

public class SuperFryday {

	public static void main(String[] args) {
		YearMonth month = YearMonth.of(1901, Month.JANUARY);
		YearMonth lastMonth = YearMonth.of(2000, Month.DECEMBER);
		while (month.isBefore(lastMonth) || month.equals(lastMonth)) {
			LocalDate day = month.atDay(13);
			if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
				System.out.println(day);
			}
			month = month.plusMonths(1);
		}
	}
}