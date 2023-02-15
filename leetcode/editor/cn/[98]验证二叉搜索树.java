//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1888 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public boolean isValidBST(TreeNode root) {
      return  isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//      return  isValidBSTOrderBWithStack(root);
    }

    /**
     * 基于二叉搜索树定义/性质实现
     * @param root
     * @param minVal
     * @param maxVal
     * @return
     */
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        // 根节点为null，或者递归到了叶子节点，所以需要终止递归
        if (root == null) {
            return true;
        }
        // 节点不满足二叉搜索树定义，直接返回false
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        // 对当前节点下的左右子树递归去判断，变化左子树的最大范围和右子树的最小范围
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    /**
     * 基于中序遍历的栈实现
     * @param root
     * @return
     */
    public boolean isValidBSTOrderBWithStack(TreeNode root) {
        // 根节点为null，或者递归到了叶子节点，所以需要终止递归
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        // 用来存储前一个节点的值
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root=stack.pop();
            // 如果当前节点的值不大于前一个节点的值，不符合二叉搜索树定义
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
