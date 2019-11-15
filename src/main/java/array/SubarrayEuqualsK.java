package array;

public class SubarrayEuqualsK {
    public static int subarraySum(int[] nums, int k) {
        int last = nums.length-1;
        int[] sumTotals = new int[nums.length+1];
        for(int i=0;i<=nums.length;i++)
            sumTotals[i] = 0;
        for(int i = last;i>=0;i--){
            int j = i,sum = nums[j];
            boolean getLeftCount = false;
            while(j<=last&&!getLeftCount){
                if(j!=i)
                    sum+=nums[j];
                if(sum==k){
                    sumTotals[i] = 1;
                }
                if(sum==0){
                    sumTotals[i] += sumTotals[j+1];
                    getLeftCount = true;
                }
                j++;
            }
        }
        int resCount = 0;
        for(int i=0;i<=nums.length;i++)
            resCount+=sumTotals[i];
        return resCount;
    }

    public static void main(String[] args) {
        int[] test = {-1,-1,1};
        System.out.println(subarraySum(test,1));
    }
}
