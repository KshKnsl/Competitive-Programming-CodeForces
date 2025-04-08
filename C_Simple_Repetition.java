import java.io.*;
import java.util.*;

public class C_Simple_Repetition 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int x = sc.nextInt();
            int k = sc.nextInt();
            if (k == 1)
                out.println(isPrime(x) ? "YES" : "NO");
            else if (x == 1 && k == 2) 
                out.println("YES");
            else if (x == 1 && k > 2)
                out.println("NO");
            else
                out.println("NO");
        }
        out.close();
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
