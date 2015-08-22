package org.wangbin.datastructure.KMP;

/**
 * Javaʵ��KMP�㷨
 * 
 * ˼�룺ÿ��һ��ƥ������г����ַ��Ƚϲ��ȣ�����Ҫ����iָ�룬 ���������Ѿ��õ��ġ�����ƥ�䡱�Ľ����ģʽ���ҡ�������������Զ ��һ�ξ���󣬼������бȽϡ�
 * 
 * ʱ�临�Ӷ�O(n+m)
 * 
 * @author wb
 * 
 */
public class KMPTest {
    public static void main(String[] args) {
        String s = "abbabbbbcab"; // ����
        String t = "bbcab"; // ģʽ��
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        System.out.println(KMP_Index(ss, tt)); // KMPƥ���ַ���
    }

    /**
     * ����ַ�����next����ֵ
     * 
     * @param t �ַ���
     * @return next����ֵ
     */
    public static int[] next(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * KMPƥ���ַ���
     * 
     * @param s ����
     * @param t ģʽ��
     * @return ��ƥ��ɹ��������±꣬���򷵻�-1
     */
    public static int KMP_Index(char[] s, char[] t) {
        int[] next = next(t);
        int i = 0;
        int j = 0;
        while (i <= s.length - 1 && j <= t.length - 1) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < t.length) {
            return -1;
        } else
            return i - t.length; // ����ģʽ���������е�ͷ�±�
    }
}
