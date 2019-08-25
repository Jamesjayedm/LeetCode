/* 缺失的第一个正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */

/*
https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/

 */

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        /* 1.使用hashmap保存，但是空间为O(n)，不符合题意
        if (nums.length == 0)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                map.put(nums[i], 1);
            }
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 1;*/

        /* 2.桶排序，原地排序，不消耗额外空间
        // 关键字：桶排序，什么数字就要放在对应的索引上，其它空着就空着
        // 最好的例子：[3,4,-1,1]
        // 整理好应该是这样：[1,-1,3,4]，
        // 这里 1，3，4 都在正确的位置上，
        // -1 不在正确的位置上，索引是 1 ，所以返回 2

        // [4,3,2,1] 要变成 [1,2,3,4]，*** Offer 上有类似的问题。

        // 这里负数和大于数组长度的数都是"捣乱项"。
         */
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] num = {-1, 4, 2, 1, 9, 10};
//        int[] num = {7, 9, 8, 10, 12};
        LeetCode41 l = new LeetCode41();
        System.out.println(l.firstMissingPositive(num));
    }
}
