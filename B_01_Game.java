import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private Map<Integer, Set<Integer>> memo;

    public long maxGCDScore(int[] nums, int k) {
        memo = new HashMap<>();
        int lcm = 0;
        int n = nums.length;
        long res = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            allPossible(x, set);
            set.add(2 * x);
        }

        for (int gcd : set) {
            if (gcd <= 0)
                continue;

            int curr = 0;
            int left = 0;
            int currMax = 0;
            for (int right = 0; right < n; right++) {
                int val = nums[right];
                int cost;

                if (val % gcd == 0)
                    cost = 0;
                else if ((2L * val) % gcd == 0)
                    cost = 1;
                else {
                    curr = 0;
                    left = right + 1;
                    continue;
                }
                curr += cost;
                while (curr > k) {
                    if (nums[left] % gcd != 0)
                        curr--;
                    left++;
                }
                currMax = Math.max(currMax, right - left + 1);
            }
            res = Math.max(res, (long) currMax * gcd);
        }
        return res;
    }

    void helper(int num, Set<Integer> divisors) {
        if (num <= 0)
            return;
        for (int i = 1; (long) i * i <= num; ++i) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
    }

    void allPossible(int num, Set<Integer> divisors) {
        if (num <= 0)
            return;
        if (memo.containsKey(num)) {
            divisors.addAll(memo.get(num));
            return;
        }

        Set<Integer> currentDivisors = new HashSet<>();
        for (int i = 1; (long) i * i <= num; ++i) {
            if (num % i == 0) {
                currentDivisors.add(i);
                currentDivisors.add(num / i);
            }
        }
        memo.put(num, currentDivisors);
        divisors.addAll(currentDivisors);
    }
}