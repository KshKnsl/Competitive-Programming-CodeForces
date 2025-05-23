
import java.io.*;
import java.util.*;

public class C_Paint_the_Array {

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long arr[] = sc.nextArray(n);
            long gcd1 = arr[0];
            long gcd2 = arr[1];
            for (int i = 2; i < n; i++) {
                if (i % 2 == 0) {
                    gcd1 = gcd(gcd1, arr[i]);
                } else {
                    gcd2 = gcd(gcd2, arr[i]);
                }
            }

            boolean valid1 = true;
            boolean valid2 = true;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0 && arr[i] % gcd2 == 0) {
                    valid2 = false;
                }
                if (i % 2 == 1 && arr[i] % gcd1 == 0) {
                    valid1 = false;
                }
            }
            long ans = 0;
            if (valid1) {
                ans = gcd1;
            }
            if (valid2) {
                ans = Math.max(ans, gcd2);
            }

            System.out.println(ans);
        }
        out.close();
    }

    static class Scan {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            
            }return arr;
        }

        int[][] nextArray2D(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextInt();
            
                }
            }return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
