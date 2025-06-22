import java.io.*;
import java.util.*;

public class Grid_Path_Easy 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int q = sc.nextInt();
            String r1 = sc.next();
            String r2 = sc.next();

            List<Long> o1 = new ArrayList<>();
            List<Long> o2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (r1.charAt(i) == '1') o1.add((long)i + 1);
                if (r2.charAt(i) == '1') o2.add((long)i + 1);
            }

            long[] ps1 = new long[o1.size() + 1];
            for (int i = 0; i < o1.size(); i++) {
                ps1[i + 1] = ps1[i] + o1.get(i);
            }

            long[] ps2 = new long[o2.size() + 1];
            long ts2 = 0;
            for (int i = 0; i < o2.size(); i++) {
                ps2[i + 1] = ps2[i] + o2.get(i);
                ts2 += o2.get(i);
            }

            long min = Long.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                long n1 = i;
                long n2 = n - i + 1;

                if (o1.size() < n1 || o2.size() < n2) {
                    continue;
                }

                long s1 = ps1[(int)n1];
                long t1 = n1 * (n1 + 1) / 2;
                long c1 = s1 - t1;

                long s2 = ts2 - ps2[o2.size() - (int)n2];
                long t2 = ((long)n * (n + 1) / 2) - ((long)(i - 1) * i / 2);
                long c2 = t2 - s2;
                
                min = Math.min(min, c1 + c2);
            }

            if (min == Long.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(min);
            }
        }
        out.close();
    }

    static class Scan 
    {
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

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd((int) a, (int) b)) * b; }
    static long modAdd(long a, long b) { return (a % MOD + b % MOD) % MOD; }
    static long modSub(long a, long b) { return (a % MOD - b % MOD + MOD) % MOD; }
    static long modMul(long a, long b) { return (a % MOD * b % MOD) % MOD; }
    static int modExpo(int a, int b) { if (b == 0) return 1; int res = modExpo(a, b / 2); res = (int) modMul(res, res); return (b % 2 != 0) ? (int) modMul(res, a) : res; }
    static int modInv(int a) { return modExpo(a, MOD - 2); }
    static int modDiv(int a, int b) { return (int) modMul(a, modInv(b)); }

    static boolean[] sieve(int n) { boolean[] isPrime = new boolean[n + 1]; Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false; for (int i = 2; i * i <= n; i++) if (isPrime[i]) for (int j = i * i; j <= n; j += i) isPrime[j] = false; return isPrime; }
    static int countDigits(int x) { int count = 0; while (x > 0) { count++; x /= 10; } return count; }
    static long factorial(int n) { long res = 1; for (int i = 2; i <= n; i++) res = modMul(res, i); return res; }
    static long nCr(int n, int r) { if (r > n) return 0; long num = factorial(n); long denom = modMul(factorial(r), factorial(n - r)); return modDiv((int) num, (int) denom); }
    static int lowerBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] < x) low = mid + 1; else high = mid; } return low; }
    static int upperBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] <= x) low = mid + 1; else high = mid; } return low; }
}
