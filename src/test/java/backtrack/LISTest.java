package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LISTest {

    LIS lis = new LIS();

    @Test
    void lis1() {
        int[] test = {1,2,3};
        assertEquals(3,lis.lis1(0,0,test));
    }

    @Test
    void lis2() {
        int[] test = {1,2,3,6,7};
        assertEquals(5,lis.lis1(0,0,test));

        int[] sentinel = new int[test.length+1];
        sentinel[0] = Integer.MIN_VALUE;
        System.arraycopy(test,0,sentinel,1,test.length);
        assertEquals(5,lis.lis2(0,sentinel));
    }
}