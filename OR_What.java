import java.io.*;
import java.util.*;

public class OR_What {
    static FastReader sc;
    static PrintWriter out;

    public static void main(String[] args) {
        sc = new FastReader();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.close();
    }

    static void solve() {
        int n = sc.nextInt();
        int x = sc.nextInt();
        boolean[] vis = new boolean[n + 1];
        int[] p = new int[n + 1];

        for (int i = n; i >= 1; i--) {
            int j = x | i;
            if (j <= n && !vis[j]) {
                p[i] = j;
                vis[j] = true;

            }
        }
        for (int i = 1; i <= n; i++) {
            if (p[i] == 0) {
                for (int j = 1; j <= n; j++) {
                    if (!vis[j]) {
                        p[i] = j;
                        vis[j] = true;
                        break;
                    }
                }
            }
            out.print(p[i] + " ");
        }
        out.println();
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
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}
