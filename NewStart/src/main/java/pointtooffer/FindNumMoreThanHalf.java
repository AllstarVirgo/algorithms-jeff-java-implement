package pointtooffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class FindNumMoreThanHalf {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = 0;
        int ret = 0;

        //所有人依次进入战场，如果战场空着，自己的支持者暂时获胜，支持者数量为 1。如果战场上已经有一伙的，实力加强。如果不是一伙的就和对方其中一个同归于尽。
        //
        //拼杀完成后，如果保证某人的支持者过半，那么战场上留下的就是这个人的支持者
        for(int i = 0;i<array.length;i++){
            if(n==0){
                ret = array[i];
                n = 1;
            }else{
                if(array[i]==ret){
                    n++;
                }else
                    n--;
            }
        }
        //还需要再做一次遍历，可能没有超过半数的数字
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == ret)
                count++;
        }
        return count>array.length/2?ret:0;
    }
}
