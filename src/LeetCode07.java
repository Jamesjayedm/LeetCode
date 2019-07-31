/* 整数翻转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */

public class LeetCode07 {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        // 判断是否会溢出
        if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE)
            return 0;
        return (int) result;

    }
}
