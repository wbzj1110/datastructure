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
 * �ӱ�����ҳ��ȡ��mids
 * @author wb
 * @version 2015-7-24 ����1:39:12
 */
public class getMids {
	public static void main(String[] args) {
		try {
			String str = readFileByLines("E:"+File.separator+"mids"+File.separator+"vani��_Jr��΢��_΢��.htm");
			String []strs = StringUtils.substringsBetween(str, "mid=\"", "\" "); 
			System.out.println(strs.length);
			StringBuilder sb = new StringBuilder();
			for(String s :strs){
				sb.append(s + ",");
			}
			String last = StringUtils.substringBeforeLast(sb.toString(), ",");
			System.out.println(URLEncoder.encode(last));
			System.out.println(URLEncoder.encode("http://www.test.�й�"));
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
			System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null) {
				// ��ʾ�к�
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
