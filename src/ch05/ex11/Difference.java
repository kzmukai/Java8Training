package ch05.ex11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 帰りの便は, フランクフルトを14時5分に出発し, ロサンジェルスに16時40分に到着します.
 * 飛行時間は何時間何分ですか.このような計算をできるプログラムを書きなさい.
 */

public class Difference {

	public static void main(String[] args) {
		ZoneId startZone = ZoneId.of("CET");
		ZoneId endZone = ZoneId.of("America/Los_Angeles");
		LocalDateTime startTime = LocalDateTime.of(2015, 9, 1, 14, 5);
		LocalDateTime endTime = LocalDateTime.of(2015, 9, 1, 16, 40);
		long travelSecondTime = new Difference().calcTravelTime(startZone, endZone, startTime, endTime).getSeconds();
		int hour = (int) travelSecondTime / 3600;
		int minute = (int) ((travelSecondTime - hour * 3600) / 60);
		System.out.println(hour + "時間" + minute + "分");
	}

	Duration calcTravelTime(ZoneId startZone, ZoneId endZone, LocalDateTime startTime, LocalDateTime endTime) {
		return Duration.between(ZonedDateTime.of(startTime, startZone), ZonedDateTime.of(endTime, endZone));
	}
}
