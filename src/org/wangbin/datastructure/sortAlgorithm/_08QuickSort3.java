package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

/**
 * 快速排序 优化小数组排序
 * 
 * @author wb
 * @version 2015-7-7 下午10:33:42
 */
public class _08QuickSort3 {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		quikSort(aa, 0, aa.length - 1);
//		inserSort(aa,0, aa.length);
//		 System.out.println(Arrays.toString(aa));

	}
	/**
	 * 优化小数组时的排序
	 * @param aa
	 * @param i
	 * @param j
	 */
	private static void quikSort(int[] aa, int i, int j) {
		// TODO Auto-generated method stub
		if (i < j) {
			if(j-i>7){
				int point = Partition(aa, i, j);// 每次都取新的哨兵
				quikSort(aa, i, point - 1);
				quikSort(aa, point + 1, j);
			}else{
				inserSort(aa, i, j+1);
			}
			System.out.println(Arrays.toString(aa));
		}
	}

	public static void inserSort(int aa[],int low,int high){
		int j =0;
		for(int i = low+1;i <high;i++){
			if(aa[i]<aa[i-1]){
				int temp =aa[i];
				for( j = i-1;j >=0&&aa[j] >temp;j--){
					aa[j+1]=aa[j];
				}
				aa[j+1]=temp;
			}
		}
	}
	/**
	 * 优化基准点，选取3个，取中间值
	 * 
	 * @param aa
	 * @param low
	 * @param high
	 * @return
	 */
	private static int Partition(int[] aa, int low, int high) {
		// TODO Auto-generated method stub
		int mid = low + (high - low) / 2;
		if (aa[low] > aa[high]) {
			swap(aa, low, high);
		}
		if (aa[mid] > aa[high]) {
			swap(aa, mid, high);
		}
		if (aa[mid] > aa[low]) {
			swap(aa, mid, low);
		}
		int point = aa[low];// 取3个点的中间值
		while (low < high) {
			while (low < high && aa[high] >= point) {
				high--;// 一开始比哨兵大的 不管
			}
			swap(aa, low, high);// 右边应该比哨兵大的地方，小了，那么就作交换
			while (low < high && aa[low] <= point) {
				low++;// 一开始比哨兵小的 不管
			}
			swap(aa, low, high);// 左边应该比哨兵小的地方，大了，那么就作交换
		}
		return low;
	}

	private static void swap(int[] aa, int low, int high) {
		// TODO Auto-generated method stub
		int temp = aa[low];
		aa[low] = aa[high];
		aa[high] = temp;
	}
}
