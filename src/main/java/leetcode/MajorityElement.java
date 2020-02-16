package leetcode;

public class MajorityElement {
    /**
     * 选举算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0,ret = 0;
        for(int num:nums){
            if(count == 0)
                ret = num;
            if(ret!=num)
                count--;
            else
                count++;
        }
        return ret;
    }
}
