/* ������ת
����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 */

public class LeetCode07 {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        // �ж��Ƿ�����
        if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE)
            return 0;
        return (int) result;

    }
}
