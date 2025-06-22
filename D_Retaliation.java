import java.io.*;
import java.util.*;

public class D_Retaliation {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

            long a1 = a[1], an = a[n];
            long numY = an - a1 * n;
            long den = 1L - (long) n * n;

            if (den == 0 || numY % den != 0) {
                System.out.println("NO");
                continue;
            }

            long y = numY / den;
            long x = a1 - y * n;

            if (x < 0 || y < 0) {
                System.out.println("NO");
                continue;
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                long exp = x * i + y * (n - i + 1);
                if (exp != a[i]) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) { e.printStackTrace(); }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
