package sort;

/*数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class LeetCode215 {
    // 1.堆排序实现
    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //java默认为小顶堆，保持堆的大小小于等于k，所以堆顶就是所求
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }*/

    // 2.快排实现
    public int findKthLargest(int[] nums, int k) {
        // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    public int findKthLargest(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high, k);
        if (index == k)
            return nums[index];
        else if (index > k)
            return findKthLargest(nums, low, index - 1, k);
        else
            return findKthLargest(nums, index + 1, high, k);
    }

    // 同快排的partation,每次确定一个枢轴的位置,并返回其index
    // 找第k 大 的数就把数组按大->小排列
    private int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[low];

        while (low < high) {
            while (low < high && nums[high] <= pivot) // nums[high]<=pivot 体现出把数组按大->小排列
                high--;
            nums[low] = nums[high];

            while (low < high && nums[low] >= pivot)
                low++;
            nums[high] = nums[low];
        }

        nums[low] = pivot;
        return low;
    }

}
