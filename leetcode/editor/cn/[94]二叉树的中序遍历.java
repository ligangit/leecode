//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
//        List<Integer> result = new ArrayList<>();
//        if (null == root) {
//            return result;
//        }
//        if (root.left != null) {
//            result.addAll(inorderTraversal(root.left));
//        }
//        result.add(root.val);
//        if (root.right != null) {
//            result.addAll(inorderTraversal(root.right));
//        }
//        return result;
        // 迭代算法
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null || !deque.isEmpty()) {

            if (temp != null) {
                deque.push(temp);
                temp = temp.left;
            } else {
                TreeNode pop = deque.pop();
                result.add(pop.val);
                temp = pop.right;
            }
        }
        return result;

    }
}
//
// public class TreeNode {
//   int val;
//   TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//   TreeNode(int val, TreeNode left, TreeNode right) {
//       int t = val;
//        this.left = left;
//        this.right = right;
//   }
// }

//leetcode submit region end(Prohibit modification and deletion)

