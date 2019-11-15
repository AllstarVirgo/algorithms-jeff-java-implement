package jvm.chapter7;

public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}

///**
// * 非主动使用类字段演示
// **/
//class NotInitialization {
//
//    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//    }
//
//}

///**
// * 被动使用类字段演示二：
// * 通过数组定义来引用类，不会触发此类的初始化
// **/
//class NotInitialization {
//
//    public static void main(String[] args) {
//        SuperClass[] sca = new SuperClass[10];
//    }
//
//}

/**
 * 被动使用类字段演示三：
 * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 **/
class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}

/**
 * 非主动使用类字段演示
 **/
class NotInitialization {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
