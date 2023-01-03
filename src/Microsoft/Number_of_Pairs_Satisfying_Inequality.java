package Microsoft;

public class Number_of_Pairs_Satisfying_Inequality {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 2, 1};
        int k = 1;
        System.out.println(numOfPairs(nums, k));
    }

    public static int numOfPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
