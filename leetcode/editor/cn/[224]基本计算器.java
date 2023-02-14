//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 866 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        // 存放当前的计算结果
        int result = 0;
        // 粗放当前待计算数字
        int num = 0;
        // 符号，加号(+1)或者减号(-1)
        int sign = 1;
        Deque<Integer> stack = new LinkedList<Integer>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            // 如果当前符号为‘ ’，无需处理
            if (c == ' ') {
                continue;
            }
            // 如果当前字符串是一个数字，则用num进行记录，当然需要考虑到数字不止一位，所以 num=num*10+c-'c'
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                // 判断当前数字是否已取完，只要后续字符在‘0’到‘9’之间，说明当前数字还未结束
                if (i < len - 1 && '0' <= chars[i + 1] && chars[i + 1] <= '9') {
                    continue;
                }
                // 如果当前字符为计算符号
            } else if (c == '+' || c == '-') {
                num = 0;
                sign = c == '+' ? 1 : -1;
                // 如果当前字符为'('，需要将前面的计算结果和符号入栈
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                // 如果当前字符为')'，括号里的表达式已经计算完成了，可以和括号外的结果进行合并计算了
            } else if (c == ')') {
                // ‘(’前边的符号出栈
                sign = stack.pop();
                // 将num替换为括号中的计算结果
                num = result;
                // 将result替换为括号前边的计算结果
                result = stack.pop();
            }
            // 每循环一次，得到一个新的结果
            result += sign * num;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
