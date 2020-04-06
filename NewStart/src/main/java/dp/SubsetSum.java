package dp;

/**
 * @author potato
 * @Date 2019/8/1 17:31
 */
public class SubsetSum {
    /**
     * We formulate the problem in backtrack:
     * SS(i,t) denotes that sub sets in array[1..i] can sum to t.
     *
     *          true                            if t=0
     * SS(i,t)= false                           if t>n or t<0
     *          SS(i+1,t)|SS(i+1,t-array[i])    otherwise
     *
     * But for all t<0,it's stupid to memorize all the cases.So we should change the formula.
     *          true                            if t=0
     * SS(i,t)= false                           if n>0
     *          SS(i+1,t)                       if t<array[i]
     *          SS(i+1,t)|SS(i+1,t-array[i])    otherwise
     * @param array
     * @return
     */
    public boolean fastSubsetSum(int[] array){
        //TODO
        return false;
    }
}
