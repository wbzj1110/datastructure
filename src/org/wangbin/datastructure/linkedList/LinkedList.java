package org.wangbin.datastructure.linkedList;

import org.wangbin.datastructure.Node;

public class LinkedList {
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = node1;
		int length = getListLength(node1);
		System.out.println(length);	
		}

	private static int getListLength(Node<Integer> node1) {
		// TODO Auto-generated method stub
	
		int haveLoop = testWhetherHaveLoop(node1);
		return haveLoop;
	}

	private static int testWhetherHaveLoop(Node<Integer> node1) {
		// TODO Auto-generated method stub
		Node<Integer> fast = node1;
		Node<Integer> slow = node1;
		int i = 0;
		for(;;){
			i++;
			if(fast.next==null){
				//不存在环
				System.out.println(i);
				return i;
			}
			i++;
			if(fast.next.next==null){
				System.out.println(i);
				return i;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				//有环
				System.out.println(i);
				return i/2;
			}
			
		}
	}
		
	
	
	
}
