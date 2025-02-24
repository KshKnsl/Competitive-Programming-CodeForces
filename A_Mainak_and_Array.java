import java.io.*;
import java.util.*;

public class A_Mainak_and_Array
{
    static class Scan
    {
        BufferedReader br;
        StringTokenizer st;

        Scan()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        int[] nextArray(int n)
        {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextArray2D(int n, int m)
        {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {

            int n = sc.nextInt();
            int[] a = sc.nextArray(n);
            int ans = Integer.MIN_VALUE;

            for (int i = 0; i < n; ++i)
            {
                ans = Math.max(ans, a[(i - 1 + n) % n] - a[i]);
            }

            for (int i = 1; i < n; ++i)
            {
                ans = Math.max(ans, a[i] - a[0]);
            }

            for (int i = 0; i < n - 1; ++i)
            {
                ans = Math.max(ans, a[n - 1] - a[i]);
            }

            out.println(ans);
        }
        out.flush();
    }

}
