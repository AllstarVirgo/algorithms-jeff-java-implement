package pointtooffer;

/**
 *
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 */
public class IsSearchTree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return  verifyHelper(sequence, sequence.length-1,0);
    }

    private boolean verifyHelper(int[] sequence,int rootIdx,int start){
        //start >= rootIdx 表示已经遍历完树，且无异常
        if(start>=rootIdx)return true;
        int rootVal = sequence[rootIdx];
        int rightIdx = -1;
        for(int i = 0;i < rootIdx;i++){
            if(sequence[i]>rootVal){
                rightIdx = i;
                break;
            }
        }

        if(rightIdx!=-1){
            for(int i = rightIdx;i< rootIdx;i++){
                if(sequence[i]<rootVal)
                    return false;
            }
        }

        //右子树的根节点总是 rootIdx-1
        return verifyHelper(sequence,rightIdx-1,start) && verifyHelper(sequence,rightIdx,rootIdx-1);
    }
}
