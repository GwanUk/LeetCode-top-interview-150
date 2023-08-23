package rotate_array_189;

import java.util.stream.IntStream;

class Solution {
    int[] nums;
    int k;
    boolean[] visit = new boolean[100000];

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        IntStream.range(0, nums.length)
                .forEach(this::rec);
    }

    private int rec(int idx) {
        if (visit[idx]) {
            return nums[idx];
        }

        visit[idx] = true;

        int num = nums[idx];
        nums[idx] = rec(index(idx));
        return num;
    }

    private int index(int idx){
        int index = idx - k;

        while (index < 0) {
            index += nums.length;
        }

        return index;
    }
}