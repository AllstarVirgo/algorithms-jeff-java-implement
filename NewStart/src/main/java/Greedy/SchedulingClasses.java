package Greedy;

public class SchedulingClasses {
    /**
     * s[1...n] denotes the start time
     * f[1...n] denotes the corresponding finish time
     *
     * How can we choose as many classes as possible?
     * The classes we choose should not be overlapped
     *
     * The key is to finish one class as early as possible.
     * It's nothing about start time.A start time is just used to start another class as
     * soon as possible.
     *
     *
     * @param startTime
     * @param finishTime
     * @return
     */
    public int getMaxClasses(int[] startTime,int[] finishTime){
        //sort finish time and permute start time
        quickSortAndPermuteAnother(startTime,finishTime,0,finishTime.length-1);
        int initFinishTime = finishTime[0];
        int count = 1;
        for (int i = 1; i < startTime.length; i++) {
            if(startTime[i]>initFinishTime) {
                initFinishTime = finishTime[i];
                count++;
            }
        }
        return count;
    }

    private void quickSortAndPermuteAnother(int[] startTime,int[] finishTime,int lo,int hi){
        int len = hi - lo + 1;
        if(len > 1) {
            int j = part(startTime, finishTime, lo, hi);
            quickSortAndPermuteAnother(startTime, finishTime, lo, j - 1);
            quickSortAndPermuteAnother(startTime, finishTime, j + 1, hi);
        }
    }

    private int part(int[] startTime, int[] finishTIme, int lo, int hi) {
        int compare = finishTIme[lo];
        int cur = lo+1;
        for (int i = lo+1; i <= hi ; i++) {
            if(finishTIme[i]<compare){
                switchArray(finishTIme,cur,i);
                switchArray(startTime,cur,i);
                cur++;
            }
        }
        switchArray(finishTIme,cur,lo);
        return cur;
    }

    private void switchArray(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
