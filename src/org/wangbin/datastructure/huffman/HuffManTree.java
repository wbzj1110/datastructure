package org.wangbin.datastructure.huffman;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * �����շ����� (1)��List���������нڵ�������� (2)�ҳ�List������Ȩֵ��С�������ڵ㡣 (3)��Ȩֵ��С�������ڵ���Ϊ�ӽڵ㴴���½ڵ㡣
 * (4)��List������ɾ��Ȩֵ��С�������ڵ㣬���½ڵ���ӵ�List�����С�
 * 
 * @author wb
 * @version 2015-7-18 ����2:51:55
 */
public class HuffManTree {
	private static ComparatorListNodes com = new ComparatorListNodes();

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("A", 40.0));
		nodes.add(new Node("B", 8.0));
		nodes.add(new Node("C", 10.0));
		nodes.add(new Node("D", 30.0));
		nodes.add(new Node("E", 10.0));
		nodes.add(new Node("F", 2.0));
		Node root = HuffManTree.createTree(nodes);
		System.out.println(breadthFirst(root));
//		String strss[] = StringUtils.split("123", ",");
		String strss[] = StringUtils.split(null,",");
		System.out.println(Arrays.toString(strss));
		List<Integer> ls = new ArrayList<Integer>(10);
		Integer []lengths = new Integer[10];
		System.out.println(getCollectionLength(ls,lengths));
		getArrayLenth(new int[10]);
		getArrayLenth(new Integer[10]);
		getArrayLenth(new String[10]);
	}


	private static int getCollectionLength(Object... lss) {
		// TODO Auto-generated method stub
		if(lss==null||lss.length==0){
			return 10;
		}
		int result = 0;
		for(Object ls :lss){
			if(ls instanceof Collection<?>){
				if(ls!=null){
					Collection<?> tempL = (Collection<?>)ls;
					result+=tempL.size();
				}
			}else if(ls.getClass().isArray()){
//				result += getArrayLenth(ls);
			}
		}
		if(result==0){
			result = 10;
		}
		return result;
	}


	private static int getArrayLenth(Object ls) {
		// TODO Auto-generated method stub
		//��Ҫint ��Integer�ǲ�һ����
		if(ls!=null){
			System.out.println(ArrayUtils.toArray(ls).length);;
			
		}
		
		return 0;
	}


	private static Node createTree(List<Node> nodes) {
		// TODO Auto-generated method stub
		
		while (nodes.size() > 1) {// ���ٻ���2���ڵ�����
			Collections.sort(nodes, com);
			System.out.println(nodes);
			Node left = nodes.get(nodes.size() - 1);
			Node right = nodes.get(nodes.size() - 2);
			Node parent = new Node(null, left.getWeigh() + right.getWeigh());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(nodes.size() - 1);
			nodes.remove(nodes.size() - 1);
			nodes.add(parent);  
		}
		return nodes.get(0);
	}
	 //������ȱ���  
    public static List<Node> breadthFirst(Node root)  
    {  
        Queue<Node> queue = new ArrayDeque<Node>();  
        List<Node> list = new ArrayList<Node>();  
        if( root != null)  
        {  
            //����Ԫ���롰���С�  
            queue.offer(root);  
        }  
        while(!queue.isEmpty())  
        {  
            //���ö��еġ���β����Ԫ����ӵ�List��  
            list.add(queue.peek());  
            Node p = queue.poll();  
            //������ӽڵ㲻Ϊnull���������롰���С�  
            if(p.getLeft() != null)  
            {  
                queue.offer(p.getLeft());  
            }  
            //������ӽڵ㲻Ϊnull���������롰���С�  
            if(p.getRight() != null)  
            {  
                queue.offer(p.getRight());  
            }  
        }  
        return list;  
    }  

}

class Node<T> {
	private T data;
	private double weigh;
	private Node<T> left;
	private Node<T> right;

	public Node(T data, double weigh) {
		this.data = data;
		this.weigh = weigh;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public double getWeigh() {
		return weigh;
	}

	public void setWeigh(double weigh) {
		this.weigh = weigh;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node[data=" + data 
//				+ ", weigh=" + weigh + "]"
				;
	}

}

class ComparatorListNodes implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if ((o1.getWeigh() - o2.getWeigh()) < 0) {
			return 1;
		} else {
			return -1;
		}
	}

}
