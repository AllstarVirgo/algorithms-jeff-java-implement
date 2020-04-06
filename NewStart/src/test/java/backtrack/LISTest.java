package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LISTest {

    LIS lis = new LIS();

    dp.LIS lisDP = new dp.LIS();

    @Test
    void lis1() {
        int[] test = {1,2,3};
        assertEquals(3,lis.lis1(0,0,wrapper(test)));
    }

    @Test
    void lis2() {
        int[] test = {2,2,3,6,7};
        assertEquals(4,lis.lis1(0,0,wrapper(test)));

        assertEquals(4,lis.lis2(0,wrapper(test)));
    }

    @Test
    void lis3(){
        int[] test = {1,2,3,7,6,7,3};
        assertEquals(5,lisDP.lisDP2(wrapper(test)));
    }

    static int[] wrapper(int[] array){
        int[] res = new int[array.length+1];
        res[0] = Integer.MIN_VALUE;
        System.arraycopy(array,0,res,1,array.length);
        return res;
    }
}