import java.io.*;
import java.util.*;

public class C_Median_Splits 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = sc.nextArray(n);
            boolean possible = false;
            // Check if there is at least one element less than or equal to k
            boolean has_le_k = false;
            for (int x : arr) {
                if (x <= k) {
                    has_le_k = true;
                    break;
                }
            }

            // If no element is <= k, it's impossible
            if (!has_le_k) {
                possible = false;
            } else {
                // If n < 3, we cannot split into 3 subarrays
                if (n < 3) {
                     possible = false;
                }
                // Check if there are two adjacent elements <= k
                else {
                    for (int i = 0; i < n - 1; i++) {
                        if (arr[i] <= k && arr[i + 1] <= k) {
                            possible = true;
                            break;
                        }
                    }
                    // If no adjacent pair, check for elements with distance 2 that are <= k
                    if (!possible) {
                        for (int i = 0; i < n - 2; i++) {
                            if (arr[i] <= k && arr[i + 2] <= k) {
                                possible = true;
                                break;
                            }
                        }
                    }
                }
                 // If has_le_k is true, but n < 3 or neither pattern (adjacent or dist 2) is found,
                 // possible remains false, which is the correct outcome for those cases.
            }

            if (possible) {
                out.println("yes");
            } else {
                out.println("no");
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
