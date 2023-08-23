package remove_duplicates_from_sorted_array_26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 1;

        for (int i = 1; i < nums.length; i++) {
            int num1 = nums[idx - 1];
            int num2 = nums[i];

            if (num1 < num2) {
                nums[idx] = num2;
                idx++;
            }
        }

        return idx;
    }
}