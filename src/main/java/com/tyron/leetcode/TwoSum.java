package com.tyron.leetcode;

/**
 * @Description: 1、两数之和
 *
 * @Auther: tyron
 * @Date: 2018/12/12
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum1(nums, target);
        if (result != null) {
            System.out.println("result: [" + result[0] + " ," + result[1] + "]");
        }
    }

    private static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
