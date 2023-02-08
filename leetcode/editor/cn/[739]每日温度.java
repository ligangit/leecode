//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1393 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 暴力穷举
     * @param temperatures
     * @return
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//
//        int[] result = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length-1; i++) {
//            int day = 0;
//            boolean has = false;
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[j] <= temperatures[i]) {
//                    day++;
//                } else {
//                    day++;
//                    has = true;
//                    break;
//                }
//            }
//            if (!has) {
//                day = 0;
//            }
//            result[i] = day;
//        }
//        result[result.length-1] = 0;
//        return result;
//    }

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        // 单调栈
//        Deque<Integer> stack = new LinkedList<>();
//        int[] result = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            // 如果栈为空，或者当前元素大于栈顶元素，栈顶元素出栈，间隔天数就是当前元素下标减栈顶元素下标
//            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
//                int idx = stack.pop();
//                result[idx] = i - idx;
//            }
//            // 压栈
//            stack.push(i);
//        }
//
//        return result;
//    }


    /**
     * 倒序数组 循环次数多
     *
     * @param temperatures
     * @return
     */
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] result = new int[temperatures.length];
//        // 从右向左遍历，数组最后一个元素无需处理
//        for (int i = temperatures.length - 2; i >= 0; i--) {
//            int idx = i + 1;
//            while (temperatures[i] >= temperatures[idx]) {
//                int g = result[idx];
//                if (0 == g) {
//                    idx = i;
//                    break;
//                }
//                idx = idx + g;
//            }
//            result[i] = idx - i;
//
//        }
//
//        return result;
//    }


    /**
     * 倒序数组 更优解
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // 从右向左遍历，数组最后一个元素无需处理
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int idx = i + 1;
            // backIdx表示当前元素开始往后寻找获得需要的结果； backIdx = backIdx + result[backIdx]是为了利用已有结果进行跳跃
            for (int backIdx = i + 1; backIdx < result.length; backIdx = backIdx + result[backIdx]) {
                if (temperatures[backIdx] > temperatures[i]) {
                    result[i] = backIdx - i;
                    break;
                    // 遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                } else if (result[backIdx] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
