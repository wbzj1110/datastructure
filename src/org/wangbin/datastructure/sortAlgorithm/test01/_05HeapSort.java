package org.wangbin.datastructure.sortAlgorithm.test01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆排序重复练习
 * @author wb
 * @date 2015-8-23 下午2:52:08
 */
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
        //priorityQueue本身就是最小排队排序。
        Queue<Integer> queue = new PriorityQueue<Integer>();
       
        
    }

    private static void heapSort(int[] bb) {
        // TODO Auto-generated method stub
        int n = bb[0];//第一位代表得是数组的长度
        for(int i = n/2;i>0;i--){// 1<=i<=n/2的下限
            headAdjust(bb,i,n);
        }
        System.out.println("第一次构建完大顶堆 : " + Arrays.toString(bb));
        //讲大顶堆的最大值，放入数组的最后位置
        for (int i = n; i > 1; i--) {
            swap(bb, 1, i);
            headAdjust(bb, 1, i - 1);
        }
        System.out.println(Arrays.toString(bb));
    }

    private static void swap(int[] aa, int i, int j) {
        // TODO Auto-generated method stub
        int temp = aa[i];
        aa[i] = aa[j];
        aa[j] = temp;
    }

    private static void headAdjust(int[] aa, int s, int length) {
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
