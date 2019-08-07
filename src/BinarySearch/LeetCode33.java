package BinarySearch;
/* 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(logn) 级别。

示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

 */

/* 两次二分法
1.先利用二分法找到旋转的下标 rotationIndex ，也就是数组中最小的元素。
2.将原数组分为两部分，在选中的数组区域中再次使用二分查找。
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        // 找到旋转点，在左边和右边分别进行寻找
        int rotateIndex = findRotateIndex(0, nums.length - 1, nums);
        if (rotateIndex == 0) {
            return search(0, nums.length - 1, nums, target);
        }
        if (target == nums[rotateIndex]) {
            return rotateIndex;
        } else if (target < nums[0]) {
            return search(rotateIndex, nums.length - 1, nums, target);
        } else {
            return search(0, rotateIndex - 1, nums, target);
        }

    }

    private int search(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    /**
     * 找到旋转点
     *
     * @param left
     * @param right
     * @param nums
     * @return
     */
    private int findRotateIndex(int left, int right, int[] nums) {
        if (nums[left] < nums[right])
            return 0;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode33 l = new LeetCode33();
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {1, 3};
        System.out.println(l.search(nums, 3));
    }
}
