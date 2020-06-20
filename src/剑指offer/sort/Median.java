package 剑指offer.sort;

import java.util.PriorityQueue;

/* 数据流中的中位数
从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
insert()方法读取数据流，使用getMedian()方法获取当前读取数据的中位数。
*/

public class Median {
	private int count = 0;
	// 构建一个大根堆存放较小的数字，小根堆存放较大的数字
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// PriorityQueue默认小根堆，实现大根堆需要重写compare方法
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, (o1, o2) -> o2 - o1);

	public void insert(Integer num) {
		// 如果是偶数，先进入大根堆进行筛选，然后加入小根堆中,反之
		if (count % 2 == 0) {
			maxHeap.offer(num);
			int filterMin = maxHeap.poll();
			minHeap.offer(filterMin);
		} else {
			minHeap.offer(num);
			int filterMax = minHeap.poll();
			maxHeap.offer(filterMax);
		}
		count++;
	}

	public Double getMedian() {
		if (count % 2 == 0) {
			return new Double((maxHeap.peek() + minHeap.peek())) / 2.0;
		} else {
			return new Double(minHeap.peek());
		}

	}
}
