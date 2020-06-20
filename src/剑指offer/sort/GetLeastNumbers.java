package 剑指offer.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    /**
     * 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }
}
