package org.wangbin.datastructure.otherSmallDemo;
/**
 * 递归解决汉诺塔问题
 * @author wb
 * @version 2015-5-23 上午11:17:12
 */
public class towerOfHanuo {
	
	
	public static void main(String[] args) {
		int n = 3;
		char x = 'x';
		char y= 'y';
		char z = 'z';
		move(n,x,y,z);
	}
	/*
	 * n个数从x 借助y  移动到z
	 */
	private static void move(int n, char x, char y, char z) {
		// TODO Auto-generated method stub
		if(n==1){
			System.out.println(x + ">>" +z);
		}else {
			move(n-1, x, z, y);
			System.out.println(x + ">>" +z);
			move(n-1, y, x, z);
		}
	}
	
	
	
}
