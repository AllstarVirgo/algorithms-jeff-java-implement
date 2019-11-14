package array;

public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        long product = nums[0];
        int zeroCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0)
                product *= nums[i];
            else
                zeroCount++;
            if (zeroCount > 1)
                break;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                nums[i] = 0;
            }else if (zeroCount == 0) {
                nums[i] = (int) (product / nums[i]);
            } else {
                if (nums[i] != 0) {
                    nums[i] = 0;
                } else
                    nums[i] = (int) product;
            }
        }
        return nums;
    }

    /**
     * Get from leetcode
     * Get product from different directions
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums){
        int[] result = new int[nums.length];
        for (int i = 0,temp=1; i < nums.length; i++) {
            result[i] = temp;
            temp*= nums[i];
        }
        for (int i = nums.length-1,temp=1; i >=0 ; i--) {
            result[i]*=temp;
            temp *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductArray productArray = new ProductArray();
        int[] test = {1,2,3,4};
        productArray.productExceptSelf1(test);
    }
}
