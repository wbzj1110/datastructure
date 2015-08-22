package org.wangbin.datastructure.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Charsets;

/**
 * 从本地网页读取出mids
 * @author wb
 * @version 2015-7-24 下午1:39:12
 */
public class getMids {
	public static void main(String[] args) {
		try {
			String str = readFileByLines("E:"+File.separator+"mids"+File.separator+"vani周_Jr的微博_微博.htm");
			String []strs = StringUtils.substringsBetween(str, "mid=\"", "\" "); 
			System.out.println(strs.length);
			StringBuilder sb = new StringBuilder();
			for(String s :strs){
				sb.append(s + ",");
			}
			String last = StringUtils.substringBeforeLast(sb.toString(), ",");
			System.out.println(URLEncoder.encode(last));
			System.out.println(URLEncoder.encode("http://www.test.中国"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	public static String readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				sb.append(tempString);
				// line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return sb.toString();
	}
}
