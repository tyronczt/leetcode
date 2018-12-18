package com.tyron.leetcode;

/**
 * @Description: 2. 两数相加
 * @Auther: tyron
 * @Date: 2018/12/18
 */

/**
 * 算法拙笨，看好久才理解题意，更别提解题思路了，现在是将别人的算法理解，讲下思路。
 * 本题关键点：①进位，默认为0，由两数相加所得，除法得进位，模得结果，注意点是最高位的进位；
 * ②循环遍历相加，直到两数的最高位。
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        //测试程序，链表1:1->5->9，链表2：4->5->1 结果：5->0->1->1->
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(5);
        ln1.next.next = new ListNode(9);

        ListNode ln2 = new ListNode(4);
        ln2.next = new ListNode(5);
        ln2.next.next = new ListNode(1);

        ListNode node3 = addTwoNumbers1(ln1, ln2);
        ListNode node4 = addTwoNumbers2(ln1, ln2);

        //打印我们返回的链表结果
        while (node3 != null) {
            System.out.print(node3);
            node3 = node3.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        // 自定义toString方法，便于显示结果

        public String toString() {
            return val + "->";
        }
    }

    /**
     * 思路1：使用遍历的方法
     */
    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 新建头节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        // 进位数
        int carry = 0;
        // 循环两数相加
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 思路2：使用递归的方法
     */
    private static ListNode addTwoNumbers2(ListNode ln1, ListNode ln2) {
        // 节点的子节点
        ListNode temp1 = ln1.next != null ? ln1.next : new ListNode(0);
        ListNode temp2 = ln2.next != null ? ln2.next : new ListNode(0);

        // 获取当前节点的和
        int a = ln1.val;
        int b = ln2.val;
        int sum = a + b;

        // 初始化结果
        ListNode list = new ListNode(sum % 10);

        // 当有进位时,子节点的值加1
        if (sum >= 10) {
            temp1.val++;
        }

        // 当且仅当两数都是最高位且为进位时，返回结果
        if (ln1.next == null && ln2.next == null && sum < 10) {
            return list;
        }

        // 递归计算
        addTwoNumbers2(temp1, temp2);
        return list;
    }
}
