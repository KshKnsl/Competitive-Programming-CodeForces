import java.io.*;
import java.util.*;

public class A_Exciting_Bets
{
    static class Scan
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next()
        {
            while (st == null || !st.hasMoreTokens())
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
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
    static final int MOD = 1000000007;

    static int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long modMul(long a, long b)
    {
        return (a % MOD * b % MOD) % MOD;
    }

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == b)
                out.println("0 0");
            else
            {
                long g = Math.abs(a - b);
                long m = Math.min(a % g, g - a % g);
                out.println(g + " " + m);
            }
        }
        out.close();
    }
}
