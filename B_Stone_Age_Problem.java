import java.io.*;
import java.util.*;

public class B_Stone_Age_Problem {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] a = new long[n + 1];
        int[] b = new int[n + 1];
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            sum += a[i];
        }

        int flag = 0;
        long now = 0;

        for (int i = 1; i <= q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int x = sc.nextInt();
                long y = sc.nextLong();
                if (b[x] < flag) {
                    sum -= now;
                } else {
                    sum -= a[x];
                }
                a[x] = y;
                sum += y;
                b[x] = i;
            } else {
                long x = sc.nextLong();
                sum = x * n;
                flag = i;
                now = x;
            }
            out.println(sum);
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
            while (st == null || !st.hasMoreTokens()) {
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
    }
}
