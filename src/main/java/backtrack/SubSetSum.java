package backtrack;



/**
 * @author potato
 */
public class SubSetSum {
    boolean subSetSum(int[] array,int target){
       return helper(array,array.length-1,target);
    }

    boolean helper(int[] array,int lastIndex,int target){
        if(target==0){
            return true;
        }else if(target<0||lastIndex<0){
            return false;
        }else {
            boolean with = helper(array, lastIndex-1, target-array[lastIndex]);
            boolean without = helper(array, lastIndex-1, target);
            return with|without;
        }
    }
}
