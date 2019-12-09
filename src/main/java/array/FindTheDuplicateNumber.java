package array;

/**
 * @author potato
 * @Date 2019/11/19 8:53
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(temp==nums[j])
                    return temp;
            }
        }
        return -1;
    }
}
