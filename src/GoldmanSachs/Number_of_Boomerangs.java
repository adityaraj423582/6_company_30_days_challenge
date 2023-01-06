package GoldmanSachs;
import java.util.*;
public class Number_of_Boomerangs {
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int distance = getDistance(p1, p2);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int val : map.values()) {
                result += val * (val - 1);
            }
        }
        return result;
    }

    private static int getDistance(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x * x + y * y;
    }
}
