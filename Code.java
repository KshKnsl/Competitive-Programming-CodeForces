import java.util.*;
import java.io.*;

class CodeChef {

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


    static class Thief implements Comparable<Thief> {
        int idx; 
        int lvl;
        long cns;

        public Thief(int originalIndex, int level, long coins) {
            this.idx = originalIndex;
            this.lvl = level;
            this.cns = coins;
        }

        @Override
        public int compareTo(Thief other) {
            
            return Integer.compare(this.lvl, other.lvl);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder(); 

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Thief[] ths = new Thief[n];
            
            int[] lvlsIn = new int[n];
            for (int i = 0; i < n; i++) {
                lvlsIn[i] = sc.nextInt();
            }
            
            for (int i = 0; i < n; i++) {
                long cnsIn = sc.nextLong();
                ths[i] = new Thief(i, lvlsIn[i], cnsIn);
            }

            Arrays.sort(ths); 

            long[] ans = new long[n];
            
            PriorityQueue<Long> pq = new PriorityQueue<>(); 
            long curSum = 0L; 

            for (int i = 0; i < n; i++) {
                Thief curTh = ths[i];
                
                
                ans[curTh.idx] = curSum;

                
                
                
                if (pq.size() < k) {
                    pq.add(curTh.cns);
                    curSum += curTh.cns;
                } else { 
                         
                    if (curTh.cns > pq.peek()) {
                        curSum -= pq.poll(); 
                        pq.add(curTh.cns);       
                        curSum += curTh.cns;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                sb.append(ans[i]);
                if (i < n - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}