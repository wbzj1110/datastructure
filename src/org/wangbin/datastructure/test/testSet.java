package org.wangbin.datastructure.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class testSet {
	public static void main(String[] args) {
		Set<Integer> cards = new LinkedHashSet<Integer>(10);
		System.out.println(cards.size()>0);
		
//		for(int i = -127;i <=128;i++){
//			System.out.print(i +":"+(char)i +"~~~~");
//			if(i%10==0){
//				System.out.println();
//			}
//		}
//		System.out.println();
		
		
		String src = ".中国今天天气不太好其实www.v.youku.中国";
		String src2 = "http://v.youku.中国/v_show/id_XMTI5MDYyNjU2MA==_ev_2.html46512";
		System.out.println(patchRegx(src));
		System.out.println(patchRegx(src2));
		System.out.println("~~~~~~~~~~~");
		matcher.getUrls2(src);
		matcher.getUrls2(src2);
		System.out.println("~~~~~~~~~~");
		String src3 = ".中国.中国啦啦啦啦.中国哈哈.网络lalala.公司";
		System.out.println(patchRegx(src3));
		
		List<char[]>lsss = new ArrayList<char[]>();
		char[]cs1 = new char[]{'1','2','3'};
		char[]cs2 = new char[]{'1','2','3'};
		lsss.add(cs1);
		System.out.println(lsss.contains(cs2));
		System.out.println("~~~~~~~~~~~~~");
		char[]chars = src3.toCharArray();
		for (int i = 0,len = chars.length; i < len; i++) {
			if (chars[i] > 0x80) {
				chars[i] = ' ';
			}else{
			  //要对.中国  .网络  .公司不做处理
                if(chars[i]=='.'){
                    if(i<len-2){
                        //为了后续扩展，也阔以改为char[]数组进行判定
                    	System.out.println(new String(chars,i,3));
                        if(filterSets.contains(new String(chars,i,3))){
                            i+=2;
                        }
                    }
                }
			}
		}
		System.out.println(new String(chars));
		System.out.println(patchRegx(".中国.中国哈哈哈.中国"));
	}
	private static List<String> ls = new ArrayList<String>();//可以修改为人工培植的模式，让pm配置
	static{
		ls.add(".中国");
		ls.add(".网络");
		ls.add(".公司");
	}
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
	private static boolean isEquals(String temp) {
		// TODO Auto-generated method stub
		if(ls.contains(temp)){
			return true;
		}
		return false;
	}
}
