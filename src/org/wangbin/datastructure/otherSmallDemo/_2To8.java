package org.wangbin.datastructure.otherSmallDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

public class _2To8 {

	private static Map<String, String> maps = new HashMap<String, String>();
	static {
		maps.put("000", "0");
		maps.put("001", "1");
		maps.put("010", "2");
		maps.put("011", "3");
		maps.put("100", "4");
		maps.put("101", "5");
		maps.put("110", "6");
		maps.put("111", "7");
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
			if (sb.length() == 3) {
				ss2.push(maps.get(sb.reverse().toString()));
				sb = new StringBuilder(3);
			}
		}
		// 如果还有的话
		if (sb.length() != 0) {
			// 补零计算
			ss2.push(maps.get(StringUtils.leftPad(sb.reverse().toString(), 3, "0")));
		}
		System.out.println("看一下ss2" + ss2.toString());
		sb = new StringBuilder();
		while (!ss2.isEmpty()) {
			sb.append(ss2.pop());
		}
		System.out.println(sb.toString());

	}
}
