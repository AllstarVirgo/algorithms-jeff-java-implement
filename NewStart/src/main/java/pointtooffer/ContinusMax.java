package pointtooffer;

public class ContinusMax {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1,sum = max; i < array.length ; i++) {
            if(sum<0){
                sum = array[i];
            }else {
                sum += array[i];
            }
            if(sum>max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] demo = {-1,-2,1,1};
        ContinusMax cm = new ContinusMax();
        cm.FindGreatestSumOfSubArray(demo);
    }
}
