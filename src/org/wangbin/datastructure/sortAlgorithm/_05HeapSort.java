package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

public class _05HeapSort {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		aa = new int[] { 1,2,7,3,5,9,8,6,4 };
		int[] bb = new int[aa.length + 1];
		bb[0] = aa.length;
		System.arraycopy(aa, 0, bb, 1, aa.length);
		heapSort(bb);
		String str = "123";
		System.out.println(str.replaceAll(" ", ""));
		System.out.println();
	}

	private static void heapSort(int[] aa) {
		// TODO Auto-generated method stub
		int n = aa[0];//n=aa.length-1是一样的
		// 先变为堆排序
		for (int i = n / 2; i > 0; i--) {// 1<=i<=n/2的下限
			System.out.println(i);
			heapAdjust(aa, i, n);
		}
		System.out.println("第一次构建完大顶堆 : " + Arrays.toString(aa));
		for (int i = n; i > 1; i--) {
			swap(aa, 1, i);
			heapAdjust(aa, 1, i - 1);
		}
		System.out.println(Arrays.toString(aa));
	}

	private static void swap(int[] aa, int i, int j) {
		// TODO Auto-generated method stub
		int temp = aa[i];
		aa[i] = aa[j];
		aa[j] = temp;
	}

	private static void heapAdjust(int[] aa, int s, int length) {
		// TODO Auto-generated method stub
		int temp = aa[s];
		for (int i = 2 * s; i <= length; i *= 2) {// 左右子树比较值
			if(i<length){
				System.out.println(aa[i] + "     "+ aa[i+1]);
			}
			if (i < length && aa[i] < aa[i + 1]) {
				i++;// 指向值较大的右子树
			}
			if (temp > aa[i]) {
				break;// 就放在这个位置！！
			}
			aa[s] = aa[i];
			s = i;
		}
		aa[s] = temp;
		System.out.println("调整大顶堆的节奏 : " + Arrays.toString(aa));
		
	}

}
