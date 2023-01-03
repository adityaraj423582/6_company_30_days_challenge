package Microsoft;

public class Perfect_Rectangle {
    public static void main(String[] args) {
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(isRectangleCover(rectangles));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rectangle : rectangles) {
            x1 = Math.min(x1, rectangle[0]);
            y1 = Math.min(y1, rectangle[1]);
            x2 = Math.max(x2, rectangle[2]);
            y2 = Math.max(y2, rectangle[3]);
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }
        if (area != (x2 - x1) * (y2 - y1)) {
            return false;
        }
        int[] count = new int[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (count[j] == 1) {
                    continue;
                }
                if (isOverlap(rectangles[i], rectangles[j])) {
                    count[i]++;
                    count[j]++;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOverlap(int[] r1, int[] r2) {
        if (r1[0] >= r2[2] || r1[2] <= r2[0] || r1[1] >= r2[3] || r1[3] <= r2[1]) {
            return false;
        }
        return true;
    }
}
