/* 报数
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 */

/*
从4->5分析，将4个每一位拆开看（从左向右看）（个数+数字），4=1211 => 1=11，2=12，11=21，所以5=111221
从左至右一个一个生成即可
 */
public class LeetCode38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char pre = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (pre == s.charAt(j)) {
                    count++;
                } else {
                    sb.append(count).append(pre);
                    count = 1;
                    pre = s.charAt(j);
                }
            }
            sb.append(count).append(pre);
            s = sb.toString();
        }
        return s;
    }
}
