import java.io.*;
import java.util.*;

public class B_Not_Dividing {
    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens())
                try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
        int[][] nextArray2D(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) arr[i][j] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    // Other utility functions if needed

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = sc.nextArray(n);
            
            // Replace 1's with 2's
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    a[i]++;
                }
            }
            
            for (int i = 1; i < n; i++) {
                if (a[i] % a[i - 1] == 0) {
                    a[i]++;
                }
            }
            
            for (int i : a) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
