package recursion;

public class MergeSort {
    private int[] temp;

    private int n;

    public MergeSort(int n) {
        this.n = n;
        this.temp = new int[n];
    }

    public void mergeSort(int[] array, int start, int end) {
        int len = end - start + 1;
        if (len > 1) {
            int m = (start + end) / 2;
            mergeSort(array, start, m);
            mergeSort(array, m + 1, end);
            merge(array, start, end);
        }
    }

    private void merge(int[] array, int start, int end) {
        int m = (start + end) / 2;
        int i = start;
        int j = m + 1;
        for (int k = start; k <= end; k++) {
            if (j > end) {
                temp[k] = array[i];
                i++;
            } else if (i > m) {
                temp[k] = array[j];
                j++;
            } else if (array[i] > array[j]) {
                temp[k] = array[j];
                j++;
            } else {
                temp[k] = array[i];
                i++;
            }
        }

        for (int k = start; k <=end; k++) {
            array[k] = temp[k];
        }
    }
}
