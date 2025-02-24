import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class B_Comparison_String
{
    static class Scan
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next()
        {
            while (st == null || !st.hasMoreTokens())
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        int[] nextArray(int n)
        {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextArray2D(int n, int m)
        {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    static int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b)
    {
        return (a / gcd((int) a, (int) b)) * b;
    }

    static long modAdd(long a, long b)
    {
        return (a % MOD + b % MOD) % MOD;
    }

    static long modSub(long a, long b)
    {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    static long modMul(long a, long b)
    {
        return (a % MOD * b % MOD) % MOD;
    }

    static int modExpo(int a, int b)
    {
        if (b == 0)
            return 1;
        int res = modExpo(a, b / 2);
        res = (int) modMul(res, res);
        return (b % 2 != 0) ? (int) modMul(res, a) : res;
    }

    static int modInv(int a)
    {
        return modExpo(a, MOD - 2);
    }

    static int modDiv(int a, int b)
    {
        return (int) modMul(a, modInv(b));
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    static boolean isSorted(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;
        return true;
    }

    static boolean[] sieve(int n)
    {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        return isPrime;
    }

    static int countDigits(int x)
    {
        int count = 0;
        while (x > 0)
        {
            count++;
            x /= 10;
        }
        return count;
    }

    static long factorial(int n)
    {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = modMul(res, i);
        return res;
    }

    static long nCr(int n, int r)
    {
        if (r > n)
            return 0;
        long num = factorial(n);
        long denom = modMul(factorial(r), factorial(n - r));
        return modDiv((int) num, (int) denom);
    }

    static int lowerBound(int[] arr, int x)
    {
        int low = 0, high = arr.length;
        while (low < high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    static int upperBound(int[] arr, int x)
    {
        int low = 0, high = arr.length;
        while (low < high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private static long sqrt(long x)
    {
        long left = 0, right = Long.MAX_VALUE;
        while (right > left)
        {
            long mid = (left + right) / 2;
            if (mid * mid > x)
                right = mid;
            else
                left = mid + 1;
        }
        return left - 1;
    }

    private static long pow(long base, long exponent)
    {
        long result = 1;
        while (exponent > 0)
        {
            if ((exponent & 1) == 1)
                result *= base;
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    private static <T extends Comparable<T>> void sort(T[] arr)
    {
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
    }

    private static <T extends Comparable<T>> void rsort(T[] arr)
    {
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
    }

    static long nCr(long n, long r)
    {
        long answer = 1, k = min(r, n - r);
        for (long i = 0; i < k; i++)
        {
            answer = (answer % MOD * (n - i) % MOD) % MOD;
            answer = divide(answer, i + 1);
        }
        return answer % MOD;
    }

    static long divide(long a, long b)
    {
        return (a % MOD * (power(b, MOD - 2) % MOD)) % MOD;
    }

    private static void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swap(long[] a, int i, int j)
    {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swap(char[] a, int i, int j)
    {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void reverse(int[] a)
    {
        int i = 0, j = a.length - 1;
        while (i < j)
            swap(a, i++, j--);
    }

    private static void reverse(long[] a)
    {
        int i = 0, j = a.length - 1;
        while (i < j)
            swap(a, i++, j--);
    }

    private static void reverse(char[] a)
    {
        int i = 0, j = a.length - 1;
        while (i < j)
            swap(a, i++, j--);
    }

    private static long power(long a, long b)
    {
        if (b == 0)
            return 1L;
        long ans = power(a, b / 2);
        ans = modMul(ans, ans);
        return (b % 2 != 0) ? modMul(ans, a) : ans;
    }


    public static void main(String[] args)
    {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int ans = 1, cur = 1;
            for (int i = 1; i < n; i++)
            {
                if (s.charAt(i) != s.charAt(i - 1))
                    cur = 1;
                else
                    cur++;
                ans = Math.max(ans, cur);
            }
            out.println(ans + 1);
        }
        out.close();

    }
}
