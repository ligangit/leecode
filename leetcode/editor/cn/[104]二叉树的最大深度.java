//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1915 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
//        // 方式一：利用栈遍历每个节点，map存储每个节点的深度
//        Map<TreeNode, Integer> treeDepth = new HashMap<>();
//        treeDepth.put(root, 1);
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        int maxDepth = 0;
//        while (!stack.isEmpty()) {
//            // 弹出栈中的节点
//            TreeNode pop = stack.pop();
//            Integer depth = treeDepth.get(pop);
//            if (pop.left != null) {
//                stack.push(pop.left);
//                treeDepth.put(pop.left, depth + 1);
//            }
//            if (pop.right != null) {
//                stack.push(pop.right);
//                treeDepth.put(pop.right, depth + 1);
//            }
//            if (depth > maxDepth) {
//                maxDepth = depth;
//            }
//        }
//        return maxDepth;

        // 方式二：递归的方式
        return maxDepth(root, 0);

    }

    private int maxDepth(TreeNode root, int depth) {
        if (null == root) {
            return depth;
        }
        if (root.left == null && root.right == null) {
            return depth + 1;
        }
        int left = maxDepth(root.left, depth + 1);
        int right = maxDepth(root.right, depth + 1);
        if (left > right) {
            return left;
        }
        return right;
    }
}

//
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

//leetcode submit region end(Prohibit modification and deletion)

