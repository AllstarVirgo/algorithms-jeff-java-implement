package recursion;

public class Hanoi {
    public void recMove(int n, int[] src, int[] assist, int[] dst){
        if(n>=0){
            recMove(n-1,src,dst,assist);
            dst[n] =  src[n];
            recMove(n-1,assist,src,dst);
        }
    }


}
