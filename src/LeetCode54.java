import java.util.ArrayList;
import java.util.List;
/* 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

/* 螺旋矩阵巧妙解法，利用四条边的边界来判断是否已经结束，每遍历一行或一列就改变边界值。
1.首先设定上下左右边界
2.其次向右移动到最右，此时第一行因为已经使用过了，可以将其从图中删去，体现在代码中就是重新定义上边界
3.判断若重新定义后，上下边界交错，表明螺旋矩阵遍历结束，跳出循环，返回答案
4.若上下边界不交错，则遍历还未结束，接着向下向左向上移动，操作过程与第一，二步同理
5.不断循环以上步骤，直到某两条边界交错，跳出循环，返回答案

 */

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++)
                result.add(matrix[up][i]);
            if (++up > down)
                break;
            for (int i = up; i <= down; i++)
                result.add(matrix[i][right]);
            if (--right < left)
                break;
            for (int i = right; i >= left; i--)
                result.add(matrix[down][i]);
            if (--down < up)
                break;
            for (int i = down; i >= up; i--)
                result.add(matrix[i][left]);
            if (++left > right)
                break;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {};
        LeetCode54 l = new LeetCode54();
        List<Integer> list = l.spiralOrder(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
