package org.wangbin.datastructure.otherSmallDemo;

import java.io.*;
/**
 * 多皇后
 * @author wb
 * @date 2015-8-22 上午9:20:27
 */
public class BackDateQueen {
    private int s[] = null;// 存放皇后所在的位置s[i]表示所在行，i表示所在列。

    private int count = 0;// 几个皇后问题，在这里是8
    private int suc;

    public BackDateQueen(int count) {
        suc = 0;
        this.count = count;
        s = new int[count];
        for (int i = 0; i < count; i++) {
            s[i] = -1;
        }
    }

    public void queen(int n) {// 核心函数，实现把所有的满足题义的情况列出来

        if (n == 8) {// 因为是回朔法，所以用到递归，这里是递归 的出口
            suc++;
            printThis();// 打印
            return;
        }

        for (int i = 0; i < count; i++) {// 循环对一列中的所有行进行考虑
            s[n] = i;// 第n列放在第i行，n表是列.
            if (isCan(n)) {// 如果这种情况成立，则递归下去。
                queen(n + 1);// 递归，对第n+1列进行考虑（一般最外面是从0列开始）.
            }
        }

    }/*
      * 注意他在每个递归函数中都有循环，这样就使得，他还会考虑在该活接点的接下来的 情况，考虑完后，他还会随着递归函数的返回而进行回朔，直到根接点为止，这样就能把所 的情况都找到
      */

    public boolean isCan(int n) {
        for (int i = 0; i < n; i++) {
            if (s[i] == s[n]) return false;// 不在同一行
            if (Math.abs(s[n] - s[i]) == n - i) return false;// 不在同一斜线上
        }

        return true;
    }

    public void printThis() {// 打印函数
        System.out.println("第" + suc + "种放法" + "皇后分别放在以下列的以下行：");
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "列的第" + s[i] + "行");
        }
    }

    public static void main(String[] args) {
        BackDateQueen bdq = new BackDateQueen(8);
        bdq.queen(0);
    }
}

/*
 * 在这个问题上一定要知道是用一维数组来存储皇后的存储信息的，列随着数组的标量i(上述类中是n)已经决定了，数组中的值表示皇后所在行(当然你可以倒过来)
 */

/*
 * 基本思路：先从第0列开始考虑，在第0列的所有行循环试看能否放皇后，如果能则递归下去(找第2列的)，又回到同样 的
 * 问题(正好是递归的特性),就这样一直递归下去，出口是直到放了八个皇后，递归函数最低层的返回
 * ，随着函数返回，向上回朔一层，继续遍历，直到这层遍历完，再向上回朔，一直回朔到起始的最外层递归函数，这样就把所有满足条件的内容打印出来了
 */

