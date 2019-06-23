package recursion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class HanoiTest {
    private final Hanoi hanoi = new Hanoi();

    @Test
    void remove() {
        for (int i = 1; i < 10; i++) {
            int[] src = new int[i];
            for (int j = 0; j < i; j++) {
                src[j] = j;
            }
            int n = src.length;
            int[] assist = new int[n];
            int[] dst = new int[n];
            hanoi.recMove(n-1, src, assist, dst);
            assertArrayEquals(src, dst);
        }
    }
}
