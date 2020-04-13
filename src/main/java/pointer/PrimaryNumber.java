package pointer;

public class PrimaryNumber {
    public static int getPrimaryNumber(int n){
        if(n<=2)return n;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrimary(i))
                count++;
        }
        count+=1;
        return count;
    }

    private static boolean isPrimary(int k){
        int sqart = (int) Math.sqrt(k);
        for (int i = 2; i <= sqart ; i++) {
            if(k%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPrimaryNumber(5));
    }
}
