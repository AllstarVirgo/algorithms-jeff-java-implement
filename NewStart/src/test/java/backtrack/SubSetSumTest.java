package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 01377809
 */
class SubSetSumTest {
    @Test
    void test() {
        SubSetSum subSetSum = new SubSetSum();
        int[] array = {1,3,5,9};
        assertTrue(subSetSum.subSetSum(array,9));
    }
}