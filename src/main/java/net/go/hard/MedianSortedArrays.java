package net.go.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @author gaochuanjun
 * @since 2017/3/1
 */
public class MedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        MedianSortedArrays sortedArrays = new MedianSortedArrays();
        double medianSortedArrays = sortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>(nums1.length + nums2.length);
        for (int num : nums1) {
            list.add(num);
        }
        for (int aNums2 : nums2) {
            list.add(aNums2);
        }
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        Collections.sort(list);
        int medium = list.size() / 2;
        if (list.size() % 2 == 0) {
            return ((double) (list.get(medium - 1)) + (double) (list.get(medium))) / 2.0;
        } else {
            return list.get(medium);
        }
    }
}
