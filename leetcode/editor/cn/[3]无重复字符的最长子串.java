//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10660 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 暴力破解
     * @param s
     * @return
     */
//    public int lengthOfLongestSubstring(String s) {
//
//        int max = 0;
//        // 从第一个字符开始计算，遍历每个字符的最大不重复的子串长度，依次往后遍历
//        for (int i = 0; i < s.length(); i++) {
//            // 采用布尔数组，较少占用的空间，设置300，是因为总共也没有300个字符
//            boolean[] book = new boolean[300];
//            // 第二层循环，遍历截止到出现重复时，就停止遍历
//            for (int j = i; j < s.length(); j++) {
//                if (book[s.charAt(j)]) {
//                    break;
//                }
//                book[s.charAt(j)] = true;
//                max = Math.max(max, j - i + 1);
//            }
//        }
//        return max;
//
//    }

    /**
     * 滑动窗口
     * @apiNote 滑动窗口，就是双指针，一个开始指针（左边界），一个结束指针（右边界）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
//        // 存储每个字符访问过的最后的位置
//        Map<Character, Integer> exitCharMap = new HashMap<>();
//        int max = 0;
//        // 设置起始指针，左边界
//        int start = 0;
//        // 遍历每一个字符---这里i就是右边界
//        for (int i = 0; i < s.length(); i++) {
//            Character s1 = s.charAt(i);
//            // 如果之前已经存在此字符
//            Integer i2 = exitCharMap.get(s1);
//            // 判断此字符是否在新的滑动窗口里面，如果是在新的滑动窗口里面，那么就需要记录当前的最大长度了
//            // 如果此字符，在之前已经滑动过的窗口里面，那么就丢弃，因为前面已经计算过了，此时更新下最新一个字符的下标
//            if (null != i2) {
//                // 判断此字符是否在新的滑动窗口里面，如果是在新的滑动窗口里面，那么就需要记录当前的最大长度了
//                if (i2 >= start) {
//                    // 当前位置（已经是重复的了）-起始位置=当前的长度
//                    if (max < i - start ) {
//                        max = i - start ;
//                    }
//                    // 此时滑动窗口的起始位置，需要设置为重复出现元素的下一个元素（即重复元素后的第一个位置），即调整左边界
//                    start = i2 + 1;
//                }
//            }
//            exitCharMap.put(s1, i);
//        }
//        if (max < s.length() - start) {
//            max = s.length() - start;
//        }

        // 优化后的代码
        Map<Character, Integer> exitCharMap = new HashMap<>();
        int max = 0;
        // i为右边界，尾指针，j为头指针 aab
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (exitCharMap.containsKey(s.charAt(i))) {
                Integer lastIndex = exitCharMap.get(s.charAt(i));
                //调整头指针，即如果这个字符在滑动窗口中出现，那么调整头指针
                j = Math.max(j, lastIndex);
            }
            // 算一下当前字符串的长度，是否大于之前存储的长度，尾指针-头指针+1=长度
            max = Math.max(max, i - j + 1);
            // 设置字符出现的下一个指针
            exitCharMap.put(s.charAt(i), i + 1);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

