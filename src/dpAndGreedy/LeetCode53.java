package dpAndGreedy;
/* 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                // sum<=0，sum直接更新为当前数字
                sum = num;
            }
            // 此类题的标准动态规划写法
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        LeetCode53 l = new LeetCode53();
        System.out.println(l.maxSubArray(nums));
    }
}
