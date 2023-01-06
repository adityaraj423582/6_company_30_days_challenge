package GoldmanSachs;

public class Valid_square {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] sides = new int[6];
        sides[0] = distance(p1, p2);
        sides[1] = distance(p1, p3);
        sides[2] = distance(p1, p4);
        sides[3] = distance(p2, p3);
        sides[4] = distance(p2, p4);
        sides[5] = distance(p3, p4);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            min = Math.min(min, sides[i]);
            max = Math.max(max, sides[i]);
        }
        if (min == 0 || min != max / 2) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (sides[i] == min) {
                count++;
            }
        }
        return count == 4;
    }

    public static int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
