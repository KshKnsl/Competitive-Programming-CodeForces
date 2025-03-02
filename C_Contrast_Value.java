import java.io.*;
import static java.lang.Math.*;
import java.util.*;

public class C_Contrast_Value {
    static class Scan {
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

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int res=0;
            int n = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (stack.isEmpty() || stack.peek() != x) {
                    stack.push(x);
                }
            }
            
            List<Integer> a = new ArrayList<>(stack);
            int size = a.size();
            int ans = size;
            
            for (int i = 0; i + 2 < size; i++) {
                if ((a.get(i) < a.get(i + 1) && a.get(i + 1) < a.get(i + 2)) ||
                    (a.get(i) > a.get(i + 1) && a.get(i + 1) > a.get(i + 2))) {
                    ans--;
                }
            }
            out.println(ans);
        }
        out.close();
    }
}
            
            
      