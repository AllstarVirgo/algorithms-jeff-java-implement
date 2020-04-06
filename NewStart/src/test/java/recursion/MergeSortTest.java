package recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSort() {
        for (int i = 1; i < 100; i++) {
            MergeSort mergeSort = new MergeSort(i);
            int[] test = new int[i];
            for (int j = 0; j < i; j++) {
                test[j] = new Random().nextInt();
            }
            int[] copy = new int[i];
            System.arraycopy(test,0,copy,0,i);
            Arrays.sort(copy);
            mergeSort.mergeSort(test,0,i-1);
            assertArrayEquals(test,copy);
        }
    }

    @Test
    void simpleSort(){
        int[] array = {2,3,1};
        int[] copy = array.clone();
        MergeSort mergeSort = new MergeSort(3);
        mergeSort.mergeSort(array,0,array.length-1);
        Arrays.sort(copy);
        assertArrayEquals(copy,array);
    }
}