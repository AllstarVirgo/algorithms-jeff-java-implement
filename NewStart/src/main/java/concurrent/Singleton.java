package concurrent;

public class Singleton {
    private Singleton(){}

    /**
     * 禁止指令重排序
     */
    private volatile static Singleton singletonInstance = null;

    public static Singleton getInstance(){
       if(singletonInstance==null){
           synchronized (Singleton.class){
               if(singletonInstance==null)
                   return new Singleton();
           }
       }
       return singletonInstance;
    }
}
