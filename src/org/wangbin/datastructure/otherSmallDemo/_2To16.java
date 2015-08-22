package org.wangbin.datastructure.otherSmallDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class _2To16 {

	private static Map<String, String> maps = new HashMap<String, String>();
	static {
		maps.put("0000", "0");
		maps.put("0001", "1");
		maps.put("0010", "2");
		maps.put("0011", "3");
		maps.put("0100", "4");
		maps.put("0101", "5");
		maps.put("0110", "6");
		maps.put("0111", "7");
		maps.put("1000", "8");
		maps.put("1001", "9");
		maps.put("1010", "A");
		maps.put("1100", "B");
		maps.put("1101", "C");
		maps.put("1110", "D");
		maps.put("1111", "E");

	}

	public static void main(String[] args) {
		String str = "01010";
		Stack<String> ss = new Stack<String>();
		Stack<String> ss2 = new Stack<String>();
		for (char c : str.toCharArray()) {
			ss.push(c + "");
		}
		System.out.println(ss.toString());
		// 转换弹3个数计算一次
		StringBuilder sb = new StringBuilder(3);
		while (!ss.isEmpty()) {
			sb.append(ss.pop());
			if (sb.length() == 4) {
				ss2.push(maps.get(sb.reverse().toString()));
				sb = new StringBuilder(4);
			}
		}
		// 如果还有的话
		if (sb.length() != 0) {
			// 补零计算
			String temp = maps.get(StringUtils.leftPad(sb.reverse().toString(), 4, "0"));
			if(!temp.equals("0")){
				ss2.push(temp);
			}
		}
		System.out.println("看一下ss2" + ss2.toString());
		sb = new StringBuilder();
		while (!ss2.isEmpty()) {
			sb.append(ss2.pop());
		}
		System.out.println(sb.toString());

	}
}
