import java.io.*;
import java.util.*;

public class B_SUMdamental_Decomposition 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        // Read T
        int t = sc.nextInt();

        while (t-- > 0) 
        {
            long n = sc.nextLong();
            long x = sc.nextLong();

            if (n == 1) 
            {
                out.println(x > 0 ? x : -1);
                continue;
            }

            long ans = Long.MAX_VALUE;
            int maxk = (int) Math.min(n, 30);

            for (int k = 1; k <= maxk; k++) 
            {
                int xorOnes = (int) ((n - k) & 1);
                long r = x ^ xorOnes;
                long lz = Long.MAX_VALUE;

                if (k == 1) 
                {
                    if (r > 0) 
                        lz = r;
                } 
                else if (k == 2 && r == 0) 
                    lz = 2; 
                else if (k == 2) 
                {
                    int p = Long.bitCount(r);
                    if (p >= 2) 
                        lz = r; 
                    else 
                    {
                        for (int bit = 0; bit < 31; bit++) 
                        {
                            if (((r >> bit) & 1) == 0) 
                            {
                                lz = r + 2 * (1L << bit);
                                break;
                            }
                        }
                        if (lz == Long.MAX_VALUE) 
                            lz = r + 2;
                    }
                } 
                else if (r == 0 && k == 3)
                    lz = 6;
                else if (Long.bitCount(r) >= k)
                    lz = r;
     
                if (lz < Long.MAX_VALUE)
                    ans = Math.min(ans, (n - k) + lz);
            }

            out.println(ans == Long.MAX_VALUE ? -1 : ans);
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
                } 
                catch (IOException e) 
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

        long nextLong() 
        {
            return Long.parseLong(next());
        }
    }
}
