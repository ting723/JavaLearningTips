package com.zhanglw.tips.algorithmic.sort;

import java.util.Comparator;

public class BubbleSort implements Sorter {

	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		boolean swap = true;
		for (int i = 0; swap&&i < list.length; i++) {
			for (int j = 1; j < list.length-i; j++) {
				swap = false;
				if (list[j].compareTo(list[j-1]) < 0) {
					T temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
					swap = true;
				}
			}
		}
	}

	@Override
	public <T> void sort(T[] list, Comparator<T> comp) {
		//若已正确排序就不再执行
		boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            //每次必然将最大的排到最后
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
	}

}
