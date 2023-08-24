package h_index_274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        int total = citations.length;
        int max = 0;

        Arrays.sort(citations);

        for (int i = 0; i < total; i++) {
            int citation = citations[i];
            int count = total - i;

            int result = Math.min(count, citation);
            max = Math.max(max, result);
        }

        return max;
    }
}