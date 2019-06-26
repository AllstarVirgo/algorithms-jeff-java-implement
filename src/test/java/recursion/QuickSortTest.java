package recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 01377809
 */
class QuickSortTest {

    @Test
    void quickSort() {
        for (int i = 1; i < 100; i++) {
            QuickSort quickSort = new QuickSort();
            int[] test = new int[i];
            for (int j = 0; j < i; j++) {
                test[j] = new Random().nextInt();
            }
            int[] copy = new int[i];
            System.arraycopy(test,0,copy,0,i);
            Arrays.sort(copy);
            quickSort.quickSort(test);
            assertArrayEquals(test,copy);
        }
    }

    @Test
    void quickSelect(){
        for (int i = 1; i < 100; i++) {
            QuickSort quickSort = new QuickSort();
            int[] test = new int[i];
            for (int j = 0; j < i; j++) {
                test[j] = new Random().nextInt();
            }
            int[] copy = new int[i];
            System.arraycopy(test,0,copy,0,i);
            int index = new Random().nextInt(i);
            Arrays.sort(copy);
            int actual = quickSort.quickSlect(test,index);
            int expect = copy[index];
            assertEquals(expect,actual);
        }
    }
}