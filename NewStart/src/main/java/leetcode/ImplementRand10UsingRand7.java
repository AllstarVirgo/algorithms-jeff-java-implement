package leetcode;

/**
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7,
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 *
 * Do NOT use system's Math.random().
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: [7]
 * Example 2:
 *
 * Input: 2
 * Output: [8,4]
 * Example 3:
 *
 * Input: 3
 * Output: [8,1,10]
 */
public abstract class ImplementRand10UsingRand7 {

    /**
     *   1  2  3  4  5  6  7
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     *
     *  7(x-1) + (y-1) ---> 0~48
     * @return
     */
    public int rand10() {
        int result = 40;
        //若取余，对于0~40内的数机会是均等的
        while(result>=40){
            result = 7*(rand7()-1)+ (rand7()-1);
        }
        return result%10 == 0 ? 10 : result%10;
    }

    abstract int rand7();
}
