import java.io.*;
import java.util.*;

public class Distinct_Representations {
    static FastReader sc;
    static PrintWriter out;

    static final int MOD = 998244353;
    static int[] dp = new int[200000];

    public static void main(String[] args) {
        sc = new FastReader();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++)
            dp[i] = (dp[i - 1] + dp[i - 3]) % MOD;

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            long res = 1;
            int i = 0;

            while (i < n) {
                int j = i;
                while (j + 1 < n && s.charAt(j) != s.charAt(j + 1))
                    j++;
                int len = j - i + 1;
                if (len >= 4)
                    res = res * dp[len - 3] % MOD;
                i = j + 1;
            }
            out.println(res);
        }
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        char[] nextCharArray(int n) {
            char[] arr = next().toCharArray();
            return arr;
        }
    }

    // Utility Functions
    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    static long modInverse(long n) {
        return power(n, MOD - 2);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static List<Integer> sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    static long nCr_mod_p(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n)
            return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    static void precomputeFactorials(int maxN, long[] fact, long[] invFact) {
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = modInverse(fact[i]);
        }
    }

    static int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
