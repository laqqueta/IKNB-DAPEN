package id.go.ojk.lib.client;

import java.time.Duration;
import java.time.Instant;

public class TimeCounter {

	private Instant start;
	public TimeCounter(){
		start = Instant.now();
	}

	public long getTimeElapse(){
		return Duration.between(start, Instant.now()).toMillis();
	}

	public String getTimeElapseFormated(long addMiliSecond){
		return format(addMiliSecond + getTimeElapse());
	}

	public String getTimeElapseFormated(){
		return format(getTimeElapse());
	}

	public String format(long miliSecond){
		int hour = 0;
		int minute = 0;
		int second = 0;
		int ms = 0;
						
		second = (int)(miliSecond/1000);
		ms = (int)(miliSecond % 1000);
//		if ( miliSecond % 1000 > 0 )
//			second += 1;
		
		
		if( second > 60 ){
			minute = second/60;
			second = second % 60;
		}
		
		if ( minute > 60 ){
			hour = minute / 60;
			minute = minute % 60;
		}
		
		StringBuilder builder = new StringBuilder();
		if ( hour > 0 )
			builder.append(hour).append(" jam ");

		if ( hour > 0 || minute > 0)
			builder.append(minute).append(" menit ");

		builder.append(second).append(" detik ");
		builder.append(ms).append(" ms");

		return builder.toString();
	}
}
