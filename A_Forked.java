import java.util.*;

public class A_Forked
{

    static class Point
    {
        int x, y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (!(obj instanceof Point))
                return false;
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dx =
        { -1, 1, -1, 1 };
        int[] dy =
        { -1, -1, 1, 1 };
        while (t-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            HashSet<Point> set1 = new HashSet<>();
            HashSet<Point> set2 = new HashSet<>();
            for (int i = 0; i < 4; i++)
            {
                set1.add(new Point(x1 + dx[i] * a, y1 + dy[i] * b));
                set1.add(new Point(x1 + dx[i] * b, y1 + dy[i] * a));
                set2.add(new Point(x2 + dx[i] * a, y2 + dy[i] * b));
                set2.add(new Point(x2 + dx[i] * b, y2 + dy[i] * a));
            }
            int res = 0;
            for (Point pos : set1)
                if (set2.contains(pos))
                    res++;
            System.out.println(res);
        }
        sc.close();
    }
}
