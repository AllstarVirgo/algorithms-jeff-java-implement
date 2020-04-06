package concurrent;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocalExample = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    private volatile Integer count;

    public ThreadLocalExample(Integer count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            System.out.println("current Thread" + Thread.currentThread() + "default format date: " + simpleDateFormatThreadLocalExample.get().toPattern());
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count % 2 == 0) {
                simpleDateFormatThreadLocalExample.set(new SimpleDateFormat());
            }
            count++;
        }
        System.out.println("count: " + count);
        System.out.println("current Thread" + Thread.currentThread() + "change format to: " + simpleDateFormatThreadLocalExample.get().toPattern());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadLocalExample(i)).start();
        }
    }
}
