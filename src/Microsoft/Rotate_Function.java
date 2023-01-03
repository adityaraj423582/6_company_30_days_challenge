package Microsoft;

public class Rotate_Function {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(A));
    }

    public static int maxRotateFunction(int[] A) {
        int sum = 0;
        int F = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int max = F;
        for (int i = A.length - 1; i > 0; i--) {
            F = F + sum - A.length * A[i];
            max = Math.max(max, F);
        }
        return max;
    }
}
