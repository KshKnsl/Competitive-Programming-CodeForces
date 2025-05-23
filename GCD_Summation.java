import java.io.*;
import java.util.*;

public class GCD_Summation {
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        
        // Pre-generate primes once
        int maxN = 200_000;  // Constraints mention n ≤ 200,000
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = sieve(1_000_000);  // A reasonable upper bound
        for (int i = 2; i < 1_000_000 && primes.size() < maxN; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if (n == 1) {
                out.println(k == 0 ? 1 : -1);
                continue;
            }

            if (k < n - 1) {
                out.println(-1);
                continue;
            }
            
            if (n == 2) {
                int g = k;
                out.println(g + " " + (2 * g));
                continue;
            }
            
            if (k == n - 1) {
                for (int i = 1; i <= n; i++) {
                    out.print(i + " ");
                }
                out.println();
                continue;
            }
            
            int g = k - (n - 2);
            
            // First n-2 numbers
            int count = 0;
            for (int i = 0; count < n - 2; i++) {
                // Use large primes that definitely won't divide g
                int num = primes.get(i);
                if (g < num || g % num != 0) {
                    out.print(num + " ");
                    count++;
                }
            }
            
            // Last two numbers
            out.println(g + " " + (2 * g));
        }
        out.close();
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens())
                try {
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

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextArray2D(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd((int) a, (int) b)) * b;
    }

    static long modAdd(long a, long b) {
        return (a % MOD + b % MOD) % MOD;
    }

    static long modSub(long a, long b) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    static long modMul(long a, long b) {
        return (a % MOD * b % MOD) % MOD;
    }

    static int modExpo(int a, int b) {
        if (b == 0)
            return 1;
        int res = modExpo(a, b / 2);
        res = (int) modMul(res, res);
        return (b % 2 != 0) ? (int) modMul(res, a) : res;
    }

    static int modInv(int a) {
        return modExpo(a, MOD - 2);
    }

    static int modDiv(int a, int b) {
        return (int) modMul(a, modInv(b));
    }

    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        return isPrime;
    }

    static int countDigits(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = modMul(res, i);
        return res;
    }

    static long nCr(int n, int r) {
        if (r > n)
            return 0;
        long num = factorial(n);
        long denom = modMul(factorial(r), factorial(n - r));
        return modDiv((int) num, (int) denom);
    }

    static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
