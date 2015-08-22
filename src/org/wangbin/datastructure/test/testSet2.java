package org.wangbin.datastructure.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class testSet2 {
	public static void main(String[] args) {
		String src= "https://tower1.im.网络 https://tower1.im.公司 ";
		List<String> ls = getUrls(src);
		for(String s :ls){
			System.out.println(s);
		}
		
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
				}
			}
		}
		return urls;
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

	private static Set<String> filterSets = new HashSet<String>(3);//后续可以连同大的正则一块修改为白名单配置模式。
    static{
        filterSets.add(".中国");
        filterSets.add(".网络");
        filterSets.add(".公司");
    }
	 private static String patchRegx(String src) {
			char[] chars = src.toCharArray();
			for (int i = 0,len = chars.length; i < len; i++) {
			    if (chars[i] > 0x80) {
					chars[i] = ' ';
				}else{
				    //要对.中国  .网络  .公司不做处理
				    if(chars[i]=='.'){
				        if(i<len-2){
				            //为了后续扩展 i开始截取3位，取出.XX来，判断是否在filterSets中
				            if(filterSets.contains(new String(chars,i,3))){
				                i+=2;//java的char是2个字节，每个汉字是占一个char，向后走2个char，所以i+=2
				            }
				        }
				    }
				}
			    
			}
			return new String(chars);
		}
	
	
	
	
}
