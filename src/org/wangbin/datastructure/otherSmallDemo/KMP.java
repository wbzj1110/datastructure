package org.wangbin.datastructure.otherSmallDemo;

import java.util.Arrays;

public class KMP {

	// 获得模式串的next数组
	public static int[] getNext(String b) {
		
		int j = 0;
		int i = 1;
		char[] cs = (" "+b).toCharArray();
		
		int[] next = new int[ cs.length];
		next[0] = 0;
		next[1]=0;
		while (i < cs.length-1) {
			if (j==0|| cs[i] == cs[j]) {
				i++;
				j++;
				next[i] = j;
//				if(i==1){
//					next[j]=0;
//				}
				
			} else {
				j = next[j];
			}

		}
		return next;
	}

	// 返回子串T在主串S第pos个字符之后的位置
	public static int index_KMP(String s, String T, int pos) {

		return 0;
	}
	public static void main(String[] args) {
		int []nex = getNext("ilove.");
		System.out.println(Arrays.toString(nex));
	}
}
