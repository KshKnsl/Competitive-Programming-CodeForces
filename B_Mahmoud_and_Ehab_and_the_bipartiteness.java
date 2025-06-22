import java.io.*;
import java.util.*;

public class B_Mahmoud_and_Ehab_and_the_bipartiteness 
{
    public static void main(String[] args) 
    {
        Scan sc = new Scan();
        int t = 1;
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n-1; i++) 
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.putIfAbsent(u, new ArrayList<>());
                graph.get(u).add(v);
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(v).add(u);
            }
              int[] color = new int[n+1];
            Arrays.fill(color, -1);
            
            int countA = 0;
            int countB = 0;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            color[1] = 0;
            countA++;
            
            while (!queue.isEmpty()) {
                int node = queue.poll();
                
                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        
                        if (color[neighbor] == 0) countA++;
                        else countB++;
                        
                        queue.add(neighbor);
                    }
                }
            }            
            long result = (long)countA * countB - (n-1);
            out.println(result);
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
