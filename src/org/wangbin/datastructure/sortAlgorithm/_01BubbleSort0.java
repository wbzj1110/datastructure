package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

/**
 * 冒泡
 * 
 * @author wb
 * @version 2015-7-2 下午2:21:46
 */
public class _01BubbleSort0 {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
//		bubbleSort1(aa);
//		aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
//		bubbleSort2(aa);
//		aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
//		bubbleSort3(aa);
		aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		bubbleSort4(aa);
		aa = new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };
//		bubbleSort1(aa);
//		aa = new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };
//		bubbleSort2(aa);
//		aa = new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };
//		bubbleSort3(aa);
		aa = new int[] { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };
		bubbleSort4(aa);
	}

	public static void bubbleSort1(int[] aa) {
		int count1 = 0;
		int count2 = 0;
		for (int i = 0, len = aa.length; i < len; i++) {
			for (int j = len - 1; j > i; j--) {
				int m = aa[i];
				int n = aa[j];
				count1++;
				if (aa[j - 1] > aa[j]) {
					count2++;
					int temp = aa[j - 1];
					aa[j - 1] = aa[j];
					aa[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(aa) + "  比较次数" + count1 + "   移动次数"
				+ count2);
	}

	// 但是对这种情况比较次数还是很多 0 ， 1,2,3,4,5，。。。。so改进算法
	public static void bubbleSort2(int[] aa) {
		int count1 = 0;
		int count2 = 0;
		boolean falg = true;
		for (int i = 0, len = aa.length; i < len && falg; i++) {
			falg = false;
			for (int j = len - 1; j > i; j--) {
				int m = aa[i];
				int n = aa[j];
				count1++;
				if (aa[j - 1] > aa[j]) {
					falg = true;
					count2++;
					int temp = aa[j - 1];
					aa[j - 1] = aa[j];
					aa[j] = temp;
				}
			}
		}
		System.out.println("改进后" + Arrays.toString(aa) + "  比较次数" + count1
				+ "   移动次数" + count2);
	}

	/**
	 * 在第一步优化的基础上发进一步思考：如果R[0..i]已是有序区间，上次的扫描区间是R[i..n]，记上次扫描时最后
	 * 一次执行交换的位置为lastSwapPos
	 * ，则lastSwapPos在i与n之间，不难发现R[i..lastSwapPos]区间也是有序的，否则这个区间也会发生交换
	 * ；所以下次扫描区间就可以由R[i..n] 缩减到[lastSwapPos..n]。
	 */
	public static void bubbleSort3(int[] aa) {
		int count1 = 0;
		int count2 = 0;
		boolean falg = true;
		int lastSwapPos = 0, lastSwapPosTemp = 0;
		for (int i = 0, len = aa.length; i < len && falg; i++) {
			falg = false;
			lastSwapPos = lastSwapPosTemp;
			for (int j = len - 1; j > lastSwapPos; j--) {
				int m = aa[i];
				int n = aa[j];
				count1++;
				if (aa[j - 1] > aa[j]) {
					falg = true;
					count2++;
					int temp = aa[j - 1];
					aa[j - 1] = aa[j];
					aa[j] = temp;
					lastSwapPosTemp = j - 1;
				}
			}
			if(lastSwapPos == lastSwapPosTemp){
				break;
			}
		}
		System.out.println("改进后2" + Arrays.toString(aa) + "  比较次数" + count1
				+ "   移动次数" + count2);
	}

	/**
	 * 双向冒泡排序算法的运作如下： 传统冒泡气泡排序的双向进行，先让气泡排序由左向右进行，再来让气泡排序由右往左进行，如此完成一次排序的动作
	 * 使用left与right两个旗标来记录左右两端已排序的元素位置。
	 * 
	 * @param aa
	 */
	public static void bubbleSort4(int[] a) {
		int left = 0;
		int right = a.length - 1;
		int index =0;
		int i =0;
		int count1 =0;
		int count2=0;
		while (left < right) {
			for (int j = left; j < right; j++) {
				count1++;
				if (a[j] > a[j + 1]) {
					count2++;
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
					index = j;
				}
			}
			right = index;
			for (int j = right; j > left; j--) {
				count1++;
				if (a[j] < a[j - 1]) {
					count2++;
					int t = a[j];
					a[j] = a[j - 1];
					a[j - 1] = t;
					index = j;
				}
			}
			left = index;
			System.out.print("第" + ++i+"趟:" );
			System.out.println(Arrays.toString(a));
			
		}
		System.out.println("双向冒泡" + Arrays.toString(a)+ "  比较次数" + count1
				+ "   移动次数" + count2);
	}

}
