import java.io.*;
import java.util.*;
public class A_Minimal_Coprime {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
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
    
    static boolean isPrime(int n) { if (n <= 1) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }
    static boolean isSorted(int[] arr) { for (int i = 0; i < arr.length - 1; i++) if (arr[i] > arr[i + 1]) return false; return true; }

    static boolean[] sieve(int n) { boolean[] isPrime = new boolean[n + 1]; Arrays.fill(isPrime, true); isPrime[0] = isPrime[1] = false; for (int i = 2; i * i <= n; i++) { if (isPrime[i]) { for (int j = i * i; j <= n; j += i) isPrime[j] = false; } } return isPrime; }
    static int countDigits(int x) { int count = 0; while (x > 0) { count++; x /= 10; } return count; }
    static long factorial(int n) { long res = 1; for (int i = 2; i <= n; i++) res = modMul(res, i); return res; }
    static int[] prefixSumArray(int[] arr) { int n = arr.length; int[] prefixSum = new int[n]; prefixSum[0] = arr[0]; for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + arr[i]; return prefixSum; }
    static int[][] prefixSum2D(int[][] arr) { int n = arr.length, m = arr[0].length; int[][] prefixSum = new int[n][m]; prefixSum[0][0] = arr[0][0]; for (int i = 1; i < n; i++) prefixSum[i][0] = prefixSum[i - 1][0] + arr[i][0]; for (int j = 1; j < m; j++) prefixSum[0][j] = prefixSum[0][j - 1] + arr[0][j]; for (int i = 1; i < n; i++) for (int j = 1; j < m; j++) prefixSum[i][j] = arr[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]; return prefixSum; }
    static long nCr(int n, int r) { if (r > n) return 0; long num = factorial(n); long denom = modMul(factorial(r), factorial(n - r)); return modDiv((int) num, (int) denom); }
    static int lowerBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] < x) low = mid + 1; else high = mid; } return low; }
    static int upperBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] <= x) low = mid + 1; else high = mid; } return low; }

    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            
            int a= sc.nextInt();
            int b= sc.nextInt();
            if(a==1 && b==1) out.println(1);
            else out.println(b-a); 
        }
        out.flush();
    }
}