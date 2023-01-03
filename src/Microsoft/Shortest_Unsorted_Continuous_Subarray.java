package Microsoft;

public class Shortest_Unsorted_Continuous_Subarray {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == nums.length - 1) {
            return 0;
        }
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] < max) {
            right++;
        }
        return right - left + 1;
    }
}
