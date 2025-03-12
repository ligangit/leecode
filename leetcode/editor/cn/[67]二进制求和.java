//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {

        // 方式一：遍历字符串转char计算
//        char[] charArrayLong = a.toCharArray();
//        char[] charArrayShort = b.toCharArray();
//        char[] resultArray;
//        if (a.length() >= b.length()) {
//            resultArray = new char[a.length()];
//            charArrayLong = a.toCharArray();
//            charArrayShort = b.toCharArray();
//
//        }else {
//            resultArray = new char[b.length()];
//            charArrayLong = b.toCharArray();
//            charArrayShort = a.toCharArray();
//        }
//        String temp = "0";
//        for (int i = charArrayLong.length - 1; i >= 0; i--) {
//            // 计算对应短字符串位置的下标
//            int j = charArrayShort.length + i - charArrayLong.length;
//            int he = Integer.valueOf(temp) + Integer.valueOf(String.valueOf(charArrayLong[i]));
//            if (j >= 0) {
//                he = he + Integer.valueOf(String.valueOf(charArrayShort[j]));
//            }
//            if (he == 2) {
//                temp = "1";
//                he = 0;
//            } else if (he == 3) {
//                temp = "1";
//                he = 1;
//            } else {
//                temp = "0";
//            }
//            resultArray[i] = (char) (he + '0');
//        }
//        String s = new String(resultArray);
//        if (temp.equals("1")) {
//            s = temp + s;
//        }
//        return s;
        // 方式二：倒叙遍历按位计算，处理升位问题，最终把结果倒叙一下
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = temp;
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }
            stringBuilder.append(sum % 2);
            temp = sum / 2;
        }
        if (temp > 0) {
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

