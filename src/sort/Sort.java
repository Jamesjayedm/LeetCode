package sort;

/**
 * 排序算法
 * 冒泡、插入、选择
 *
 * @author 63196
 */
public class Sort {
    /*
     * 冒泡排序
     */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            // 若没有数据交换，则已经排序完成，退出
            if (!flag)
                break;
        }
    }

    /*
     * 插入排序
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 只要比value大就后移
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 找到合适的位置插入
            a[j + 1] = value;
        }
    }

    /*
     * 选择排序
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 排除i位置就是最小值
            if (i != minIndex) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 7, 3, 8, 5, 2, 6, 1};
        Sort s = new Sort();
        s.print(a);
        //		s.bubbleSort(a);
        //		s.print(a);
        //		s.insertionSort(a);
        //		s.print(a);
        s.selectionSort(a);
        s.print(a);
    }
}
