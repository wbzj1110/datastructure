package org.wangbin.datastructure.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableList;

public class testShortUrl {
	public static void main(String[] args) {
		String url = "http://t.cn" + "/Rv6Cpgr?from_uid=123";
		System.out.println(getToken(url));
		url.replace("123", "1233333");
		System.out.println(url);

		String url2 = "http://hahahaha?from_uid=11333";
		String url3 = "http://hahahaha?from_uid=11333";
		System.out.println(enSureUrlLegal(url2));
		System.out.println(enSureUrlLegal(url3));
		System.out.println(url2.replace("ha", "~~~~"));
		Statuss s = new Statuss();
		s.text = "http://t.cn/RLp5plU?from_uid=123456";
		s.text=s.text.replace("http://t.cn/RLp5plU?from_uid=123456", "http://t.cn/RLp5plU?from_uid=555555?from_uid=1234566666");
		System.out.println(s.text);
		String test1 = "http://t.cn/RLp5plU?from_uid=555555?from_uid=1234566666";
		String result1 =test1.replaceAll("from_uid=[0-9]*", "from_uid=aaaaa");
		System.out.println("ende");
		System.out.println(result1);
		System.out.println(test1);
		System.out.println("~~~~~~~~~~");
		Pattern pa = Pattern.compile("(from_uid=[0-9]*)?");
		Matcher ma = pa.matcher(test1);
		while(ma.find()){
			
		}
		System.out.println("~");
		String test2= "http://t.cn/RLp5plU";
		String result2 =test2.replaceAll("from_uid=[0-9]*", "from_uid=aaaaa");
		System.out.println(result2);
		System.out.println(test2);
		
	}

	private static ImmutableList<String> illegalParamsForUlrs = ImmutableList
			.of("?from_uid=");

	/**
	 * 传入的url保证没有?from_uid=，有的话，把后边?from_uid=XXX内容过滤掉
	 * 
	 * @param target_url
	 * @return
	 */
	private static String enSureUrlLegal(String url) {
		// TODO Auto-generated method stub
		if (org.apache.commons.lang3.StringUtils.isNotBlank(url)) {
			for (String str : illegalParamsForUlrs) {
				url = org.apache.commons.lang3.StringUtils.substringBefore(url,
						str);
			}
		}
		return url;
	}

	public static String getToken(final String url) {
		Pattern pattern = Pattern.compile("http://" + "t.cn" + "/([^?]+)",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return url;
	}
	

}
 class Statuss{
	String text;
}
