package com.tyron.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desription 3. 无重复字符的最长子串
 * @Author: TyronChen
 * @Date: Created in 2018-12-18
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) throws Exception {
        String str = "abaaddcabscs";
        int length1 = lengthOfLongestSubstring1(str);
        System.out.println(length1);
    }

    /**
     * 粗暴解决方案：将字符串包含的所有子字符串取出，并判断子字符串中是否有重复元素，从所有无重复字符的子串中取出最长的
     * 状态：超出时间限制 ----> 代码还需要优化
     */
    private static int lengthOfLongestSubstring1(String str) {
        if (str == null) {
            return 0;
        }
        // 最长子串的长度
        int maxLength = 0;
        String maxStr = "";
        // 字符串长度
        int strLength = str.length();
        // 重复循环遍历
        for (int i = 0; i < strLength; i++) {
            for (int j = i + 1; j <= strLength; j++) {
                // 当子串中无重复元素时，比较较大者长度，最后得到子串的最长长度
                if (ifRepeatElement(str, i, j)) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    /**
     * 判断字符串是否有重复元素，遍历元素，放入set中，放入前先判断是否有该元素，如有则返回false。
     *
     * @param str   需判断字符串
     * @param start 起始索引
     * @param end   结束索引
     * @return true表示无重复元素
     */
    private static boolean ifRepeatElement(String str, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            Character ch = str.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
