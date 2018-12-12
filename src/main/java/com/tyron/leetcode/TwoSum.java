package com.tyron.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1、两数之和
 * @Auther: tyron
 * @Date: 2018/12/12
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result1 = twoSum1(nums, target);
        if (result1 != null) {
            System.out.println("result1: [" + result1[0] + " ," + result1[1] + "]");
        }
        int[] result2 = twoSum2(nums, target);
        if (result2 != null) {
            System.out.println("result2: [" + result2[0] + " ," + result2[1] + "]");
        }
        int[] result3 = twoSum3(nums, target);
        if (result3 != null) {
            System.out.println("result3: [" + result3[0] + " ," + result3[1] + "]");
        }
    }

    /**
     * 第一种思路：直截了当，两次循环，当且仅当两个值相等时返回数组下标
     */
    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 第二种思路：两遍哈希表，将值作为key，将数组下标作为value，当两个key相加为target时，返回两个key的value值
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[]{i, map.get(remainder)};
            }
        }
        return null;
    }

    /**
     * 第三种思路：一遍哈希表，边存边判断，以值为key，索引为value，先将结果中第一个数放入map中，仅当结果中的第二个数放入时，才会满足条件
     */
    private static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                return new int[]{map.get(remainder), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
