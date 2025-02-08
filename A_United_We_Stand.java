import java.io.*;
import java.util.*;
public class A_United_We_Stand {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        long[] nextArray() {
            int n = nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
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
    static long nCr(int n, int r) { if (r > n) return 0; long num = factorial(n); long denom = modMul(factorial(r), factorial(n - r)); return modDiv((int) num, (int) denom); }
    static int lowerBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] < x) low = mid + 1; else high = mid; } return low; }
    static int upperBound(int[] arr, int x) { int low = 0, high = arr.length; while (low < high) { int mid = (low + high) / 2; if (arr[mid] <= x) low = mid + 1; else high = mid; } return low; }

    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        Scanner scanner = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int res = 0;
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            if(arr[0]==arr[n-1])
            {
                out.println(-1); 
            }
            else
            {
                int cur=0;
                while(arr[cur]==arr[0]) cur++;
                out.println(cur+" "+(n-cur));
                for (int j = 0; j < cur; ++j) out.print(arr[j] + " ");
                out.println();
                for (int j = cur; j < n; ++j) out.print(arr[j] + " ");
                out.println();
            }
        }
        out.flush();
        scanner.close();
    }
}