package Microsoft;


import java.util.*;

public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        int max = 0;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            index[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = index[maxIndex];
        }

        return result;
    }
}
