import java.io.*;
import java.util.*;

public class D_Distinct_Split
{
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();

            int[] cnt = new int[26];
            for (char c : s.toCharArray())
            {
                cnt[c - 'a']++;
            }

            int[] p = new int[26];

            int ans = 0;
            for (char c : s.toCharArray())
            {
                cnt[c - 'a']--;
                p[c - 'a']++;

                int cur = 0;
                for (int i = 0; i < 26; i++)
                {
                    cur += Math.min(1, cnt[i]) + Math.min(1, p[i]);
                }

                ans = Math.max(ans, cur);
            }

            out.println(ans);
        }
        out.close();
    }

    static class Scan
    {
        BufferedReader br;
        StringTokenizer st;

        public Scan()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }
}
