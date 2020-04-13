package test;


import java.util.Arrays;

/**
 * @author potato
 * @Date 2019/10/16 14:55
 */
public class Atomtic {
    public static void main(String[] args) {
        int[] coins = {1,2,3,4,56};
        Integer[] reverseCoins = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        Arrays.sort(reverseCoins,(s1,s2)->s2.compareTo(s1));
        Arrays.stream(reverseCoins).forEach(System.out::println);

    }
}
