package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

/**
 * 直接插入排序
 * 
 * @author wb
 * @version 2015-7-2 下午5:03:17
 */
public class _03InsertSort {
	public static void main(String[] args) {
	    int []aa = new int[]{5,3,9,10,7,4,2,1,6,8};
	    insertSort(aa);
        aa= new int[]{2,1,3,4,5,6,7,8,9,10};
        insertSort(aa);
	}

	public static void insertSort(int[] a) {
		int j, count1, count2;
		count2 = count1 = 0;
		for (int i = 1, len = a.length; i < len; i++) {
			count1++;
			if (a[i] < a[i - 1]) {
				int temp = a[i];
				for (j = i - 1; j>=0&&a[j] > temp; j--) {
					count1++;
					count2++;
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;

			}
		}
		System.out.println(Arrays.toString(a) + "  比较次数" + count1 + "   移动次数"
				+ count2);
	}

}
