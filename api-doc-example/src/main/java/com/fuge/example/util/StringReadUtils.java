package com.fuge.example.util;

/**
 * @author wangdingfu
 * @descption: String解析工具类
 * @date 2022-04-24 13:03:11
 */
public class StringReadUtils {

    public static void main(String[] args) {
        String comment = "/**\n" +
                "     * 注释解析\n" +
                "     *\n" +
                "     * @param psiDocComment intellij 描述的注释对象\n" +
                "     * @return 结构化的注释对象\n" +
                "     */";
        int i = 0, length = comment.length();
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            char charAt = comment.charAt(i);
            if (charAt == 10) {
                System.out.println(sb);
                sb = new StringBuilder();
            } else {
                sb.append(charAt);
            }
            i++;
        }
    }

}
