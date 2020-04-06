package pointtooffer;

import java.util.ArrayList;

public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((i1,i2)-> {
            return i1.start - i2.start;
        });
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals.size() == 0 || intervals.size() == 1)
            return intervals;
        for (int i = 0; i < intervals.size(); i++) {
            Interval pre = intervals.get(i);
            Interval cur;
            int j = i + 1;
            for (; j < intervals.size(); j++) {
                cur = intervals.get(j);
                if (pre.end >= cur.start) {
                    pre = new Interval(pre.start, Math.max(pre.end,cur.end));
                } else
                    break;
            }
            i = j - 1;
            res.add(pre);
        }
        return res;
    }


    public static class Interval {
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

    public static void main(String[] args) {
        Interval m = new Interval(1,4);
        Interval m1 = new Interval(1,5);
        ArrayList<Interval>arrayList = new ArrayList<>();
        arrayList.add(m);
        arrayList.add(m1);
        MergeInterval merge = new MergeInterval();
        merge.merge(arrayList);
    }
}
