//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2867 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 递归的方式
//        return isSame(root.left, root.right);

        // 栈的方式
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        // 同时把左右节点放入栈中
        TreeNode left;
        TreeNode right;
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            // 都是空，那么就是true，对比下一个元素
            if (right == null && left == null) {
                continue;
            }
            // 一个为空，一个有值，那么就是不一样的
            if (right == null || left == null) {
                return false;
            }
            // 值不一样，那么也是不对称的
            if (right.val != left.val) {
                return false;
            }
            // 需要同时塞入当前对称位置的节点
            // 把当前左节点的左节点放入栈
            stack.push(left.left);
            // 把当前右节点的右节点放入栈
            stack.push(right.right);

            // 把当前左节点的右节点放入栈
            stack.push(left.right);
            // 把当前右节点的左节点放入栈
            stack.push(right.left);
        }
        return true;
    }
//
//    public boolean isSame(TreeNode p, TreeNode q) {
//        if (null == p && null == q) {
//            return true;
//        }
//        if (null == p || null == q) {
//            return false;
//        }
//        if (p.val != q.val) {
//            return false;
//        }
//        return isSame(p.right, q.left) && isSame(p.left, q.right);
//
//    }

}

 public class TreeNode {
   int val;
   TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       int t = val;
        this.left = left;
        this.right = right;
   }
 }
//leetcode submit region end(Prohibit modification and deletion)

