package org.wangbin.datastructure.test;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class matcher {
	public static void main(String[] args) {
		// List<String> urls = new ArrayList<String>();
		// String text = " 今天天气不太好其实www.v.youku.中国222224";
		// // String text = "www.123.hk.edu";
		// String url = null;
		// Matcher matcher = pattern1.matcher(text);
		// String targets = "中国";
		// byte[]bytes = targets.getBytes();
		// // byte[]bytes2 = targets.getBytes("utf-8");
		// char []cs = targets.toCharArray();
		// try {
		//
		// while (matcher.find()) {
		// url = matcher.group(0);
		// if (url != null) {
		// urls.add(url);
		// System.out.println(url);
		// }
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// System.out.println(str);
		// System.out.println("(?:(?:中国|:公司|:网络|z[amw]))");
		// System.out.println("~~");

		String src = ".中国今天天气不太好其实www.v.youku.中国";
		System.out.println(URLEncoder.encode("www.v.youku.中国"));
		String src2 = "http://v.youku.中国/v_show/id_XMTI5MDYyNjU2MA==_ev_2.html46512";
		System.out.println("展示开始");
		List<String> ls = getUrls(src);
		for (String s : ls) {
			System.out.println(s);
		}
		System.out.println("展示开始2");
		
		List<String> ls2 = getUrls(src2);
		
		for (String s : ls2) {
			System.out.println(s);
		}
		System.out.println("~~~~~~~~");
		String str1 = "哈";
		char []ct = str1.toCharArray();
		char c = '哈';
		int iii  = c;
		System.out.println();
		String str3 = "哈哈.中国www.v.youku.中国";
		System.out.println("替换之前str3的chars长度：" +str3.toCharArray().length);
		char[]charsss = str3.toCharArray();
		if(str3.contains(".中国")){
			str3 = str3.replaceAll(".中国", "###");//字符可以更特殊
		}
		System.out.println(str3);
		System.out.println("替换之后str3的chars长度：" +str3.toCharArray().length);
		char[] chars = str3.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 0x80) {
				chars[i] = ' ';
			}
		}
		
		str3 = new String(chars);
		System.out.println("chars数组过滤玩之后:" + str3 + "~~长度" + str3.length() +"~chars" +str3.toCharArray().length);
		if(str3.contains("###")){
			str3 = str3.replaceAll("###", ".中国");
		}
		System.out.println("最终还原之后的连接:" + str3 + "~~长度 " + str3.length()+"~chars" +str3.toCharArray().length);
		
		System.out.println("时间判断~~~");
		long time1 = System.currentTimeMillis();
		for(int i = 0;i <100000;i++){
			getUrls(str3);
		}
		System.out.println(System.currentTimeMillis()-time1);
		time1= System.currentTimeMillis();
		for(int i = 0;i <100000;i++){
			getUrls2(str3);
		}
		System.out.println(System.currentTimeMillis()-time1);
	}

	public static List<String> getUrls(String src) {
		List<String> urls = new ArrayList<String>();
		if (!StringUtils.isBlank(src)) {
			Matcher matcher = pattern1.matcher(patchRegx(src));
//			Matcher matcher = pattern1.matcher((src));
			String url = null;
			while (matcher.find()) {
				url = matcher.group(0);
				if (url != null) {
					urls.add(url);
					System.out.println(url);
				}
			}
		}
		return urls;
	}

	public static List<String> getUrls2(String src) {
		List<String> urls = new ArrayList<String>();
		if (!StringUtils.isBlank(src)) {
			Matcher matcher = pattern1.matcher((src));
//			Matcher matcher = pattern1.matcher((src));
			String url = null;
			while (matcher.find()) {
				url = matcher.group(0);
				if (url != null) {
					urls.add(url);
					System.out.println(url);
				}
			}
		}
		return urls;
	}
	private static List<String> ls = new ArrayList<String>();
	static{
		ls.add(".中国");
		ls.add(".网络");
		ls.add(".公司");
	}
	public static String patchRegx(String src) {
		if(StringUtils.containsAny(src, ".中国",".网络",".公司")){
			return src;
		}
		System.out.println("patchRegx前 ：" + src);
		char[] chars = src.toCharArray();
		for (int i = 0,len = chars.length; i < chars.length; i++) {
			if (chars[i] > 0x80) {
				chars[i] = ' ';
			}else{
				//要对.中国  .网络  .公司不做处理
				if(chars[i]==46){
					if(i<len-2){
						String temp = String.valueOf(chars[i])+String.valueOf(chars[i+1])+String.valueOf(chars[i+2]);
						if(isEquals(temp)){
							i+=2;
						}
					}
				}
			}
		}
		System.out.println("patchRegx后：" + new String(chars));
		return new String(chars);
	}

	private static boolean isEquals(String temp) {
		// TODO Auto-generated method stub
		for(String s:ls){
			if(s.equals(temp)){
				return true;
			}
		}
		return false;
	}
	private static final Pattern pattern1 = Pattern
			.compile(
					new StringBuilder()
							.append("((?:(http|https|Http|Https|rtsp|Rtsp):")
							.append("\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)")
							.append("\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_")
							.append("\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?")
							.append("((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}\\.)+")
							// named host
							.append("(?:")
							// plus top level domain
							.append("(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])")
							.append("|(?:biz|b[abdefghijmnorstvwyz])")
							.append("|(?:cat|com|coop|c[acdfghiklmnoruvxyz])")
							.append("|d[ejkmoz]")
							.append("|(?:edu|e[cegrstu])")
							.append("|f[ijkmor]")
							.append("|(?:gov|g[abdefghilmnpqrstuwy])")
							.append("|h[kmnrtu]")
							.append("|(?:info|int|i[delmnoqrst])")
							.append("|(?:jobs|j[emop])")
							.append("|k[eghimnrwyz]")
							.append("|l[abcikrstuvy]")
							.append("|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])")
							.append("|(?:name|net|n[acefgilopruz])")
							.append("|(?:org|om)")
							.append("|(?:pro|p[aefghklmnrstwy])")
							.append("|qa")
							.append("|r[eouw]")
							.append("|s[abcdeghijklmnortuvyz]")
							.append("|(?:tel|travel|t[cdfghjklmnoprtvwz])")
							.append("|u[agkmsyz]")
							.append("|v[aceginu]")
							.append("|w[fs]")
							.append("|y[etu]")
							// 加入.中国 .公司 .网络 3个顶级中文域名解析
							.append("|(?:中国|公司|网络)")
							// .append("|(?:中国)")
							// .append("|(?:公司)")
							// .append("|(?:网络)")

							.append("|z[amw]))")
							.append("|(?:(?:25[0-5]|2[0-4]")
							// or ip address
							.append("[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]")
							.append("|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1]")
							.append("[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}")
							.append("|[1-9][0-9]|[0-9])))")
							.append("(?:\\:\\d{1,5})?)")
							// plus option port number
							.append("((?:\\/)*(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~")
							// plus option query params
							.append("\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?")
							.append("(?:\\b|$)").append("?(?:\\/)*").toString(),
					Pattern.CASE_INSENSITIVE); // 不区分大小写

	private static final String str = new StringBuilder().append("(?:")
	// plus top level domain
	// //加入.中国 .公司 .网络 3个中文后缀,3选一
			// .append("|(?:中国|公司|网络)")
			.append("|:中国").append("|:公司").append("|:网络")

			.append("|z[amw]))").toString();

}
