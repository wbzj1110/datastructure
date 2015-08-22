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
		
		
		String src = ".�й�����������̫����ʵwww.v.youku.�й�";
		String src2 = "http://v.youku.�й�/v_show/id_XMTI5MDYyNjU2MA==_ev_2.html46512";
		System.out.println(patchRegx(src));
		System.out.println(patchRegx(src2));
		System.out.println("~~~~~~~~~~~");
		matcher.getUrls2(src);
		matcher.getUrls2(src2);
		System.out.println("~~~~~~~~~~");
		String src3 = ".�й�.�й���������.�й�����.����lalala.��˾";
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
			  //Ҫ��.�й�  .����  .��˾��������
                if(chars[i]=='.'){
                    if(i<len-2){
                        //Ϊ�˺�����չ��Ҳ���Ը�Ϊchar[]��������ж�
                    	System.out.println(new String(chars,i,3));
                        if(filterSets.contains(new String(chars,i,3))){
                            i+=2;
                        }
                    }
                }
			}
		}
		System.out.println(new String(chars));
		System.out.println(patchRegx(".�й�.�й�������.�й�"));
	}
	private static List<String> ls = new ArrayList<String>();//�����޸�Ϊ�˹���ֲ��ģʽ����pm����
	static{
		ls.add(".�й�");
		ls.add(".����");
		ls.add(".��˾");
	}
	private static Set<String> filterSets = new HashSet<String>(3);//����������ͬ�������һ���޸�Ϊ����������ģʽ��
    static{
        filterSets.add(".�й�");
        filterSets.add(".����");
        filterSets.add(".��˾");
    }
    private static String patchRegx(String src) {
		char[] chars = src.toCharArray();
		for (int i = 0,len = chars.length; i < len; i++) {
		    if (chars[i] > 0x80) {
				chars[i] = ' ';
			}else{
			    //Ҫ��.�й�  .����  .��˾��������
			    if(chars[i]=='.'){
			        if(i<len-2){
			            //Ϊ�˺�����չ i��ʼ��ȡ3λ��ȡ��.XX�����ж��Ƿ���filterSets��
			            if(filterSets.contains(new String(chars,i,3))){
			                i+=2;//java��char��2���ֽڣ�ÿ��������ռһ��char�������2��char������i+=2
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
