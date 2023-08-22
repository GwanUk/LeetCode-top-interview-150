package merge_sorted_array_88;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1, m);

        int im = 0;
        int in = 0;

        for (int i = 0; i < m + n; i++) {
            if (im >= m) {
                nums1[i] = nums2[in];
                in++;
            } else if (in >= n) {
                nums1[i] = nums3[im];
                im++;
            } else if (nums3[im] < nums2[in]) {
                nums1[i] = nums3[im];
                im++;
            }else {
                nums1[i] = nums2[in];
                in++;
            }
        }
    }
}