package com.zhanglw.tips.algorithmic;

import java.util.Comparator;

import com.zhanglw.tips.algorithmic.sort.BubbleSort;
import com.zhanglw.tips.algorithmic.sort.Sorter;
import com.zhanglw.tips.base.TestTips;

public class AlgorithmicTest implements TestTips {

	private Sorter sorter = new BubbleSort();

	@Override
	public void test() {
		Integer[] list = { 3, 2, 1, 10, 23, 100, 2, 7, 8 };
		sorter.<Integer> sort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		Integer[] nvelist = {1,2,4,5,6,7};
//		int x = BinaySearch.binarySearch(nvelist,0,nvelist.length,2);
		int x = BinaySearch.binarySearch(nvelist, 2,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		if(x==-1){
			System.out.println("没有对应结果!");
		}else{
			System.out.println("折半查找:"+x+"对应的结果:"+nvelist[x]);
		}
	}
}
