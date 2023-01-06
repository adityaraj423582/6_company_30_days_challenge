package GoldmanSachs;

public class Split_Array_into_Consecutive_Subsequences {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5};
        System.out.println(isPossible(nums));
    }

    public static boolean isPossible(int[] nums) {
        int[] count = new int[10001];
        int[] tail = new int[10001];
        for (int num : nums) {
            count[num]++;
        }
        for (int num : nums) {
            if (count[num] == 0) {
                continue;
            }
            if (tail[num - 1] > 0) {
                tail[num - 1]--;
                tail[num]++;
                count[num]--;
            } else if (count[num + 1] > 0 && count[num + 2] > 0) {
                count[num]--;
                count[num + 1]--;
                count[num + 2]--;
                tail[num + 2]++;
            } else {
                return false;
            }
        }
        return true;
    }
}
