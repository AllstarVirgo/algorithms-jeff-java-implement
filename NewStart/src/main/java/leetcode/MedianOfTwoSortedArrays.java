package leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
        double maxLeft = 0, minRight = 0;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half - i;
            if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = (double) nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = (double) nums1[i - 1];
                } else {
                    maxLeft = (double) Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }
        if (i == m) {
            minRight = (double) nums2[j];
        } else if (j == n) {
            minRight = (double) nums1[i];
        } else {
            minRight = (double) Math.min(nums1[i], nums2[j]);
        }

        return (double) (maxLeft + minRight) / 2;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int imin = 0, imax = m, half = (m + n + 1) / 2, i = 0, j = 0;
        double maxLeft = 0, minRight = 0;
//        if(i - 1 >= 0 && i - 1 < m && j >= 0 && j < n && nums1[i - 1] > nums2[j]) right = i - 1;
//        else if(j - 1 >= 0 && j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) left = i + 1;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half - i;
            if (i - 1 >= 0 && i - 1 < m && j >= 0 && j < n && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else if (j - 1 >= 0 && j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }else {
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                break;

            }
        }

        if ((m + n) % 2 == 1) return maxLeft;
        if (i == m)
            minRight = nums2[j];
        else if (j == n)
            minRight = nums1[i];
        else minRight = Math.min(nums1[i], nums2[j]);
        return (maxLeft + minRight) / 2.0;

    }
}
