package GoldmanSachs;

public class Count_Nice_Pairs_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        int mod = (int)1e9 + 7;
        int[] rev = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            rev[i] = reverse(nums[i]);
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] - rev[i] == nums[j] - rev[j]){
                    count++;
                }
            }
        }
        return count % mod;
    }

    public static int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
