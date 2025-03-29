import java.io.*;
import java.util.*;

public class C_Stable_Groups
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

        long[] nextArray(int n)
        {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
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

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int res = 1;
        ArrayList<Long> groupsdiff = new ArrayList<>();
        int n = sc.nextInt();
        long k = sc.nextLong();
        long x = sc.nextLong();
        long arr[] = sc.nextArray(n);
        Arrays.sort(arr);
        for (int i = 1; i < n; i++)
        {
            if (arr[i] - arr[i - 1] <= x)
                continue;
            else
            {
                res++;
                groupsdiff.add((long)(((arr[i] - arr[i - 1])-1)/x));
            }
        }
        
        groupsdiff.sort(Long::compare);
        // out.println(groupsdiff);
        // out.println(res);
        for(long i: groupsdiff)
        {
            if(k>=i)
            {
                k-=i;
                res--;
            }
        }
        out.println(res);
        out.close();
    }
}
