import java.io.*;
import java.util.*;

public class Creature_Hunter {
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long hp = sc.nextLong();

            long dg1 = 0;
            long dg2 = 0;

            for (int i = 0; i < n; i++) {
                int time = sc.nextInt();
                long dg = sc.nextLong();
                if (time == 1)
                    dg1 = Math.max(dg1, dg);
                else
                    dg2 = Math.max(dg2, dg);
            }

            long ans;

            if (dg2 <= 2 * dg1)
                ans = (hp + dg1 - 1) / dg1;
            else 
            {
                long kEven = (hp + dg2 - 1) / dg2;
                long leftHealth = Math.max(0, hp - dg1);
                long timeEven = 2 * kEven;
                long kOdd = (leftHealth + dg2 - 1) / dg2;
                long timeOdd;
                if (leftHealth > 0)
                    timeOdd = 2 * kOdd + 1;
                else
                    timeOdd = 1;
                ans = Math.min(timeEven, timeOdd);
            }

            out.println(ans);
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
