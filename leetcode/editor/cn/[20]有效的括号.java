//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "()" 
// 
//
// 输出：true 
//
// 示例 2： 
//
// 
// 输入：s = "()[]{}" 
// 
//
// 输出：true 
//
// 示例 3： 
//
// 
// 输入：s = "(]" 
// 
//
// 输出：false 
//
// 示例 4： 
//
// 
// 输入：s = "([])" 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4614 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        // 添加一个问号，这样避免pop()时弹出空值
        stack.push('?');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
                continue;
            }
            if ((aChar == ')')) {
                Character pop = stack.pop();
                if ('(' == pop) {
                    continue;
                } else {
                    return false;
                }
            }
            if (aChar == ']') {
                Character pop = stack.pop();
                if ('['==pop) {
                    continue;
                } else {
                    return false;
                }
            }
            if (aChar == '}') {
                Character pop = stack.pop();
                if ('{'==pop) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 1) {
            return true;
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

