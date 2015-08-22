package org.wangbin.datastructure.search;

public class BinarySearch {
	public static void main(String[] args) {
		int []aa = new int[]{5,3,9,10,7,4,2,1,6,8};
		int value = 9;
		int low = 0 ;
		int high = aa.length-1;
		Integer index =searchFor(aa,value,low,high);
		if(index == null){
			System.out.println("不存在");
		}else{
			System.out.println("位置 : " + index);
		}
	}
	/**
	 * 迭代查找
	 */
	public static Integer searchFor(int[] aa, int value,int low, int high) {
		int mid  = 0;
		while(low <high){
			mid = (low + high)/2;
			if(value < aa[mid]){
				high = mid-1;
			}else if(value > aa[mid]){
				low = mid + 1;
			}else{
				return mid;
			}
		}
		return null;
		
		
	}
	/**
	 * 递归调用
	 */
	public static Integer searchRecursion(int[] aa, int value, int low, int high) {
		// TODO Auto-generated method stub
		if(low >high){
			return low;
		}
		int mid = (low + high)/2;
		if(value<aa[mid]){
			return searchRecursion(aa, value, low, mid -1 );
		}else if(value>aa[mid]){
			return searchRecursion(aa, value, mid+1, high );
		}else{
			return aa[mid];
		}
		
	}
	
	
}
