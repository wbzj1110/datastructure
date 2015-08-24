package org.wangbin.datastructure.sortAlgorithm.test01;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 选择排序重复 
 * @author wb
 * @date 2015-8-23 下午2:23:29
 */
public class _02SelectionSort {
    public static void main(String[] args) {
        int []aa = new int[]{5,3,9,10,7,4,2,1,6,8};
        selectionSort(aa);
        aa= new int[]{2,1,3,4,5,6,7,8,9,10};
        selectionSort(aa);
    }
    public static void selectionSort(int []aa){
        int count1 = 0;
        int count2 = 0;
        int min = 0;
        for(int i = 0;i <aa.length;i++){
            min = i;
            for(int j = min;j <aa.length;j++){
                count1++;
                if(aa[min] >aa[j]){
                    min = j;
                }
            }
            if(min !=i){
                count2++;
                swap(aa, min, i);
            }
        }
        System.out.println(Arrays.toString(aa)+ "  比较次数" +count1 + "   移动次数"+count2) ;
    }
    private static void swap(int[] aa, int i, int j) {
        // TODO Auto-generated method stub
        int temp = aa[i];
        aa[i] = aa[j];
        aa[j] = temp;
    }
}
