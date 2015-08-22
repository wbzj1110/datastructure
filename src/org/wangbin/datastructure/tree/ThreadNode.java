package org.wangbin.datastructure.tree;
/**
 * 线索二叉树节点
 * @author wb
 * @version 2015-7-18 下午12:25:09
 */
public class ThreadNode {
	private int date;
	private ThreadNode left;
	private boolean leftTag;//判断左孩子是否为线索。false指向左孩子，否则指向其前驱
	private ThreadNode right;
	private boolean rightTag;//判断右孩子是否为线索。false指向右孩子，否则指向其后继
	
	public ThreadNode(int data){
		this.date = data;
		this.left = null;
		this.leftTag = false;
		this.right = null;
		this.rightTag = false;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public ThreadNode getLeft() {
		return left;
	}

	public void setLeft(ThreadNode left) {
		this.left = left;
	}

	public boolean isLeftTag() {
		return leftTag;
	}

	public void setLeftTag(boolean leftTag) {
		this.leftTag = leftTag;
	}

	public ThreadNode getRight() {
		return right;
	}

	public void setRight(ThreadNode right) {
		this.right = right;
	}

	public boolean isRightTag() {
		return rightTag;
	}

	public void setRightTag(boolean rightTag) {
		this.rightTag = rightTag;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "ThreadNode [date=" + date + ", left=" + left + ", leftTage=" + leftTag 
				+", right=" + right + ", rightTag=" + rightTag 
				+ "]";
	}

	

	
	
}
