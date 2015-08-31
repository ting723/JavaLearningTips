package com.zhanglw.tips.threefinal;

import com.zhanglw.tips.base.TestTips;

public class FinalThreeTest implements TestTips{

	private final String text;

	private String xx = null;
	public FinalThreeTest() {
		try {
			xx="finalize";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			text = "";
		}
	}

	@Override
	public void test() {
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(null==xx);
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		xx=null;
	}
	
	
	

}

	
