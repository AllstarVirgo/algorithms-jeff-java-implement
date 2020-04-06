package concurrent;

public class Count {
    private Wrapper num = new Wrapper();


    public void count() {
        for(int i = 1; i <= 10; i++) {
            num.k += i;
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);
        System.out.println(Thread.currentThread().getName() + "hashcode-" + num.hashCode());
    }
}
