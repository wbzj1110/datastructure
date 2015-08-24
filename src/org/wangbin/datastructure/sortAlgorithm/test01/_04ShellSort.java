package org.wangbin.datastructure.sortAlgorithm.test01;

import java.util.Arrays;

/**
 * 希尔排序重复练习
 * @author wb
 * @date 2015-8-23 下午2:45:08
 */
public class _04ShellSort {
    public static void main(String[] args) {
        int[] aa = new int[] { 5, 3, 9, 10, 7, 4, 2, 1, 6, 8 };
        shellSort2(aa);
        System.out.println(Arrays.toString(aa));
    }
    public static void shellSort2(int []a){
        int gap = a.length;//间隔数
        int j=0;
        do{
            gap = gap/3+1;
            //直插的过程
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
}
