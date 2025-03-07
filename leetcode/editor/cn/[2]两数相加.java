//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 11017 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 循环遍历
        ListNode temp = new ListNode(0);
        // 返回值指向头结点
        ListNode res = temp;
        ListNode p = l1;
        ListNode q = l2;
        int tempval = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            tempval += x + y;
            temp.next = new ListNode(tempval % 10);
            tempval = tempval / 10;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
            // 不断的往后面添加节点
            temp = temp.next;
        }
        if (tempval > 0) {
            temp.next = new ListNode(tempval % 10);
        }
        return res.next;

        // 下面是递归的形式实现
//        return addTwoNumbers(0, l1, l2);
    }
//
//    public ListNode addTwoNumbers(int temp, ListNode l1, ListNode l2) {
//        if (null == l1 && null == l2 && temp <= 0) {
//            return null;
//        }
//        ListNode result = new ListNode();
//        int h = temp;
//        if (null != l1) {
//            h = h + l1.val;
//        }
//        if (null != l2) {
//            h = h + l2.val;
//        }
//        temp = h / 10;
//        h = h % 10;
//        result.val = h;
//        result.next = addTwoNumbers(temp, null == l1 ? null : l1.next, null == l2 ? null : l2.next);
//        return result;
//    }
}
//
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

//leetcode submit region end(Prohibit modification and deletion)

