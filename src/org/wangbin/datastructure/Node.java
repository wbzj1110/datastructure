package org.wangbin.datastructure;

/**
 * �Զ���ڵ�
 * @author wb
 * @version 2015-7-9 ����9:40:24 
 * @param <T>
 */
public class Node<T> {
	public Node<T> next;
	public T data;
	public Node(T _data){
		this.data = data;
	}
	public Node(T _data,Node<T> next){
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
