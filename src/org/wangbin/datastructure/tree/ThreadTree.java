package org.wangbin.datastructure.tree;

/**
 * ����������
 * 
 * @author wb
 * @version 2015-7-18 ����12:29:51
 */
public class ThreadTree {
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8,9,10} ;
		ThreadTree tt = new ThreadTree(data) ;//������ͨ������
		System.out.println(tt);
		
		tt.inList(tt.getRoot()) ;//����ݹ����������
		System.out.println("");

		tt.inThread(tt.getRoot()) ;//�������������������������
		tt.inThreadList(tt.getRoot()) ;//�������������������
	}
	@Override
	public String toString() {
		return "ThreadTree [root=" + root + ", size=" + size + ", pre=" + pre
				+ "]";
	}
	private ThreadNode root;// ���ڵ�
	private int size;// ��С
	private ThreadNode pre = null;// ��������ʱ�򱣴�ǰ��

	public ThreadTree() {
		this.root = null;
		this.size = 0;
		this.pre = null;
	}

	public ThreadTree(int[] data) {
		this.root = createTree(data, 1);// ����������
		this.size = 0;
		this.pre = null;
	}

	private ThreadNode createTree(int[] data, int i) {
		// TODO Auto-generated method stub
		if (data.length < i) {
			return null;
		}
		ThreadNode node = new ThreadNode(data[i-1]);
		ThreadNode left = createTree(data, 2 * i);
		ThreadNode right = createTree(data, 2 * i + 1);
		node.setLeft(left);
		node.setRight(right);
		return node;
	}

	/**
	 * ����rootΪ���ڵ�Ķ�����������
	 * 
	 * @param root
	 */
	public void inThread(ThreadNode root) {
		if (root != null) {
			inThread(root.getLeft());// ����������
			if (null == root.getLeft()) {// ����Ϊ��
				root.setLeftTag(true);// ��ʾǰ��
				root.setLeft(pre);//�����趨Ϊǰ��
			}
			if (pre != null && null == pre.getRight()) {// �Һ���Ϊ��
				pre.setRightTag(true);
				pre.setRight(root);
			}
			pre = root;
			inThread(root.getRight());// �������Һ���
		}
	}
	public void inThread2(ThreadNode root){
		if(root!=null){
			inThread2(root.getLeft());//����������
			if(root.getLeft()==null){
				root.setLeftTag(true);
				root.setLeft(pre);
			}
			if(pre!=null&&pre.getRight()==null){
				pre.setRightTag(true);
				pre.setRight(root);
			}
			pre =root;
			inThread2(root.getRight());
		}
	}
	/**
	 * �����������������
	 * 
	 * @param root
	 */
	public void inThreadList(ThreadNode root) {
		if (root != null) {
			while (root != null && !root.isLeftTag()) {// ������Ӳ�������
				root = root.getLeft();//
			}

			do {
				System.out.print(root.getDate() + ",");
				if (root.isRightTag()) {// ����Һ���������
					root = root.getRight();
				} else {// ���Һ���
					root = root.getRight();
					while (root != null && !root.isLeftTag()) {
						root = root.getLeft();
					}
				}
			} while (root != null);
		}
	}
	/**
	* ��������ݹ��㷨
	* @param root
	*/
	public void preList(ThreadNode root){
	if(root != null){
	System.out.print(root.getDate() + ",");
	preList(root.getLeft()) ;
	preList(root.getRight()) ;
	}
	}

	/**
	* �������
	* @param root
	*/
	public void inList(ThreadNode root){
	if(root != null){
	inList(root.getLeft()) ;
	System.out.print(root.getDate() + ",");
	inList(root.getRight()) ;
	}
	}

	public ThreadNode getRoot() {
		return root;
	}

	public void setRoot(ThreadNode root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ThreadNode getPre() {
		return pre;
	}

	public void setPre(ThreadNode pre) {
		this.pre = pre;
	}
	

}
