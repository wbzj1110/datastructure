package org.wangbin.datastructure.tree;
/**
 * �����������ڵ�
 * @author wb
 * @version 2015-7-18 ����12:25:09
 */
public class ThreadNode {
	private int date;
	private ThreadNode left;
	private boolean leftTag;//�ж������Ƿ�Ϊ������falseָ�����ӣ�����ָ����ǰ��
	private ThreadNode right;
	private boolean rightTag;//�ж��Һ����Ƿ�Ϊ������falseָ���Һ��ӣ�����ָ������
	
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
