package ch05.ex01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * plusDayを使用しないで, プログラマーの日を計算しなさい.
 *
 * テストはコンソールの結果を目視で確認する。
 */
public class ProgrammersDay {

	public static void main(String[] args) {
		LocalDate programmersDay = LocalDate.of(2017, 1, 1).plus(255, ChronoUnit.DAYS);
		System.out.println(programmersDay);
	}

}
