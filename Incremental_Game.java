import java.io.*;
import java.util.*;

public class Incremental_Game
{
    static Boolean[][][] memo = new Boolean[21][21][401];

    static boolean dfs(int x, int y, int prev)
    {
        if (memo[x][y][prev] != null)
            return memo[x][y][prev];

        boolean win = false;
        if (x > 0)
        {
            for (int t = prev + 1; t <= x; t++)
            {
                if (!dfs(x - t, y, t))
                {
                    win = true;
                    break;
                }
            }
        }
        if (!win && y > 0)
        {
            for (int t = prev + 1; t <= y; t++)
            {
                if (!dfs(x, y - t, t))
                {
                    win = true;
                    break;
                }
            }
        }

        return memo[x][y][prev] = win;
    }

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            boolean win = false;

            for (int t1 = 1; t1 <= k; t1++)
            {
                if (t1 <= x && !dfs(x - t1, y, t1))
                {
                    win = true;
                    break;
                }
                if (t1 <= y && !dfs(x, y - t1, t1))
                {
                    win = true;
                    break;
                }
            }

            out.println(win ? "Alice" : "Bob");
        }
        out.close();
    }

    static class Scan
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next()
        {
            while (st == null || !st.hasMoreTokens())
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
