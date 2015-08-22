package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

public class _02SelectionSort {
	public static void main(String[] args) {
		int []aa = new int[]{5,3,9,10,7,4,2,1,6,8};
		selectionSort(aa);
		aa= new int[]{2,1,3,4,5,6,7,8,9,10};
		selectionSort(aa);
	}
	public static void selectionSort(int []aa){
		int count1=0;
		int count2 = 0;
		for(int i =0,len=aa.length;i<len;i++){
			int min = i;
			for(int j = i+1; j < len ;j++){
				count1++;
				int m = aa[i];int n = aa[j];
				if(aa[min] > aa[j]){
					min= j ;
				}
			}
			if(min!=i){
				count2++;
				int temp = aa[min];
				aa[min]= aa[i];
				aa[i] = temp;
			}
		}
		System.out.println(Arrays.toString(aa)+ "  比较次数" +count1 + "   移动次数"+count2) ;
	
		
		
		
		
	}
}
	