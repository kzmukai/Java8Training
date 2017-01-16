package ch05.ex05;
/**
  * 現在の時刻インスタントに対してサポートされるすべてのタイムゾーンにお いて、今日の日付のオフセット（UTC との差）を取得しなさい。その際、 
  * ZoneId.getAvailableIds をストリームへ変換してから、ストリーム操作を 使用することによって取得しなさい。 
  */

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoUnit;

/**
 * 今までに、あなたが生きてきた日数を表示するプログラムを書きなさい。
 */
public class SerchingBirthdays {

	public static void main(String[] args) {

		JapaneseDate birthday = JapaneseDate.of(JapaneseEra.HEISEI, 1, 7, 23);
		long n = birthday.until(LocalDate.now(), ChronoUnit.DAYS);
		System.out.printf("生きてきた日数は %1$,3d 日です", n + 1);
	}

}
