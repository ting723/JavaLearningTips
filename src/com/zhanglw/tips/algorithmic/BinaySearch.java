package com.zhanglw.tips.algorithmic;

import java.util.Comparator;

import com.zhanglw.tips.base.TestTips;

public class BinaySearch implements TestTips {

	@Override
	public void test() {

	}

	 // 使用循环实现的二分查找
	   public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
	      int low = 0;
	      int high = x.length - 1;
	      while (low <= high) {
	          int mid = (low + high) >>> 1;
	          int cmp = comp.compare(x[mid], key);
	          if (cmp < 0) {
	            low= mid + 1;
	          }
	          else if (cmp > 0) {
	            high= mid - 1;
	          }
	          else {
	            return mid;
	          }
	      }
	      return -1;
	   }

	   // 使用递归实现的二分查找
	   public static<T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
	      if(low <= high) {
	        int mid = low + ((high -low) >> 1);
	        if(key.compareTo(x[mid])== 0) {
	           return mid;
	        }
	        else if(key.compareTo(x[mid])< 0) {
	           return binarySearch(x,low, mid - 1, key);
	        }
	        else {
	           return binarySearch(x,mid + 1, high, key);
	        }
	      }
	      return -1;
	   }

}
