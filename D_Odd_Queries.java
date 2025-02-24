import java.io.*;
import java.util.*;

public class D_Odd_Queries
{
    static class Scan
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] a = new long[n + 1];
            long[] pre = new long[n + 1];
            pre[0] = 0;
            for (int i = 1; i <= n; i++)
            {
                a[i] = sc.nextLong();
                pre[i] = pre[i - 1] + a[i];
            }
            for (int i = 0; i < q; i++)
            {
                int l = (int) sc.nextLong();
                int r = (int) sc.nextLong();
                long k = sc.nextLong();
                long tot = pre[n];
                long removedSum = pre[r] - pre[l - 1];
                long ans = tot - removedSum + k * (r - l + 1);
                out.println((ans & 1) == 1 ? "YES" : "NO");
            }
        }
        out.close();
    }
}