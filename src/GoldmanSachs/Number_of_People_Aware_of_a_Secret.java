package GoldmanSachs;

public class Number_of_People_Aware_of_a_Secret {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 4};
        System.out.println(peopleAware(nums));
    }

    private static int peopleAware(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] = max;
            max = Math.max(max, nums[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, nums[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > left[i] && nums[i] > right[i]) {
                count++;
            }
        }
        return count;
    }
}
