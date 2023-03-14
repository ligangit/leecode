//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2092 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 利用jdk的排序
     * @param nums
     * @param k
     * @return
     */
//    public int findKthLargest(int[] nums, int k) {
//        final int N = nums.length;
//        Arrays.sort(nums);
//        return nums[N - k];
//    }


    /**
     * 基于快速排序的分区实现
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int rigth = len - 1;

        // 转换一下，第k大元素的下标是len-k
        int target = len - k;
        while (true) {
            int index = partition(nums, left, rigth);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                rigth = index - 1;
            }
        }
    }



    /**
     * 利用JDK的优先队列来实现堆排序，进而四线题目的要求
     * JDK中优先队列默认是最小堆，最大堆需要自行实现Comparator
     * @param nums
     * @param k
     * @return
     */
//    public int findKthLargest(int[] nums, int k) {
//        // 使用一个含有k个元素的最小堆
//        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//        for (int i = 0; i < k; i++) {
//            pq.add(nums[i]);
//        }
//        for (int i = k; i < nums.length; i++) {
//            // 获取但并不弹出堆顶元素
//            // 当前遍历的元素比堆顶元素大，当前元素替换堆顶元素
//            if (nums[i] > pq.peek()) {
//                pq.poll();
//                pq.offer(nums[i]);
//            }
//        }
//        return pq.peek();
//    }



    /**
     * 利用最大堆实现
     * @param nums
     * @param k
     * @return
     */
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        // 构建一个最大堆
//        buildMaxHeap(nums, len);
//        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//            swap(nums, 0, i);
//            --len;
//            adjustHeap(nums, 0, len);
//        }
//        return nums[0];
//    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 快速排序分区
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] array, int start, int end) {
        if (start == end) {
            return start;
        }
        // 随机选取一个基准数
        int pivot = (int) (start + Math.random() * (end - start + 1));

        // zoneIndex是分区指示器，初始值为分区头元素下标减一
        int zoneIndex = start - 1;
        // 将基准数和分区尾元素交换位置
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            // 当前元素小于等于基准数
            if (array[i] <= array[end]) {
                // 首先分区指示器累加
                zoneIndex++;
                // 当前元素在分区指示器的右边是，交换当前元素和分区指示器元素
                if (i > zoneIndex) {
                    swap(array, i, zoneIndex);
                }
            }
        }
        return zoneIndex;
    }

    public void buildMaxHeap(int[] array,int heapSize) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (heapSize / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i, heapSize);
        }
    }

    public void adjustHeap(int[] array, int i,int heapSize) {
        int maxIndex = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (left < heapSize && array[left] > array[maxIndex]) {
            maxIndex = left;
        }
        // 如果有右子树，且右子树大于父节点且大于左子树，则将最大指正指向右子树
        if (right < heapSize && array[right] > array[maxIndex] && array[right] > array[left]) {
            maxIndex = right;
        }
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex, heapSize);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
