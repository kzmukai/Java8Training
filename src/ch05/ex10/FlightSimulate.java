package ch05.ex10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * ロサンジェルスからフランクフルト行きの便は、ローカル時刻の3 時5 分に出発し、10 時間50
 * 分の飛行です。何時に到着しますか。このような計算を処理できるプログラムを 書きなさい。
 */

public class FlightSimulate {
	public static void main(String[] args) {
		ZoneId los = ZoneId.of("UTC-8");
		ZoneId frank = ZoneId.of("UTC+1");
		LocalDateTime departureTime = LocalDateTime.of(2017, 1, 10, 3, 5);
		Duration travelTime = Duration.ofMinutes(10 * 60 + 50);

		System.out.println(getArrivalTime(frank, los, departureTime, travelTime));
	}

	public static LocalDateTime getArrivalTime(ZoneId arrivalZone, ZoneId departureZone, LocalDateTime timeOfDeparture,
			Duration travelTime) {
		return LocalDateTime.ofInstant(ZonedDateTime.of(timeOfDeparture, departureZone).plus(travelTime).toInstant(),
				arrivalZone);
	}
}
