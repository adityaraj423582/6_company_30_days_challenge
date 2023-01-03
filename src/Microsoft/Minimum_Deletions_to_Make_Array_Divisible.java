package Microsoft;

public class Minimum_Deletions_to_Make_Array_Divisible {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int j = dp[i - 1];
            while (j > 0 && nums[i] != nums[j]) {
                j = dp[j - 1];
            }
            if (nums[i] == nums[j]) {
                j++;
            }
            dp[i] = j;
        }
        System.out.println(n - dp[n - 1]);
    }
}
