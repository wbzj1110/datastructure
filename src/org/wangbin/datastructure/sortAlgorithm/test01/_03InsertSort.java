package org.wangbin.datastructure.sortAlgorithm.test01;

import java.util.Arrays;

/**
 * 直插排序重复练习
 * 
 * @author wb
 * @date 2015-8-23 下午2:28:01
 */
public class _03InsertSort {
    public static void main(String[] args) {
        int[] aa = new int[] {5, 3, 9, 10, 7, 4, 2, 1, 6, 8};
        insertSort(aa);
        aa = new int[] {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        insertSort(aa);
    }

    public static void insertSort(int[] aa) {
        int j, count1, count2;
        count1 = count2 = 0;
        for (int i = 1; i < aa.length; i++) {
            if (aa[i] < aa[i - 1]) {
                // 选出比i-1~n里边最小滴~
                int temp = aa[i];
                for (j = i - 1; j >= 0 && aa[j] > temp; j--) {
                    count1++;
                    count2++;
                    aa[j + 1] = aa[j];
                }
                aa[j + 1] = temp;
            }

        }
        System.out.println(Arrays.toString(aa) + "  比较次数" + count1 + "   移动次数" + count2);
    }
}
