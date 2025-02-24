import java.io.*;
import java.util.*;

public class A_Array_Coloring {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
    }
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd((int) a, (int) b)) * b; }
    static long modAdd(long a, long b) { return (a % MOD + b % MOD) % MOD; }
   
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int odd = 0;
            int n = sc.nextInt();
            int[] arr = sc.nextArray(n);
            for (int i : arr) {
                if (i % 2 == 1) odd++;
            }
            String res = (odd % 2 == 0) ? "YES" : "NO";
            out.println(res);
        }
        out.flush();
    }
}