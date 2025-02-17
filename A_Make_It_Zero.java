import java.io.*;
import java.util.*;

public class A_Make_It_Zero {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        int[] nextArray(int n) { int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = nextInt(); return arr; }
    }
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void solve() {
        Scan sc = new Scan();
        int t = sc.nextInt(); // Read number of test cases
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = sc.nextArray(n);
            
            if (n % 2 != 0) {
                out.println("4");
                out.println("1 " + (n - 1));
                out.println("1 " + (n - 1));
                out.println((n - 1) + " " + n);
                out.println((n - 1) + " " + n);
            } else {
                out.println("2");
                out.println("1 " + n);
                out.println("1 " + n);
            }
        }
        out.flush();
    }

    public static void main(String[] args) {
        solve();
    }
}
