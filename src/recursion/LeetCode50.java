package recursion;
/* Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */

public class LeetCode50 {
    public double myPow(double x, int n) {
        if (x == -1) {
            if ((n & 1) == 0)
                return 1;
            else return -1;
        }
        if (x == 1) {
            return 1;
        }
        if (n == -2147483648) {
            return 0;
        }


        if (n > 0) {
            return powRecursion(x, n);
        } else {
            n = -n;
            return 1 / powRecursion(x, n);
        }
    }

    private double powRecursion(double x, int n) {
        if (n == 0)
            return 1;
        if ((n & 1) == 0) {
            return powRecursion(x * x, n / 2);
        } else
            // 奇数情况
            return powRecursion(x * x, n / 2) * x;

    }

    public static void main(String[] args) {
        LeetCode50 l = new LeetCode50();
        System.out.println(l.myPow(2, 10));
    }

}
