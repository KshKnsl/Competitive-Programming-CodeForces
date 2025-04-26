
import java.io.*;
import java.util.*;

public class C_Chat_Ban {

    public static void main(String[] args) {
        Scan sc = new Scan();
        long t = sc.nextLong();
        while (t-- > 0) {
            long k = sc.nextLong();
            long x = sc.nextLong();
            long res = 0;

            for (long mid = 1; mid <= 2 * k - 1; mid++) {
                if (mid >= k) {
                    long sum = get(k) + get(k - 1) - get(2 * k - 1 - mid);
                    if (sum >= x) {
                        res = mid;
                        break;
                    }
                } else {
                    long sum = get(mid);
                    if (sum >= x) {
                        res = mid;
                        break;
                    }
                }
            }

            out.println(res);
        }
        out.close();
    }

    static long get(long n) {
        return n * (n + 1) / 2;
    }

    static class Scan {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
