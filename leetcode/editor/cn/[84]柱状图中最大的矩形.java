//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2314 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
//    public int largestRectangleArea(int[] heights) {
//        if (null == heights) {
//            return 0;
//        }
//        if (1 == heights.length) {
//            return heights[0];
//        }
//        int result = 0;
//        Deque<Integer> stack = new LinkedList<>();
//        // 遍历数组
//        for (int i = 0; i < heights.length; i++) {
//            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
//                // 当前需要计算面积的元素的下标
//                int curIndex = stack.pollLast();
//                // 获取当前元素的值，也就是矩形的高
//                int curHeight = heights[curIndex];
//                // 计算矩形的宽
//                int curWidth;
//                if (stack.isEmpty()) {
//                    // 栈为空，表示目前所遍历的元素都比当前的i要大，i是最小的一个
//                    curWidth = i;
//                } else {
//                    curWidth = i - stack.peekLast() - 1;
//                }
//                result = Math.max(result, curHeight * curWidth);
//
//            }
//            stack.addLast(i);
//        }
//        // 处理目前还在栈中的的元素
//        while (!stack.isEmpty()) {
//            int curHeight = heights[stack.pollLast()];
//            int curWidth;
//            if (stack.isEmpty()) {
//                curWidth = heights.length;
//            } else {
//                curWidth = heights.length - stack.peekLast() - 1;
//            }
//            result = Math.max(result, curHeight * curWidth);
//        }
//        return result;
//    }

    /**
     * 数组
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        // 存放元素右侧和左侧仅次于当前元素高度（或相同高度）的邻居元素下标的数组
        int[] leftLower = new int[heights.length];
        int[] rigthLower = new int[heights.length];
        // 初始化
        rigthLower[heights.length - 1] = heights.length;
        leftLower[0] = -1;

        // 正序遍历，对当前元素寻找左侧第一个小于当前元素高度（或相同高度）的邻居元素
        for (int i = 1; i < heights.length; i++) {
            // 从当前元素左侧第一个邻居元素开始，往左侧寻找
            int neighbourLeft = i - 1;
            // 不断的往左寻找，一直到数组或者左侧第一个小于当前元素的邻居元素为止
            while (neighbourLeft >= 0 && heights[neighbourLeft] >= heights[i]) {
                /*在我们的遍历过程中，当前元素的所有左侧元素我们已经处理过了
                * 那就是说我们可以重用先前计算的结果快速跳转，比如数组
                * {3,6,5,7,8,1,0}
                * 假如当前元素是下标为4的元素4，很明显，前面的3,6,5,7都已经处理过，
                * leftLower=[-1,0,0,2,0,0,0,0]
                * 7会被5卡主，5和6都会被3卡住，4比7、5、6都小，
                * 可以快速到达5或6被卡主的地方判断4会不会也被卡住，
                * neighbourLeft的变化将是(4-1)3  --> 2=leftLower[3]  -->  0=leftLower[2]
                * 而heights[0]<heights[4]，退出循环，最终 leftLower[4]=0
                * */
                neighbourLeft = leftLower[neighbourLeft];
            }
            leftLower[i] = neighbourLeft;
        }

        // 逆序遍历，对当前元素寻找右侧第一个小于当前元素高度（或相同高度）的邻居元素
        // 思想和上面的正序遍历一样
        for (int i = heights.length - 2; i >= 0; i--) {
            // 从当前元素左侧第一个邻居元素开始，往左侧寻找
            int neighbourRight = i + 1;
            // 不断的往左寻找，一直到数组或者左侧第一个小于当前元素的邻居元素为止
            while (neighbourRight < heights.length && heights[neighbourRight] >= heights[i]) {

                neighbourRight = rigthLower[neighbourRight];
            }
            rigthLower[i] = neighbourRight;
        }

        // 已经找到了所有元素对应的邻居元素，寻找最大的那个
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rigthLower[i] - leftLower[i] - 1));
        }
        return maxArea;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
