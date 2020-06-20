package sort;

/* 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。

	示例 1:

	输入: [[1,3],[2,6],[8,10],[15,18]]
	输出: [[1,6],[8,10],[15,18]]
	解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	
   2.在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
   	示例 1:

	输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
	输出: [[1,5],[6,9]]
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class LeetCode56 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 1)
            return intervals;
        List<Interval> result = new ArrayList<>(intervals.size());
        // 先对区间进行排序
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Iterator<Interval> iter = intervals.iterator();
        // 指向第一个Interval节点
        Interval cur = iter.next();
        Interval next;
        while (iter.hasNext()) {
            next = iter.next();
            // 若无重叠 直接添加，然后两个指针都往后移动
            if (cur.end < next.start) {
                result.add(cur);
                cur = next;
            } else {
                // 如果有重叠，将当前的end改为两个end的最大值
                cur.end = Math.max(cur.end, next.end);
            }
        }
        result.add(cur);

        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>(intervals.size());
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        // 先对区间进行排序
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        // 1.顺序遍历找到重叠区间的start
        while (i < intervals.size()) {
            if (intervals.get(i).start > start) {
                break;
            } else if (intervals.get(i).start <= start && intervals.get(i).end >= start) {
                start = intervals.get(i).start;
                break;
            } else {
                result.add(intervals.get(i));
            }
            i++;
        }
        // 2.顺序找到重叠区间的end
        while (i < intervals.size()) {
            if (intervals.get(i).start > end) {
                break;
            } else if (intervals.get(i).start <= end && intervals.get(i).end >= end) {
                end = intervals.get(i).end;
                i++;
                break;
            } else {
                i++;
            }
        }
        // 3.加入重叠区间
        result.add(new Interval(start, end));
        // 4.遍历剩余的区间
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    private void print(List<Interval> list) {
        for (Interval inter : list) {
            System.out.println(inter.start + " " + inter.end);
        }
    }

    public static void main(String[] args) {
        LeetCode56 t = new LeetCode56();
        LeetCode56.Interval i1 = t.new Interval(1, 3);
        LeetCode56.Interval i2 = t.new Interval(7, 10);
        LeetCode56.Interval i3 = t.new Interval(15, 18);
        LeetCode56.Interval i4 = t.new Interval(2, 6);
        LeetCode56.Interval newInterval = t.new Interval(4, 8);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        t.print(list);
        t.print(t.merge(list));
//        t.print(t.insert(list, newInterval));
    }
}
