package candy_135;

import java.util.Arrays;

class Solution {
    int[] ratings;
    int[] candies;

    public int candy(int[] ratings) {
        this.ratings = ratings;
        candies = new int[ratings.length];

        candyRec(0, ratings.length - 1);

        return Arrays.stream(candies).sum();
    }

    private void candyRec(int first, int last) {
        if (first == last) {
            candies[first] = 1;
            return;
        }

        int mid = (first + last) / 2;
        candyRec(first, mid);
        candyRec(mid + 1, last);

        int left = mid;
        int right = mid + 1;

        plusCandies(left, first, true);
        plusCandies(right, last, false);
    }

    private void plusCandies(int target, int range, boolean direction) {
        int pre;

        if (direction) {
            if (target < range) {
                return;
            }
            pre = target + 1;
        } else {
            if (target > range) {
                return;
            }
            pre = target - 1;
        }

        if (ratings[target] <= ratings[pre] ||
                candies[target] > candies[pre]) {
            return;
        }

        candies[target] = candies[pre] + 1;

        if (direction) {
            plusCandies(target - 1, range, direction);
        } else {
            plusCandies(target + 1, range, direction);
        }
    }
}