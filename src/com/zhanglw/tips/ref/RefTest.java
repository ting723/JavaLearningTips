package com.zhanglw.tips.ref;

import com.zhanglw.tips.base.TestTips;

/**
 * Java �����Ĳ���ֻ֧�ֲ�����ֵ����,����ı䵱ǰ����������,���������Χ�ı������Ӱ��
 * @author zhanglw
 *
 */
public class RefTest implements TestTips {

	private void testRef(Ref test) {
		test = new Ref();
		test.setValue("NewABC");
		System.out.println(test.getValue());
	}

	@Override
	public void test() {

		Ref ref = new Ref();
		ref.setValue("ABC");
		testRef(ref);
		System.out.println(ref.getValue());
	}

	class Ref {

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
