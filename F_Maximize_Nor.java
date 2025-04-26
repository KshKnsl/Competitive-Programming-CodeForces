import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class F_Maximize_Nor {

    // Generic Segment Tree Template with Lazy Propagation
    static class SegmentTree {
        interface Operation {
            int apply(int a, int b);
        }

        private int[] tree, lazy;
        private int size;
        private final int identity;
        private final Operation op;

        public SegmentTree(int n, int identity, Operation op) {
            size = n;
            tree = new int[n * 4];
            lazy = new int[n * 4];
            this.identity = identity;
            this.op = op;
            Arrays.fill(tree, identity);
            Arrays.fill(lazy, identity);
        }

        private void apply(int node, int val) {
            tree[node] = op.apply(tree[node], val);
            lazy[node] = op.apply(lazy[node], val);
        }

        private void push(int node) {
            if (lazy[node] != identity) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = identity;
            }
        }

        private void update(int node, int tl, int tr, int l, int r, int val) {
            if (l > tr || r < tl) {
                return;
            }
            if (l <= tl && tr <= r) {
                apply(node, val);
                return;
            }
            push(node);
            int mid = (tl + tr) / 2;
            update(node * 2, tl, mid, l, r, val);
            update(node * 2 + 1, mid + 1, tr, l, r, val);
            tree[node] = op.apply(tree[node * 2], tree[node * 2 + 1]);
        }

        public void update(int l, int r, int val) {
            update(1, 0, size - 1, l, r, val);
        }

        private void collect(int node, int tl, int tr, int[] res) {
            if (tl >= size) {
                return;
            }
            if (tl == tr) {
                res[tl] = tree[node];
                return;
            }
            push(node);
            int mid = (tl + tr) / 2;
            collect(node * 2, tl, mid, res);
            collect(node * 2 + 1, mid + 1, tr, res);
        }

        public int[] collect() {
            int[] res = new int[size];
            collect(1, 0, size - 1, res);
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            SegmentTree tree = new SegmentTree(n, 0, Math::max);
            List<int[]> curr = new ArrayList<>();
            
            for (int r = 0; r < n; r++) {
                List<int[]> next = new ArrayList<>();
                next.add(new int[]{a[r], r});
                
                int mask = (1 << k) - 1;
                for (int[] pair : curr) 
                {
                    int val = pair[0], st = pair[1];
                    int nor = (~(val | a[r])) & mask;
                    boolean found = false;
                    for (int[] p : next) 
                    {
                        if (p[0] == nor) {
                            if (st < p[1]) {
                                p[1] = st;
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        next.add(new int[]{nor, st});
                    }
                }

                for (int[] pair : next) {
                    tree.update(pair[1], r, pair[0]);
                }

                curr = next;
            }

            int[] ans = tree.collect();
            for (int i = 0; i < n; i++)
                System.out.print(ans[i]+" ");
            System.out.println();
        }

        sc.close();
    }
    
    static int nor(int a, int b, int k)
    {
        return (~(a | b)) & ((1 << k) - 1);
    }
 
    static class Pair
    {
        int val, idx;
        Pair(int v, int i)
        {
            val = v;
            idx = i;
        }
    }
 
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
}
