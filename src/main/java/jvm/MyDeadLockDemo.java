package jvm;

public class MyDeadLockDemo {
    private Object objectA = new Object();

    private Object objectB = new Object();


    public static void main(String[] args) {
        MyDeadLockDemo myDeadLockDemo = new MyDeadLockDemo();
        new Thread(()->{
            System.out.println("get A");
            synchronized (myDeadLockDemo.objectA){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try to get B");
                synchronized (myDeadLockDemo.objectB){
                    System.out.println("get B");
                }
            }
        }).start();

        new Thread(()->{
            System.out.println("get B");
            synchronized (myDeadLockDemo.objectB) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try to get A");
                synchronized (myDeadLockDemo.objectA){
                    System.out.println("get A");
                }
            }
        }).start();
    }
}
