//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 4060 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 当我们在翻转读到第九位或者第十位的时候，需要判断是否超过int的范围
            // 如果数值大于214748364，如214748365，如果再乘10，那么肯定大于最大值2147483647了，所以会溢出
            // 如果正好等于214748364，那么就需要判断最后的余数了，如果余数比7大，那么就溢出，如果余数小于等于7，那么就未溢出
            // 如果某个数字小于 -214748364说明溢出了，如果再乘10，那么肯定小于最小值-2147483648了，所以会溢出
            // 如果正好等于-214748364，那么就需要判断最后的余数了，如果余数比8大，那么就溢出，如果余数小于等于8，那么就未溢出
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            // 如果正好等于214748364，那么就需要判断最后的余数了，如果余数比7大，那么就溢出，如果余数小于等于7，那么就未溢出
            if (res == Integer.MAX_VALUE / 10 & temp > 7) {
                return 0;
            }
            // 负数最小值
            // 如果正好等于-214748364，那么就需要判断最后的余数了，如果余数比8大，那么就溢出，如果余数小于等于8，那么就未溢出
            if (res == Integer.MIN_VALUE / 10 & temp > 8) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
            
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
