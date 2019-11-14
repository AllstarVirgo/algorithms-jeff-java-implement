package concurrent;

public class DeadLock {
    private static final Object o1 = new Object();

    private static final Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println(Thread.currentThread() + "get o1");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get o2");
                synchronized (o2) {
                    System.out.println(Thread.currentThread() + "get o2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    System.out.println(Thread.currentThread() + "get o2");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get o1");
                synchronized (o1) {
                    System.out.println(Thread.currentThread() + "get o1");
                }
            }
        }).start();
    }
}
