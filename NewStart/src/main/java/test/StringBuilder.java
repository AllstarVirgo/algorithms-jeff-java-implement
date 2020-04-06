package test;

public class StringBuilder {
    public static void main(String[] args) {
        java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(new java.lang.StringBuilder("test"));
        stringBuilder.insert(0,"v");

        System.out.println(stringBuilder.toString());
    }
}
