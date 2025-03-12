//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        // 每一行，直接存储那一列的数据，二维数组中间没有空元素，存储每个字符在字符串的下标
        int[][] result = new int[numRows + 1][length + 1];
        int pos = 1, add = 1;// pos表示当前所在的行数，add表示增量
        for (int i = 0; i < s.length(); i++) {
            if (pos == 1) {
                // 增量变化
                add = 1;
            } else {
                if (pos == numRows) {
                    add = -1;
                }
            }
            // ++result[pos][0] 取出第一列数之后，自增，再塞回去，这一样就记录了每一行有多少个字符了
            result[pos][++result[pos][0]] = i;
            pos = pos + add;
        }

        StringBuffer sb = new StringBuffer();

        for (int i1 = 1; i1 <= numRows; i1++) {
            for (int j1 = 1; j1 <= result[i1][0]; j1++) {
                sb.append(s.charAt(result[i1][j1]));
            }
        }

        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
