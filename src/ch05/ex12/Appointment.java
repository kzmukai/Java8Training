package ch05.ex12;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ページの5.5 節「ゾーン付き時刻」の初めで説明した問題を解くプログラムを書きな
 * さい。そのプログラムでは、異なるタイムゾーンにある約束の集まりを読み込んで、ロー カル時刻で1 時間前に約束があることをユーザーに通知するようにしなさい。
 */

public class Appointment {
	public final String title;
	public final ZonedDateTime time;

	public Appointment(String title, ZonedDateTime time) {
		this.title = title;
		this.time = time;
	}

	public static void main(String[] args) throws InterruptedException {
		Set<Appointment> appointments = new TreeSet<Appointment>((a, b) -> a.time.compareTo(b.time));
		
		appointments.add(new Appointment("電話会議", ZonedDateTime.now()));
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(() -> {
			Optional<Appointment> firstAppo = appointments.stream().findFirst();
			if (!firstAppo.isPresent())
				return;
			Appointment appo = firstAppo.get();
			if (appo.time.isAfter(ZonedDateTime.now().plusHours(1)))
				return;
			System.out.println(appo.title + ": " + appo.time); // 通知
			appointments.remove(appo);
		}, 0, 30, TimeUnit.SECONDS);
		service.awaitTermination(1, TimeUnit.DAYS);
	}
		
	
}