package sort;

/**
 * 快速排序
 *
 * @author 63196
 */
public class QuickSort {

    public void QuickSort(int[] a) {
        QuickSortInternal(a, 0, a.length - 1);
    }

    private void QuickSortInternal(int[] a, int left, int right) {
        if (left >= right)
            return;
        int partition = Partition(a, left, right);
        QuickSortInternal(a, left, partition - 1);
        QuickSortInternal(a, partition + 1, right);

    }

    private int Partition(int[] a, int left, int right) {
        int i = left;
        int j = right;
        // 设置一个基准
        int pivot = a[left];
        while (i < j) {
            // j找到比pivot小的停下
            while (i < j && pivot <= a[j]) {
                j--;
            }
            // i找到比pivot大的停下
            while (i < j && pivot >= a[i]) {
                i++;
            }
            if (i < j) {
                // 交换a[i]和a[j]
                swap(a, i, j);
            } else {
                break;
            }
        }
        // 最后交换基准和i，j相遇的位置
        swap(a, left, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 3, 8, 5, 2, 6, 1};
        QuickSort qs = new QuickSort();
        qs.print(a);
        qs.QuickSort(a);
        qs.print(a);
    }
}
