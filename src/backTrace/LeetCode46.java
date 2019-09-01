package backTrace;

/* 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
 */

/*
https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */

/* 回溯法
回溯法的经典题目，可以作为模板使用

 */

import java.util.ArrayList;
import java.util.List;


public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        backTrace(nums, isVisited, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTrace(int[] nums, boolean[] isVisited, int cur, ArrayList<Integer> path, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                path.add(nums[i]);
                isVisited[i] = true;  // 选了一个元素，我们就得“标记一下”，表示占位。
                backTrace(nums, isVisited, cur + 1, path, result);
                /* 在程序执行到上面这棵树的叶子结点的时候，此时递归到底，当前根结点到叶子结点走过的路径就构成一个全排列，把它加入结果集，我把这一步称之为“结算”。
                此时递归方法要返回了，对于方法返回以后，要做两件事情：
                （1）释放对最后一个数的占用；
                （2）将最后一个数从当前选取的排列中弹出。*/
                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        LeetCode46 l = new LeetCode46();
        List<List<Integer>> permute = l.permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }


}
