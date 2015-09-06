package com.zhanglw.tips.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zhanglw.tips.base.TestTips;
/**
 * 
 * @author zhanglw
 * ������ʽ:
 * 	 ��������ƥ���ַ�������Ĺ���,��¼�ı�����Ĵ���
 * Java String �ṩ�ķ����� matches()��replaceAll()��replaceFirst()��split()��
 * Pattern���ʾ������ʽ����
 */
public class RegexTest implements TestTips{

	@Override
	public void test() {
		
		String str = "������(������)(������)(������)";
        Pattern p = Pattern.compile(".*?(?=\\()");//(?=\() ����  ?=exp ƥ��expǰ���λ��   .*? ����ƥ��: �������ٵ�ƥ�� 
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
	}

}
