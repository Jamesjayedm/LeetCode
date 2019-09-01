package backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 全排列（包含重复数字）
给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */

/* 回溯+剪枝
https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序后才能发现相同元素
        Arrays.sort(nums);
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
                /*
                如果这个数和之前的数一样，并且之前的数还未使用过，那接下来如果走这个分支，就会使用到之前那个和当前一样的数，就会发生重复，此时分支和之前的分支一模一样。
                和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支，这种情况只要跳过即可
                只有isVisited[i - 1] == true的情况，也就是保留了第一个分支
                 */
                if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                isVisited[i] = true;
                backTrace(nums, isVisited, cur + 1, path, result);
                path.remove(path.size() - 1);
                isVisited[i] = false;

            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        LeetCode47 l = new LeetCode47();
        List<List<Integer>> permute = l.permuteUnique(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
