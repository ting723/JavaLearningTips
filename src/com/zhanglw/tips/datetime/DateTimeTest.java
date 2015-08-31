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
		//��ȡʱ������ʾ
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
		
		//��ú���ķ���
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		//Java 8 �·���
		System.out.println(Clock.systemDefaultZone().millis());
		
		//����ת��
		System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(cal.getTime()));
		//Java 8 �·���
		DateTimeFormatter famter= DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.now();
		System.out.println(date.format(famter));
		
		//��ӡǰһ���ʱ��
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
        
        //����Java8ʵ�ִ�ӡǰһ���ʱ��
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yestoday = today.minusDays(1);
        System.out.println(yestoday.toLocalDate());
	}

}
