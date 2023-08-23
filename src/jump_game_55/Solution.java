package jump_game_55;

class Solution {
    int[] nums;
    int destination;
    boolean[] visit = new boolean[10000];

    public boolean canJump(int[] nums) {
        this.nums = nums;
        destination = nums.length - 1;
        return jump(destination, 0);
    }

    private boolean jump(int idx, int length) {
        if (visit[idx]) {
            return false;
        }

        visit[idx] = true;

        if (nums[idx] < length) {
            return false;
        }

        if (idx == 0) {
            return true;
        }

        for (int i = 1; i <= idx; i++) {
            if (jump(idx - i, i)) {
                return true;
            }
        }

        return false;
    }
}