package cn.leetcode.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Merge {

    //贪心
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            return res;
        }
        //排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        //一个区间一个区间进行合并
        Interval pre = null;
        for(Interval intel : intervals) {
            if(pre == null || pre.end < intel.start) {
                res.add(intel);
                pre = intel;
            }else if(pre.end < intel.end){
                pre.end = intel.end;
            }
        }
        return res;
    }


}

//Definition for an interval.
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


