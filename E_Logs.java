import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class E_Logs {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        long[] nextArray(int n) { long[] arr = new long[n]; for (int i = 0; i < n; i++) arr[i] = nextLong(); return arr; }
        long[][] nextArray2D(int n, int m) { long[][] arr = new long[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextLong(); return arr; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scan sc = new Scan();
        long res = 0;
        int n = sc.nextInt();
        long k = sc.nextLong();
        long arr[] = sc.nextArray(n);
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = max(max, arr[i]);
        }
        res = max;
        long left = 1, right = max;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isPossible(arr, mid, k)) {
            right = mid;
            } else {
            left = mid + 1;
            }
        }
        res = left;
        out.println(res);
        out.close();
    }

    static boolean isPossible(long arr[], long x, long k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                k -= (arr[i] - 1) / x;
            }
        }
        return k >= 0;
    }
}
