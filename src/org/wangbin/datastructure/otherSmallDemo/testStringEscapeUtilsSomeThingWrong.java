package org.wangbin.datastructure.otherSmallDemo;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 关于使用StringEscapeUtils这个类的unescapeHtml方法的时候需要注意，
 * &nbsp;转换为空格，但是char已经超出了128了~~so~需要进一步转换、
 * @author wb
 * @date 2015-8-22 上午9:17:35
 */
public class testStringEscapeUtilsSomeThingWrong {
    
    public static void main(String[] args) {
        String a = "&nbsp;&nbsp;123a  ";
        a = StringEscapeUtils.unescapeHtml4(a);
        System.out.println(a);
        a = a.trim();
        System.out.println("trim之后:" +a);
        char []cs =a.toCharArray();
        byte[]bys = a.getBytes();
        System.out.println("发现trim不掉");
        a  = new String(a.getBytes()).trim();
        System.out.println("new String(bytes) 以后 :" + a);
        
    }
    
    
    
    
    
}
