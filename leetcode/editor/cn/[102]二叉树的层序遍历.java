//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1577 👎 0


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
    /**
     * 基于队列的实现
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> result = new LinkedList<>();
//        if (root == null) {
//            return result;
//        }
//        // 放入根节点
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            // 获得每层的节点数
//            int levelNodeNum = queue.size();
//            // 每层的结果集
//            List<Integer> subList = new LinkedList<>();
//            // 处理本层的节点，包括数据节点值和将节点的左右子树入队
//            for (int i = 0; i < levelNodeNum; i++) {
//                if (queue.peek().left!=null) queue.offer(queue.peek().left);
//                if (queue.peek().right!=null) queue.offer(queue.peek().right);
//                subList.add(queue.poll().val);
//            }
//            result.add(subList);
//        }
//        return result;
//    }

    /**
     * 基于递归的实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelPreVisit(result, root, 0);
        return result;
    }

    public void levelPreVisit(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        // 新的层需要增加新的子List
        if (height >= result.size()) {
            result.add(new LinkedList<>());
        }
        // 对当前节点的处理需要注意所在的层
        result.get(height).add(root.val);
        levelPreVisit(result, root.left, height + 1);
        levelPreVisit(result, root.right, height + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
