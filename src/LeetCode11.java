/* 盛最多水的容器
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0)。
找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
 */

/* 双指针  O(n)
移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大
*/
public class LeetCode11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return max;

    }
}
