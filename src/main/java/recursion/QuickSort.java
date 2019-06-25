package recursion;

/**
 * @author 01377809
 */
public class QuickSort {
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    /**
     * Get the k th smallest number in array
     *
     * @param array
     * @param k
     * @return
     */
    public int quickSlect(int[] array, int k) {
        return quickSelectHelper(array, 0, array.length - 1, k);
    }

    private int quickSelectHelper(int[] array, int lo, int hi, int k) {
        int len = hi-lo+1;
        if(len==1)
            return array[lo];
        else {
            int pivotIndex = lo;
            int p = partion(array, pivotIndex, lo, hi);
            if(k<p){
                return quickSelectHelper(array, lo, p-1, k);
            }else if(k>p){
                return quickSelectHelper(array, p+1, hi, k);
            }else
                return array[k];
        }
    }

    private void quickSortHelper(int[] array, int lo, int hi) {
        int len = hi - lo + 1;
        if (len > 1) {
            int pivotIndex = lo;
            int p = partion(array, pivotIndex, lo, hi);
            quickSortHelper(array, lo, p);
            quickSortHelper(array, p + 1, hi);
        }
    }

    private int partion(int[] array, int pivotIndex, int lo, int hi) {
        swap(array, pivotIndex, hi);
        /*   I just use the first element as pivot
         *   pivot---------------------------end
         *
         *   end-----------------------------pivot
         *
         *   array[0...n-2] compare to array[pivot]
         */
        int l = lo;
        for (int i = lo; i < hi; i++) {
            if (array[i] < array[hi]) {
                swap(array, i, l);
                l++;
            }
        }
        swap(array, l, hi);
        return l;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
