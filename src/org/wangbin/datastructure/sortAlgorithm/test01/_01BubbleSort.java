package org.wangbin.datastructure.sortAlgorithm.test01;

import java.util.Arrays;

/**
 * 重复练习，冒泡排序
 * 
 * @author wb
 * @date 2015-8-23 下午1:15:34
 */
public class _01BubbleSort {
    public static void main(String[] args) {
        int[] aa = new int[] {5, 3, 9, 10, 7, 4, 2, 1, 6, 8};
        bubbleSort1(aa);
        aa = new int[] {5, 3, 9, 10, 7, 4, 2, 1, 6, 8};
        bubbleSort2(aa);
        aa = new int[] {5, 3, 9, 10, 7, 4, 2, 1, 6, 8};
        bubbleSort3(aa);
        aa = new int[] {5, 3, 9, 10, 7, 4, 2, 1, 6, 8};
        bubbleSort4(aa);
        
        aa = new int[] {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        bubbleSort1(aa);
        aa = new int[] {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        bubbleSort2(aa);
        aa = new int[] {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        bubbleSort3(aa);
        aa = new int[] {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
        bubbleSort4(aa);
        
    }

    /**
     * 正常滴冒泡~~
     * 
     * @param aa
     */
    public static void bubbleSort1(int[] aa) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0, len = aa.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                count1++;
                if (aa[i] > aa[j]) {
                    count2++;
                    swap(aa, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(aa) + "  比较次数" + count1 + "   移动次数" + count2);
    }

    private static void swap(int[] aa, int i, int j) {
        // TODO Auto-generated method stub
        int temp = aa[i];
        aa[i] = aa[j];
        aa[j] = temp;
    }

    /**
     * 会出现个问题，0,1,2,3,4,5,6,7,8,9这种冒泡会一直交换 so 改进
     * 
     * @param aa
     */
    public static void bubbleSort2(int[] aa) {
        int count1 = 0;
        int count2 = 0;
        boolean falg = true;
        for (int i = 0, len = aa.length; i < len && falg; i++) {
            falg = false;
            for (int j = i + 1; j < len; j++) {
                count1++;
                if (aa[i] > aa[j]) {
                    falg = true;
                    count2++;
                    swap(aa, i, j);
                }
            }
        }
        System.out.println("改进后" + Arrays.toString(aa) + "  比较次数" + count1 + "   移动次数" + count2);

    }

    /**
     * 过程不难发现一个规律那就是在第一步优化的基础上发进一步思考：如果R[0..i]已是有序区间，上次的扫描区间是R[i..n]，记上次扫描时最后
     * 一次执行交换的位置为lastSwapPos，则lastSwapPos在i与n之间
     * ，不难发现R[i..lastSwapPos]区间也是有序的，否则这个区间也会发生交换；所以下次扫描区间就可以由R[i..n] 缩减到[lastSwapPos..n]
     */
    public static void bubbleSort3(int[] aa) {
        int count1 = 0;
        int count2 = 0;
        boolean falg = true;
        int lastSwapPos = 0, lastSwapPosTemp = 0;
        for (int i = 0, len = aa.length; i < len && falg; i++) {
            falg = false;
            lastSwapPos = lastSwapPosTemp;
            for (int j = len - 1; j > lastSwapPos; j--) {
                count1++;
                if (aa[j - 1] > aa[j]) {
                    count2++;
                    falg = true;
                    int temp = aa[j - 1];
                    aa[j - 1] = aa[j];
                    aa[j] = temp;
                    lastSwapPosTemp = j;
                }
            }
            // 不发生交换了 说明都有规律了那
            if (lastSwapPos == lastSwapPosTemp) {
                break;
            }
        }
        System.out.println("改进后2" + Arrays.toString(aa) + "  比较次数" + count1 + "   移动次数" + count2);

    }
    /**
     * 双向冒泡排序算法的运作如下： 传统冒泡气泡排序的双向进行，先让气泡排序由左向右进行，再来让气泡排序由右往左进行，如此完成一次排序的动作
     * 使用left与right两个旗标来记录左右两端已排序的元素位置。
     * 
     * @param aa
     */
    public static void bubbleSort4(int[] aa) {
        int left = 0;
        int right = aa.length - 1;
        int index =0;
        int i =0;
        int count1 =0;
        int count2=0;
        while (left < right) {
            for (int j = left; j < right; j++) {
                count1++;
                if (aa[j] > aa[j + 1]) {
                    count2++;
                    swap(aa,j,j+1);
                    index = j;
                }
            }
            right = index;
            for (int j = right; j > left; j--) {
                count1++;
                if (aa[j] < aa[j - 1]) {
                    count2++;
                    swap(aa,j,j-1);
                    index = j;
                }
            }
            left = index;
            System.out.print("第" + ++i+"趟:" );
            System.out.println(Arrays.toString(aa));
            
        }
        System.out.println("双向冒泡" + Arrays.toString(aa)+ "  比较次数" + count1
                + "   移动次数" + count2);
    }
}
