package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;
/**
 * 不是纯种的冒泡 因为不是22相邻元素比较
 * @author wb
 * @version 2015-7-2 下午2:20:48
 */
public class _01BubbleSort {
	public static void main(String[] args) {
		int []aa = new int[]{5,3,9,10,7,4,2,1,6,8};
		bubbleSort1(aa);
		aa= new int[]{5,3,9,10,7,4,2,1,6,8};
		bubbleSort2(aa);
		aa = new int[]{2,1,3,4,5,6,7,8,9,10};
		bubbleSort1(aa);
		aa= new int[]{2,1,3,4,5,6,7,8,9,10};
		bubbleSort2(aa);
	}
	public static void bubbleSort1(int []aa){
		int count1 =0;
		int count2 = 0;
		for(int i =0,len=aa.length;i<len;i++){
			for(int j = i+1; j < len ;j++){
				int m = aa[i];int n = aa[j];
				count1++;
				if(aa[i] > aa[j]){
					count2++;
					int temp = aa[j];
					aa[j] = aa[i];
					aa[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(aa) + "  比较次数" +count1 + "   移动次数"+count2) ;
	}
	//但是对这种情况比较次数还是很多  0 ， 1,2,3,4,5，。。。。so改进算法
	public static void bubbleSort2(int []aa){
		int count1 =0;
		int count2 = 0;
		boolean falg= true;
		for(int i =0,len=aa.length;i<len&&falg;i++){
			falg=false;
			for(int j = i+1; j < len ;j++){
				int m = aa[i];int n = aa[j];
				count1++;
				if(aa[i] > aa[j]){
					falg= true;
					count2++;
					int temp = aa[j];
					aa[j] = aa[i];
					aa[i] = temp;
				}
			}
		}
		System.out.println("改进后" +Arrays.toString(aa) + "  比较次数" +count1 + "   移动次数"+count2) ;
	}
}
