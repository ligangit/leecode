//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2879 👎 0


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
    /**
     * 循环+双指针解决方式
     * @param list1
     * @param list2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (null == list1) {
//            return list2;
//        }
//        if (null == list2) {
//            return list1;
//        }
//        ListNode resultNode = new ListNode(0);
//        ListNode p = resultNode;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                p.next = list1;
//                list1 = list1.next;
//            } else {
//                p.next = list2;
//                list2 = list2.next;
//            }
//            p = p.next;
//        }
//        if (null != list1) {
//            p.next = list1;
//        } else if (null != list2) {
//            p.next = list2;
//        }
//        return resultNode.next;
//
//    }

    /**
     * 递归解决
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
