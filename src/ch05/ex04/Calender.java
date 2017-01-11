package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Write an equivalent of the Unix cal program that displays a calendar for a
 * month. For example, java Cal 3 2013 should display
 * 
 * ある月のカレンダーを表示するUnix のcal プログラムと同じプログラムを書きなさい。 たとえば、java Cal 3 2013
 * を実行すると、次のように表示します。
 * 
 * <pre>
 *  
 *              1  2  3 
 *  4  5  6  7  8  9 10 
 * 11 12 13 14 15 16 17 
 * 18 19 20 21 22 23 24 
 * 25 26 27 28 29 30 31
 * </pre>
 * 
 * indicating that March 1 is a Friday. (Show the weekend at the end of the
 * week.)
 * 
 * 3 月1 日が金曜日であることを示しています（土曜日と日曜が右端に表示されるようにし なさい）。
 * 
 * 
 */

public class Calender {
	public static void main(String[] args) {
		System.out.println("2月");
		Calender.showCal(2017, 2);
		System.out.println("\n\n3月");
		Calender.showCal(2017, 3);

	}

	public static void showCal(int year, int month) {
		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate day = yearMonth.atDay(1);
		LocalDate lastDay = yearMonth.atEndOfMonth();
		int n = day.getDayOfWeek().getValue() - 1;
		for (int i = 0; i < n; i++) {
			System.out.print("   ");
		}
		while (day.isBefore(lastDay) || day.isEqual(lastDay)) {
			System.out.printf("%2d", day.getDayOfMonth());
			if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
			day = day.plusDays(1);
		}
	}
}
