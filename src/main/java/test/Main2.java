package test;

import java.util.Scanner;

public class Main2 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        process(array,0,24);
        System.out.println(count);
    }

    private static void process(int[] array,int step,int target) {
        if(target<0)return;
        if(target == 0){
            count++;
            return;
        }
        if(step<array.length) {
            process(array, step + 1, target - array[step]);
            process(array, step + 1, target);
        }

    }
}
