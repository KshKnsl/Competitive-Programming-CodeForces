import java.io.*;
import java.util.*;

public class A_Jellyfish_and_Undertale
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
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int T = sc.nextInt();
        while (T-- > 0)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            long ans = b;
            for (int i = 0; i < n; i++)
            {
                int x = sc.nextInt();
                ans += Math.min(a - 1, x);
            }
            out.println(ans);
        }
        out.close();
    }
}
