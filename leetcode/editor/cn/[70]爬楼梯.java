//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3076 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 通过递归方式实现
     *
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

//
//    private Map<Integer, Integer> cash = new HashMap<>();
//
//    /**
//     * 递归+缓存
//     * @param n
//     * @return
//     */
//    public int climbStairs(int n) {
//
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        Integer ressult = cash.get(n);
//        if (null != ressult) {
//            return ressult;
//        }
//        res = climbStairs(n - 1) + climbStairs(n - 2);
//        cash.put(n, ressult);
//        return ressult;
//    }


    private Map<Integer, Integer> cash = new HashMap<>();

    /**
     * 循环处理--自底向上
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // f(2)
        int pre = 2;
        // f(1)
        int prePre = 1;
        int ressult = 0;
        for (int i = 3; i <= n; i++) {
            ressult = pre + prePre;
            prePre = pre;
            pre = ressult;

        }
        return ressult;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
