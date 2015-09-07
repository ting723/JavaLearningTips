package com.zhanglw.tips.algorithmic;

import com.zhanglw.tips.algorithmic.sort.BubbleSort;
import com.zhanglw.tips.algorithmic.sort.Sorter;
import com.zhanglw.tips.base.TestTips;

public class AlgorithmicTest implements TestTips {

	private Sorter sorter = new BubbleSort();
	@Override
	public void test() {
		Integer[] list = {3,2,1,10,23,100,2,7,8};
		sorter.<Integer>sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}

}
