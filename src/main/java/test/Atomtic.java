package test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author potato
 * @Date 2019/10/16 14:55
 */
public class Atomtic {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);
        atomicLong.getAndIncrement();
        System.out.println(atomicLong.get());
        System.out.println(atomicLong.get());
    }
}
