package ch05.ex08;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


/**
 * 再度、ストリーム操作を使用して、オフセットに1 時間未満の情報が含まれるすべてのタ イムゾーンを見つけなさい。 
 */ 


public class WordPerforman {
	 public static void main(String[] args) { 
		 
		 LocalDateTime now = LocalDateTime.now();
		 ZonedDateTime utcNow = ZonedDateTime.of(now, Clock.systemUTC().getZone());
		 ZoneId.getAvailableZoneIds().stream()
		     .map(ZoneId::of)                                                     
		     .map(zone -> ZonedDateTime.of(now, zone))                            
		     .filter(time -> Duration.between(time, utcNow).toMinutes() % 60 != 0) 		     
		     .map(ZonedDateTime::getZone)                                          
		     .forEach(System.out::println);
		      } 
}
