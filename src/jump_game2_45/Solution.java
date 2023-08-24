package jump_game2_45;

class Solution {
    private int[] nums;
    private final int lastIdx = 10000;
    private final int[] dp = new int[lastIdx];

    public int jump(int[] nums) {
        this.nums = nums;
        dp[0] = 1;

        return recJump(nums.length - 1, 0) - 1;
    }

    private int recJump(int idx, int length) {
        if (nums[idx] < length) {
            return lastIdx;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int minCnt = lastIdx;

        for (int i = 1; i <= idx; i++) {
            int cnt = recJump(idx - i, i);
            minCnt = Math.min(minCnt, cnt);
        }

        return dp[idx] = minCnt + 1;
    }
}