package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

/**
 * 快速排序 无优化
 * @author wb
 * @version 2015-7-7 下午10:33:42
 */
public class _08QuickSort {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		quikSort(aa,0,aa.length-1);
//		System.out.println(Arrays.toString(aa));
		
	}

	private static void quikSort(int[] aa, int i, int j) {
		// TODO Auto-generated method stub
		if(i < j){
			int point = Partition(aa,i,j);//每次都取新的哨兵
			quikSort(aa, i, point-1);
			quikSort(aa, point+1, j);
			System.out.println(Arrays.toString(aa));
		}
	}

	private static int Partition(int[] aa, int low, int high) {
		// TODO Auto-generated method stub
		int point = aa[low];//默认取一开始的位置的点为哨兵
		while(low < high){
			while(low <high && aa[high]>=point){
				high--;//一开始比哨兵大的 不管 
			}
			swap(aa,low,high);//右边应该比哨兵大的地方，小了，那么就作交换
			while(low <high && aa[low]<=point){
				low++;//一开始比哨兵小的 不管 
			}
			swap(aa,low,high);//左边应该比哨兵小的地方，大了，那么就作交换
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
