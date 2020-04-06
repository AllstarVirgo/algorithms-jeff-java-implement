package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be
 * sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2: Input: [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4]
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findClosetElement(arr, x);
        int i, j;
        if (index == -1) {
            i = j= 0;
        } else {
            i = j =index;
        }

        while (k > 1) {
            if (i > 0) {
                i--;
                k--;
            }
            if (k <= 1)
                break;
            if (j < (arr.length - 1)) {
                j++;
                k--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int l = i; l <= j; l++) {
            list.add(arr[l]);
        }
        return list;
    }

    int findClosetElement(int[] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (target == array[right])
            return right;
        else{
            int smaller = right - 1;
            if(smaller==-1)return right;
            else {
                int difSmall = Math.abs(target - array[smaller]);
                int difBig = Math.abs(target - array[right]);
                if(difSmall == difBig) return smaller;
                else if(difSmall<difBig) return smaller;
                else return right;
            }
        }
    }

    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        int[] demo = {0,1,1,1,2,3,6,7,8,9};
        List<Integer>res = findKClosestElements.findClosestElements(demo,9,4);
        res.stream().forEach(System.out::println);
    }
}
