package remove_element_27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int l = nums.length - 1;

        for (int f = 0; f <= l; f++) {
            while (f <= l && nums[l] == val) {
                l--;
            }

            if (f < l && nums[f] == val) {
                int temp = nums[l];
                nums[l] = nums[f];
                nums[f] = temp;
            }
        }

        return l + 1;
    }
}