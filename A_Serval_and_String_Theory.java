import java.io.*;
import java.util.*;

public class A_Serval_and_String_Theory
{
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            String rev = new StringBuilder(s).reverse().toString();

            if (s.compareTo(rev) < 0)
            {
                out.println("YES");
                continue;
            }

            boolean allSameChar = true;
            for (int i = 1; i < s.length(); i++)
            {
                if (s.charAt(i) != s.charAt(0))
                {
                    allSameChar = false;
                    break;
                }
            }

            if (allSameChar)
            {
                out.println("NO");
                continue;
            }

            if (k >= 1)
                out.println("YES");
            else
                out.println("NO");
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

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
