package challenges.Problem2101;

class Point {
    int x, y, radius;
    Point(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
public class Solution {
    boolean isPointInCircle(Point point, Point center) {
        double distance = Math.sqrt(Math.pow(point.x - center.x, 2) + Math.pow(point.y - center.y, 2));
        return distance <= center.radius;
    }
    int detonate(int i, boolean[] isDetonated, Point[] points) {
        isDetonated[i] = true;
        int ans = 1;
        for(int index = 0; index<points.length; index++) {
            if(!isDetonated[index] && isPointInCircle(points[index], points[i])) {
                ans += detonate(index, isDetonated, points);
            }
        }
        return ans;
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Point[] points = new Point[n];
        for(int i=0; i<n; i++) {
            points[i] = new Point(bombs[i][0], bombs[i][1], bombs[i][2]);
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, detonate(i, new boolean[n], points));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}) );
    }
}