import java.io.*;
import java.util.*;

public class B_Bad_Boy {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;
        Scan() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (st == null || !st.hasMoreTokens()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) {} } return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int i = sc.nextInt();
            int j = sc.nextInt();

            System.out.println(1 + " " + 1 + " " + n + " " + m);
        }
    }
}
