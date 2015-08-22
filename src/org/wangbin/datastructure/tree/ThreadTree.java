package org.wangbin.datastructure.tree;

/**
 * 线索二叉树
 * 
 * @author wb
 * @version 2015-7-18 下午12:29:51
 */
public class ThreadTree {
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8,9,10} ;
		ThreadTree tt = new ThreadTree(data) ;//创建普通二叉树
		System.out.println(tt);
		
		tt.inList(tt.getRoot()) ;//中序递归遍历二叉树
		System.out.println("");

		tt.inThread(tt.getRoot()) ;//采用中序遍历将二叉树线索化
		tt.inThreadList(tt.getRoot()) ;//中序遍历线索化二叉树
	}
	@Override
	public String toString() {
		return "ThreadTree [root=" + root + ", size=" + size + ", pre=" + pre
				+ "]";
	}
	private ThreadNode root;// 根节点
	private int size;// 大小
	private ThreadNode pre = null;// 线索化的时候保存前驱

	public ThreadTree() {
		this.root = null;
		this.size = 0;
		this.pre = null;
	}

	public ThreadTree(int[] data) {
		this.root = createTree(data, 1);// 创建二叉树
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
	 * 将以root为根节点的二叉树线索化
	 * 
	 * @param root
	 */
	public void inThread(ThreadNode root) {
		if (root != null) {
			inThread(root.getLeft());// 线索化左孩子
			if (null == root.getLeft()) {// 左孩子为空
				root.setLeftTag(true);// 表示前驱
				root.setLeft(pre);//左孩子设定为前驱
			}
			if (pre != null && null == pre.getRight()) {// 右孩子为空
				pre.setRightTag(true);
				pre.setRight(root);
			}
			pre = root;
			inThread(root.getRight());// 线索化右孩子
		}
	}
	public void inThread2(ThreadNode root){
		if(root!=null){
			inThread2(root.getLeft());//线索化左孩子
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
	 * 中序遍历线索二叉树
	 * 
	 * @param root
	 */
	public void inThreadList(ThreadNode root) {
		if (root != null) {
			while (root != null && !root.isLeftTag()) {// 如果左孩子不是线索
				root = root.getLeft();//
			}

			do {
				System.out.print(root.getDate() + ",");
				if (root.isRightTag()) {// 如果右孩子是线索
					root = root.getRight();
				} else {// 有右孩子
					root = root.getRight();
					while (root != null && !root.isLeftTag()) {
						root = root.getLeft();
					}
				}
			} while (root != null);
		}
	}
	/**
	* 先序遍历递归算法
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
	* 中序遍历
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
