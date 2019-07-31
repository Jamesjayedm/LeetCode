/* 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
 */

/*
链表
令最长公共前缀 ans 的值为第一个字符串，进行初始化
遍历后面的字符串，依次将其与 result 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
时间复杂度：O(s)，s 为所有字符串的长度之和

*/
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            //每一个字符串都与strs[0]作比较，找出公共的字符串
            for (; j < strs[i].length() && j < result.length(); j++) {
                if (strs[i].charAt(j) != result.charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
        }
        return result;
    }
}
