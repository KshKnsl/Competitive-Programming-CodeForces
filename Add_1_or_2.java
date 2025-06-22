import java.io.*;
import java.util.*;

public class Add_1_or_2 {

    static boolean can(long m, int n, long[] a, long[] b) {
        long offload = 0;
        long absorb = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > m) {
                return false;
            }
            long limit = m - a[i];
            if (b[i] > limit) {
                offload += b[i] - limit;
            } else {
                absorb += (limit - b[i]) / 2;
            }
        }
        return absorb >= offload;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            long sumB = 0;
            long maxA = 0;

            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                maxA = Math.max(maxA, a[i]);
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
                sumB += b[i];
            }

            long lo = maxA;
            long hi = maxA + sumB;
            long res = hi;

            while (lo <= hi) {
                long m = lo + (hi - lo) / 2;
                if (can(m, n, a, b)) {
                    res = m;
                    hi = m - 1;
                } else {
                    lo = m + 1;
                }
            }
            out.println(res);
        }
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
