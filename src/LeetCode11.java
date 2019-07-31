/* ʢ���ˮ������
���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)��
�ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
 */

/* ˫ָ��  O(n)
�ƶ�ָ��϶��߶ε�ָ�뾡������˾��ο�ȵļ�С����ȴ���ܻ����������������
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
