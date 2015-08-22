package org.wangbin.datastructure.otherSmallDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 中缀表达式变为后缀表达式
 * 
 * @author wb
 * @version 2015-5-23 上午11:24:10
 */
public class infixToSuffix {
	public static void main(String[] args) {
		String str = "1 - ( 2 + 3 ) * 4 + 5 / ( 2 - 1 )";
		str = toHouzhui(str);
		System.out.println(str.replaceAll("[()]", ""));
		
	}

	private static Map<String, Integer> maps = new HashMap<String, Integer>();
	static {
		maps.put("+", 1);
		maps.put("-", 1);
		maps.put("*", 2);
		maps.put("/", 2);
		maps.put("(", -1);
		maps.put(")", -1);
		// maps.put("", 7);
		// maps.put("", 8);

	}

	private static String toHouzhui(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(str.length());
		Stack<String> stack = new Stack<String>();
		String[] strs = str.split(" ");
		try {
			for (String s : strs) {
				if (s.equals("+") || s.equals("-") || s.equals("*")
						|| s.equals("/") || s.equals("(") || s.equals(")")) {
					chargeAndAdd(s, stack, sb);
				} else {
					sb.append(s);
				}
			}
			while(!stack.isEmpty()){
				sb.append(stack.pop());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static void chargeAndAdd(String s, Stack<String> stack,
			StringBuilder sb) {
		// TODO Auto-generated method stub
		try {
			//stack为空 ||遇到坐括号直接放进去 
			if (stack.isEmpty() ||s.equals("(")) {
				stack.add(s);
				return;
			}
			if(s.equals("/")){
				System.out.println("/");
			}
			String s1 = stack.peek();
			int a1 = maps.get(s1);//此时栈顶元素的优先级
			int a2 = maps.get(s);//要放入的符号的优先级
			if (a2 - a1 >=0) {
				stack.add(s);
			} else {
				// 先判断栈里边是否有左括号有的话，栈一直弹出到左括号，否则弹出到栈为空位置
				if (stack.contains("(")) {
					String s3 = stack.peek();
					while(!s3.equals("(")&&!stack.isEmpty()){
						sb.append(stack.pop());
						s3 = stack.peek();
					}
					if(stack.peek().equals("(")){
						stack.pop();
					}
				} else {
					// 弹到空
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					stack.add(s);
				}
				return;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
