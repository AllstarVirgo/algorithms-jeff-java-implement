package array;

/**
 * 这道题目我没做出来。
 * 同时考虑了横坐标的变化，和纵坐标的变化，很难，思路混乱。
 *
 * 网上的参考方案。我们可以先假定横坐标最大化，一个指针在数组的开头，一个指针在数组的结尾
 * 此时，我们只需要考虑y轴的变化对面积造成的影响
 *
 * 不断移动y轴较小的一端，在移动的同时（保证了x轴尽可能的长）
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] <= height[right]) {
                int cur = left;
                while (height[left] >= height[++cur]) {
                    if (cur >= right)
                        break;
                }
                left = cur;
            } else {
                int cur = right;
                while (height[right] >= height[--cur]) {
                    if (cur <= left)
                        break;
                }
                right = cur;
            }
            int tempMaxArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, tempMaxArea);
        }
        return maxArea;
    }
}
