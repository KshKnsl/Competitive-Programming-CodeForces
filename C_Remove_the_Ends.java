import java.io.*;
import java.util.*;

public class C_Remove_the_Ends {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) {}
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long[] nextArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(next());
            return arr;
        }
    }
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = sc.nextArray(n);
            long[] pre = new long[n];
            long[] suf = new long[n];

            long ans = 0;
            if (arr[0] > 0) {
                pre[0] = arr[0];
            } else {
                pre[0] = 0;
            }
            if (arr[n - 1] < 0) {
                suf[n - 1] = arr[n - 1];
            } else {
                suf[n - 1] = 0;
            }

            for (int i = 1; i < n; i++) {
                if (arr[i] > 0) {
                    pre[i] = pre[i - 1] + arr[i];
                } else {
                    pre[i] = pre[i - 1];
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] < 0) {
                    suf[i] = suf[i + 1] + arr[i];
                } else {
                    suf[i] = suf[i + 1];
                }
            }
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, pre[i] - suf[i]);
            }
            out.println(ans);
        }
        out.flush();
    }
}
