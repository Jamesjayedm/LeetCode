package dpAndGreedy;

/* 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:
可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 */

import java.util.Arrays;
import java.util.Comparator;

/*
贪心策略，先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
在每次选择中，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
按区间的结尾进行升序排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 */
public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 把结尾小的放在前面，先删除
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        LeetCode435 solution = new LeetCode435();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
