package org.wangbin.datastructure.tree;

public class ParentNode<T> {
	private T data;
	private int parent;//Ë«Ç×Î»ÖÃ
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
