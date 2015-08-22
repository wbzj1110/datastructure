package org.wangbin.datastructure.tree;

import java.util.Map;
import java.util.Queue;

import com.google.common.collect.Queues;
import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * 二叉树的建立
 * @author wb
 * @version 2015-7-16 下午2:39:09
 */
public class MinBinaryTree {
	private static TreeNode<Integer> root;

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		MinBinaryTree bTree = new MinBinaryTree();
//		root =  MinBinaryTree.insertNodeFromArray(array, 0, array.length - 1);
		for (int i = 0, len = array.length; i < len; i++) {
			bTree.buildTree(bTree.root, array[i]);
		}

		bTree.preOrder(bTree.root);
		System.out.println();
		bTree.inOrder(bTree.root);
		System.out.println();
		bTree.postOrder(bTree.root);
		System.out.println();
		levelOrderTraversal(bTree.root);
		
		
		
		
		
		
		
		
		
	}
	/**
	 * 广度优先遍历
	 * @param root2
	 */
	private static void levelOrderTraversal(TreeNode<Integer> root2) {
		// TODO Auto-generated method stub
		Queue<TreeNode<Integer>> queue = Queues.newArrayDeque();
		queue.add(root2);
		while(!queue.isEmpty()){
			TreeNode<Integer> node = queue.remove();
			System.out.println(node);
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	/**
	 * 后序遍历
	 * @param root2
	 */
	private void postOrder(TreeNode<Integer> root2) {
		// TODO Auto-generated method stub
		if(root2!=null){
			preOrder(root2.left);
			preOrder(root2.right);
			System.out.print(root2.data + "  ");
		}
	}
	/**
	 * 中序遍历
	 * @param root2
	 */
	private void inOrder(TreeNode<Integer> root2) {
		// TODO Auto-generated method stub
		if(root2!=null){
			preOrder(root2.left);
			System.out.print(root2.data + "   ");
			preOrder(root2.right);
		}
	}
	/**
	 * 先序遍历
	 * @param root2
	 */
	private void preOrder(TreeNode<Integer> root2) {
		// TODO Auto-generated method stub
		if(root2!=null){
			System.out.print(root2.data + "   ");
			preOrder(root2.left);
			preOrder(root2.right);
		}
	}

	private void buildTree(TreeNode<Integer> node, int data) {
		// TODO Auto-generated method stub
		if(root==null){
			root = new TreeNode<Integer>(data);
		}else{
			if(node.data >data){
				if(node.right==null){
					node.right = new TreeNode<Integer>(data);
				}else{
					buildTree(node.right, data);
				}
			}else{
				if(node.left==null){
					node.left = new TreeNode<Integer>(data);
				}else{
					buildTree(node.left,data);
				}
			}
		}
	}
	
	
	
	/**
	 * 有序序列的最小高度的二叉树构建
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static TreeNode<Integer> insertNodeFromArray(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if(end < start){
			return null;
		}
		
		int middle =  (start + end) / 2;
		
		TreeNode<Integer> treeNode = new TreeNode<Integer>(array[middle]);
		
		treeNode.left = insertNodeFromArray(array, start, middle - 1);
		treeNode.right = insertNodeFromArray(array, middle + 1, end);
		
		return treeNode;
	}
	
	
	
	
}
