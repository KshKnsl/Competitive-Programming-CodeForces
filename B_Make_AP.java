import java.io.*;
import java.util.*;

public class B_Make_AP {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void solveTest(Scan sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int new_a = b - (c - b);
        if (new_a >= a && new_a % a == 0 && new_a != 0) {
            out.println("YES");
            return;
        }

        int new_b = a + (c - a) / 2;
        if (new_b >= b && (c - a) % 2 == 0 && new_b % b == 0 && new_b != 0) {
            out.println("YES");
            return;
        }

        int new_c = a + 2 * (b - a);
        if (new_c >= c && new_c % c == 0 && new_c != 0) {
            out.println("YES");
            return;
        }

        out.println("NO");
    }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            solveTest(sc);
        }
        out.flush();
    }
}
