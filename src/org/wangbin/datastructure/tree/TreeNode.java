package org.wangbin.datastructure.tree;

public class TreeNode<T> {
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	public TreeNode(T data){
		this.data = data;
	}
	public TreeNode(T data,TreeNode<T> right ,TreeNode<T> left){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
	
}
