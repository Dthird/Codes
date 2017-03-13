package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jason on 3/12/17.
 */

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


/**
 * Merge Interval
 */
public class M56 {
    public List<Interval> merge(List<Interval> intervals) {
        /*
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else  if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        });
        */
        // jdk8 lambda
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0)
            return res;

        Interval tmp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            if (tmp.end < intervals.get(i).start){
                res.add(tmp);
                tmp = intervals.get(i);
            } else if (tmp.end == intervals.get(i).start){
                tmp = new Interval(tmp.start, intervals.get(i).end);
            } else {
                tmp = new Interval(tmp.start, Math.max(tmp.end, intervals.get(i).end));
            }

        }
        res.add(tmp);
        return res;
    }
}
