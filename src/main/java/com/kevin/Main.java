package com.kevin;

import java.io.UnsupportedEncodingException;

/**
 * 类名: Main<br/>
 * 包名：com.kevin<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/22 10:09<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class Main {

    private static final String GBK = "GBK";

    public static int isGbkEncoded(String str) {
        return isSomeEncoded(str, GBK);
    }

    public static int isSomeEncoded(String str, String charset) {
        String[] strs = str.split("");
        for (int i = 0; i < strs.length; i++) {
            try {
                if (!strs[i].equals(new String(strs[i].getBytes(charset), charset))) {
                    return i;
                }
            } catch (UnsupportedEncodingException e) {
                // 未知字符集
            }
        }
        return -1;
    }

    public static String string2Unicode(String str) {
        StringBuffer unicode = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            unicode.append("\\u" + Integer.toHexString(ch));
        }
        return unicode.toString();
    }

    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        System.out.println(string2Unicode("丂"));
        System.out.println(unicode2String("\\u4FA1"));
        System.out.println(isGbkEncoded("（财经•动态）大盘继续走升 上证综指收复3150点"));
        System.out.println(isGbkEncoded("（医卫）异地就医不用来回跑&nbsp;江苏推行“不见面备案”"));
    }
}
