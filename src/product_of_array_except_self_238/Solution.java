package product_of_array_except_self_238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroIdx = -1;
        int total = 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                if (zeroIdx != -1) {
                    return result;
                }

                zeroIdx = i;
                continue;
            }

            total *= num;
        }

        if (zeroIdx != -1) {
            result[zeroIdx] = total;
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = total / nums[i];
        }

        return result;
    }
}