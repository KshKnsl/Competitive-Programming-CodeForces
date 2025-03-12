import java.io.*;
import java.util.*;

public class B_Collecting_Game {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
        int[][] nextArray2D(int n, int m) { int[][] arr = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextInt(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scan sc = new Scan();
        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int n = sc.nextInt();
            Pair[] arr = new Pair[n + 1];
            for (int i = 1; i <= n; i++) {
                int ff = sc.nextInt();
                arr[i] = new Pair(ff, i);
            }
            Arrays.sort(arr, 1, n + 1, Comparator.comparingInt(p -> p.ff));
            int[] nxt = new int[n + 1];
            long[] sum = new long[n + 1];
            int[] ans = new int[n + 1];
            nxt[0] = 0;
            sum[0] = 0;
            for (int i = 1; i <= n; i++) {
                if (nxt[i - 1] >= i) {
                    nxt[i] = nxt[i - 1];
                    sum[i] = sum[i - 1];
                } else {
                    sum[i] = sum[i - 1] + arr[i].ff;
                    nxt[i] = i;
                    while (nxt[i] + 1 <= n && sum[i] >= arr[nxt[i] + 1].ff) {
                        nxt[i]++;
                        sum[i] += arr[nxt[i]].ff;
                    }
                }
                ans[arr[i].ss] = nxt[i];
            }
            for (int i = 1; i <= n; i++) {
                out.print((ans[i] - 1) + " ");
            }
            out.println();
        }
        out.close();
    }

    static class Pair {
        int ff, ss;
        Pair(int ff, int ss) {
            this.ff = ff;
            this.ss = ss;
        }
    }
}
