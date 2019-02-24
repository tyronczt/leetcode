package com.tyron.leetcode;

/**
 * @Description: 寻找两个有序数组的中位数 [要求算法的时间复杂度为 O(log(m + n))]
 * @Author: tyron
 * @date: 2019/2/23
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 9, 10};
        int[] nums2 = {5, 6};
        double medianSortedArrays1 = findMedianSortedArrays1(nums1, nums2);
        double medianSortedArrays2 = findMedianSortedArrays2(nums1, nums2);
        double medianSortedArrays3 = findMedianSortedArrays3(nums1, nums2);
        System.out.println("findMedianSortedArrays1：" + medianSortedArrays1);
        System.out.println("findMedianSortedArrays2：" + medianSortedArrays2);
        System.out.println("findMedianSortedArrays3：" + medianSortedArrays3);
    }

    /**
     * 方法1、合并两有序数组成一个新有序数组，再按中间位置取值
     * 时间复杂度为O(n+m)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     */
    private static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthAll = length1 + length2;
        int[] all = new int[lengthAll];
        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                all[k] = nums1[i];
                i++;
                k++;
            } else {
                all[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < length1) {
            all[k] = nums1[i];
            i++;
            k++;
        }
        while (j < length2) {
            all[k] = nums2[j];
            j++;
            k++;
        }

        double result;
        if (lengthAll % 2 == 0) {
            result = (all[lengthAll / 2 - 1] + all[lengthAll / 2]) * 1.0 / 2;
        } else {
            result = all[lengthAll / 2];
        }
        return result;
    }

    /**
     * 方法2：两个指针分别从两数组开头指，比较两指针处的数，谁小谁往后移，直到两指针共移动k次，k为中间位置
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    private static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthall = length1 + length2;

        int inx1 = 0;
        int inx2 = 0;
        int x = -1;
        int y = -1;

        while (inx1 + inx2 < lengthall) {
            if (inx1 < length1) {
                while (inx2 == length2 || nums1[inx1] <= nums2[inx2]) {
                    inx1++;
                    if (inx1 + inx2 == (lengthall + 1) / 2) {
                        x = nums1[inx1 - 1];
                    }
                    if (inx1 + inx2 == (lengthall + 2) / 2) {
                        y = nums1[inx1 - 1];
                        return (x + y) * 1.0 / 2;
                    }
                    if (inx1 == length1) {
                        break;
                    }
                }
            }
            if (inx2 < length2) {
                while (inx1 == length1 || nums2[inx2] <= nums1[inx1]) {
                    inx2++;
                    if (inx1 + inx2 == (lengthall + 1) / 2) {
                        x = nums2[inx2 - 1];
                    }
                    if (inx1 + inx2 == (lengthall + 2) / 2) {
                        y = nums2[inx2 - 1];
                        return (x + y) * 1.0 / 2;
                    }
                    if (inx2 == length2) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 方法3：两个数组分别采用二分法查找
     * 时间复杂度：O(log(m+n))
     *
     * @param nums1 数组1
     * @param nums2 数组2
     */
    private static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthAll = length1 + length2;
        int l = (lengthAll + 1) / 2;
        int r = (lengthAll + 2) / 2;

        return (getKMin(nums1, 0, nums2, 0, l) + getKMin(nums1, 0, nums2, 0, r)) * 1.0 / 2;
    }

    public static int getKMin(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart > A.length - 1) {
            return B[Bstart + k - 1];
        }
        if (Bstart > B.length - 1) {
            return A[Astart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }

        int Amin = Integer.MAX_VALUE, Bmin = Integer.MAX_VALUE;
        if (Astart + k / 2 - 1 < A.length) {
            Amin = A[Astart + k / 2 - 1];
        }
        if (Bstart + k / 2 - 1 < B.length) {
            Bmin = B[Bstart + k / 2 - 1];
        }

        return Amin < Bmin ? getKMin(A, Astart + k / 2, B, Bstart, k - k / 2) : getKMin(A, Astart, B, Bstart + k / 2, k - k / 2);
    }

}
