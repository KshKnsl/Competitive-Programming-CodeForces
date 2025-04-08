import java.io.*;
import java.util.*;

public class Balls_and_Boxes {
    static final int MOD = 998244353;
    static final int MAX = 1500000;
    static long[] f, invf;
    
    public static void main(String[] args) {
        precomp();   
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = sc.nextArray(n + 1);
            long s = 0;
            for (int i = 0; i < n; i++) {
                s += a[i];
            }
            
            long ways1 = help(s, Arrays.copyOf(a, n));
            long ways2 = f[(int) (s + a[n])] * invf[(int) s] % MOD;
            System.out.println(ways1+"\t"+ways2);
            long res = (ways1 * ways2) % MOD;
            out.println(res);
        }
        out.close();
    }
    
    private static void precomp() {
        f = new long[MAX + 1];
        invf = new long[MAX + 1];
        
        f[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            f[i] = f[i - 1] * i % MOD;
        }

        invf[MAX] = modInv(f[MAX]);
        for (int i = MAX - 1; i >= 0; i--) {
            invf[i] = invf[i + 1] * (i + 1) % MOD;
        }
    }

    private static long help(long s, int[] a) {
        long r = f[(int) s];
        for (int x : a) {
            r = r * invf[x] % MOD;
        }
        return r;
    }

    private static long modInv(long x) {
        return pow(x, MOD - 2);
    }

    private static long pow(long b, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() { while (st == null || !st.hasMoreTokens()) try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        int[] nextArray(int n) { int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = nextInt(); return a; }
        int[][] nextArray2D(int n, int m) { int[][] a = new int[n][m]; for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = nextInt(); return a; }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
