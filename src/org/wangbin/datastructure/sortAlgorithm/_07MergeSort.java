package org.wangbin.datastructure.sortAlgorithm;

import java.net.URLEncoder;
import java.util.Arrays;

public class _07MergeSort {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		mergeSort(aa);
//		System.out.println(Arrays.toString(aa));
		
		System.out.println(URLEncoder.encode("{mobile:true}"));
	}

	/**
	 * 归并 迭代实现方式
	 * 
	 * @param aa
	 */
	private static void mergeSort(int[] aa) {
		// TODO Auto-generated method stub
		sort(aa, 0, aa.length - 1);
	}

	private static void sort(int[] aa, int left, int right) {
		// TODO Auto-generated method stub
		int mid = (left + right) / 2;
		if (left < right) {
			// 排序左部分数组
			sort(aa, left, mid);
			// 排序右部分数组
			sort(aa, mid + 1, right);
			// 左右归并了
			mergeing(aa, left, mid, right);
			System.out.println(Arrays.toString(aa));
		}
	}

	private static void mergeing(int[] data, int left, int center, int right) {
		// 临时数组
		int[] tmpArr = new int[data.length];
		// 右数组第一个元素索引
		int mid = center + 1;
		// third 记录临时数组的索引
		int third = left;
		// 缓存左数组第一个元素的索引
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入临时数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将临时数组中的内容拷贝回原数组中
		// （原left-right范围的内容被复制回原数组）
		System.arraycopy(tmpArr, tmp, data, tmp, right-tmp+1);
//		while (tmp <= right) {
//			data[tmp] = tmpArr[tmp++];
//		}
	}

	private static void mergeing2(int[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		int[] temp = new int[data.length];
		int mid = center + 1;
		int tempIndex = left;// 最后排序号的数组还原回去的时候的位置
		int tempP = left;// 临时数组的指标
		System.out.println(left <= center);
		System.out.println(mid <= right);
		while (left <= center && mid <= right) {
			if (data[left] < data[mid]) {
				temp[tempP++] = data[left++];
			} else {
				temp[tempP++] = data[mid++];
			}
		}
		while (left <= center) {
			temp[tempP++] = data[left++];
		}
		while (mid <= right) {
			temp[tempP++] = data[mid++];
		}
		// 临时数组的值返还 ，返还left-right部分
		while (tempIndex <= right) {
			data[tempIndex] = temp[tempIndex];
			tempIndex++;
		}
	}
}
