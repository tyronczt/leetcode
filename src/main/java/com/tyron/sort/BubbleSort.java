package com.tyron.sort;

/**
 * @Description: 冒泡排序（Bubble Sort）
 * @Author: tyron
 * @date: 2018/12/20
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 待排序数组
        int[] arr_one = {5, 17, 9, 12, 11, 45, 1, 51, 111, 245, 4, 5, 45, 45, 314, 456};
        // 冒泡排序（一）
        int count_one = bubbleSort_one(arr_one);
        // 输出次数
        System.out.println("方法一排序次数：" + count_one);
        // 输出数组
        printArr(arr_one);

        System.out.println("");
        // 待排序数组
        int[] arr_two = {5, 17, 9, 12, 11, 45, 1, 51, 111, 245, 4, 5, 45, 45, 414, 456};
        // 冒泡排序（二）
        int count_two = bubbleSort_two(arr_two);
        // 输出次数
        System.out.println("方法二排序次数：" + count_two);
        // 输出数组
        printArr(arr_two);
    }

    /**
     * 输出数组
     *
     * @param arr 目标数组
     */
    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 定义描述：
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 以从小到大排序为例，每一轮排序就找出未排序序列中最大值放在最后。
     * <p>
     * 算法描述：
     * Ⅰ.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * Ⅱ.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * Ⅲ.针对所有的元素重复以上的步骤，除了最后一个；
     * Ⅳ.重复步骤1~3，直到排序完成。
     */

    /**
     * 根据冒泡排序的基本思想，得到方法一的冒泡排序
     */
    private static int bubbleSort_one(int[] arr) {
        // 用于记录排序的次数
        int count = 0;
        int len = arr.length;
        // 表示len次排序过程
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                count++;
                // 从小到大排序
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return count;
    }

    /**
     * 针对待排序数组中有部分已经排好序的数组进行代码优化
     */
    private static int bubbleSort_two(int[] arr) {
        int count = 0;
        int len = arr.length;
        int j, k = len;
        // 发生了交换就为true, 没发生就为false，第一次判断时必须标志位true
        boolean flag = true;
        while (flag) {
            // 默认false，表示未排序
            flag = false;
            for (j = 0; j < k - 1; j++) {
                count++;
                // 前面的数字大于后面的数字就交换
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            //减小一次排序的尾边界
            k--;
        }
        return count;
    }
}

/**
 * 输出结果
 * <p>
 * 方法一排序次数：120
 * 1 4 5 5 9 11 12 17 45 45 45 51 111 245 314 456
 * 方法二排序次数：105
 * 1 4 5 5 9 11 12 17 45 45 45 51 111 245 314 456
 */
