package pointer;

public class Heapsort {
    int getMin(int[] array){
        int end = array.length-1;
        for (int i = end/2; i >=0 ; i--) {
            heapify(array,i,end);
        }
        return array[0];
    }

    private void heapify(int[] array, int i, int end) {
        int left = (i<<1)+1;
        int right = left + 1;
        int min = left;
        if(left>end)return;
        if(right<=end&&array[right]<array[left]){
            min = right;
        }
        if(array[min]<array[i]){
            swap(array,i,min);
            heapify(array,min,end);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] demo = {1,2};
        Heapsort heapsort= new Heapsort();
        System.out.println(heapsort.getMin(demo));
    }
}
