package com.zhanglw.tips.datetime;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.zhanglw.tips.base.TestTips;

public class DateTimeTest implements TestTips{

	
	@Override
	public void test() {
		//获取时间与显示
		Calendar cal = Calendar.getInstance();	
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));//0-11
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		//Java 8
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt.getYear());
		System.out.println(dt.getMonth());
		System.out.println(dt.getMonthValue());
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getHour());
		System.out.println(dt.getMinute());
		System.out.println(dt.getSecond());
		
		//获得毫秒的方法
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		//Java 8 新方法
		System.out.println(Clock.systemDefaultZone().millis());
		
		//日期转换
		System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(cal.getTime()));
		//Java 8 新方法
		DateTimeFormatter famter= DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.now();
		System.out.println(date.format(famter));
		
		//打印前一天的时间
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
        
        //采用Java8实现打印前一天的时间
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yestoday = today.minusDays(1);
        System.out.println(yestoday.toLocalDate());
	}

}
