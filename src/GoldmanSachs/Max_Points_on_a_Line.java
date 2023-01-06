package GoldmanSachs;

import java.awt.*;
import java.util.*;
public class Max_Points_on_a_Line {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 1;
            int sameX = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                } else if (points[i].x == points[j].x) {
                    sameX++;
                } else {
                    int a = points[j].y - points[i].y;
                    int b = points[j].x - points[i].x;
                    int gcd = gcd(a, b);
                    a /= gcd;
                    b /= gcd;
                    int key = a * 20001 + b;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
            }
            result = Math.max(result, max + samePoint);
            result = Math.max(result, sameX + samePoint);
            map.clear();
        }
        return result;
    }





    private Map<Integer, Integer> map = new HashMap<>();
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
