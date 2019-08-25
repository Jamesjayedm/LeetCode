package binarysearch;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(logn) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
 */

/*
参考 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int num1 = findLeftBound(nums, target);
        if (num1 == -1)
            return new int[]{-1, -1};
        int num2 = findRightBound(nums, target);
        return new int[]{num1, num2};
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                // 右区间固定，继续向左找
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        // 排除left是length的情况
        if (left == nums.length)
            return -1;
        return nums[left] == target ? left : -1;
    }

    private int findRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid + 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (left == 0)
            return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        LeetCode34 l = new LeetCode34();
        System.out.println(l.findLeftBound(nums, 8));
        System.out.println(l.findRightBound(nums, 8));
        System.out.println(l.searchRange(nums, 8));
    }
}
