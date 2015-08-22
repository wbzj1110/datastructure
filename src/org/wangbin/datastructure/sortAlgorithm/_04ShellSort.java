package org.wangbin.datastructure.sortAlgorithm;

import java.util.Arrays;

public class _04ShellSort {
	public static void main(String[] args) {
		int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
		shellSort2(aa);
		System.out.println(Arrays.toString(aa));
	}
	public static void shellSort(int []a){
		int gap = a.length;//间隔数
		int j=0;
		do{
			gap = gap/3+1;
			for(int i =gap,len = a.length;i <len;i++){
				if(a[i] < a[i-gap]){
					int temp = a[i];
					for( j = i-gap;j>=0&&a[j]>temp;j-=gap){
						a[gap+j] = a[j];
					}
					a[j+gap]=temp;
				}
			}
			
		}while(gap>1);
		System.out.println(Arrays.toString(a) );
		
	}
	
	public static void shellSort2(int []aa){
		
		
		int j = 0;
		int gap = aa.length;
		do {
			gap = gap/3+1;
			for(int i = gap,len = aa.length;i <len;i++){
				if(aa[i] <aa[i-gap]){
					int temp = aa[i];
					for( j = i-gap;j>=0&&aa[j] > temp;j-=gap){
						aa[j+gap] = aa[j];
					}
					aa[j+gap] = temp;	
				}
			}
			
		} while (gap >1);
		
		
		
		
		
		
	}
	
	
}
