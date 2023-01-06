package GoldmanSachs;

public class Factorial_Trailing_Zeroes {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
