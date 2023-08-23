package remove_duplicates_from_sorted_array2_80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 2;

        for (int i = 2; i < nums.length; i++) {
            int num1 = nums[idx - 2];
            int num2 = nums[idx - 1];
            int num3 = nums[i];

            if (num1 == num3 && num2 == num3) {
                continue;
            }

            nums[idx] = num3;
            idx++;
        }

        return idx;
    }
}