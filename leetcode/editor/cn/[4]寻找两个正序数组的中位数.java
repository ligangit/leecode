//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7360 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = mergeArrays(nums1, nums2);
        if (ints.length % 2 == 0) {
            return (ints[ints.length / 2 - 1] + ints[ints.length / 2]) / 2.0;
        }
        return ints[ints.length / 2];
    }

    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (i < ints.length) {
            if (index1 >= nums1.length) {
                ints[i] = nums2[index2];
                index2++;
                i++;
                continue;
            }
            if (index2 >= nums2.length) {
                ints[i] = nums1[index1];
                index1++;
                i++;
                continue;
            }
            if (nums1[index1] <= nums2[index2]) {
                ints[i] = nums1[index1];
                index1++;
            } else {
                ints[i] = nums2[index2];
                index2++;
            }
            i++;
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

