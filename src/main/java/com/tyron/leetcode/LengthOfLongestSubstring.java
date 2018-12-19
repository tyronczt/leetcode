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
        int length2 = lengthOfLongestSubstring2(str);
        System.out.println(length2);
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
     * 利用滑动窗口的概念，https://github.com/MisterBooo/LeetCodeAnimation中的动画描述的很生动，另外http://www.cnblogs.com/grandyang/p/4480780.html将问题描述得很通透
     * 只需要维护一个的“窗口”，用set来维护。
     * 过程：①窗口从左边界遍历，依次滑动到右边界，一次窗口滑动过程中，分两种情况
     *          1) 下一个字符不包含在窗口中，则左边界不变，扩大右边界；
     *          2) 下一个字符包含在窗口中，将左边界移动到窗口中重复元素的下一个元素，并扩大右边界
     *       ②定义变量保存最长窗口的长度
     *
     * @param str 目标字符串
     * @return 最长窗口的长度
     */
    private static int lengthOfLongestSubstring2(String str) {
        Set<Character> set = new HashSet<Character>();
        // res存放最长窗口长度
        int res = 0, left = 0, right = 0;
        while (right < str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(str.charAt(left++));
            }
        }
        return res;
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
