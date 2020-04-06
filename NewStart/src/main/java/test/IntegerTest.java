package test;

public class IntegerTest {
    public static void main(String[] args) {
        IntegerTest it = new IntegerTest();
        Integer test = 0;
        String test1 ="0";
        it.changeInteger(test);
        it.changeStr(test1);
        System.out.println(test);
        System.out.println(test1);
    }

    void changeInteger(Integer i){
        i = -1;
    }

    void changeStr(String i){
        i = "-1";
    }
}
