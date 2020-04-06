package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author potato
 */
public class GetOneSubSet {
    List<Integer> construct(int[] array,int i,int target){
        if(0==target){
            return new ArrayList<>();
        }
        if (target<0||i<0){
            return null;
        }
        List<Integer>res = construct(array, i-1, target);
        if(res!=null)
            return res;
        res = construct(array, i-1, target-array[i]);
        if(res!=null) {
            res.add(array[i]);
            return res;
        }
        return null;
    }
}
