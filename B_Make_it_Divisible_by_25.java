import java.io.*;
import java.util.*;

public class B_Make_it_Divisible_by_25 {
    static class Scan {
        BufferedReader br;
        StringTokenizer st;

        Scan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int res = 0;
            int res2 = 0;
            long n = sc.nextLong();
            long org = n;
            Queue<Integer> queue = new LinkedList<>();
            while (n > 0) {
                queue.add((int) (n % 10));
                n /= 10;
            }
            // for 5
            int d;
            while (!queue.isEmpty()) {
                d = queue.poll();
                if (d == 5) break;
                res++;
            }
            while (!queue.isEmpty()) {
                d = queue.poll();
                if (d == 2 || d == 7) break;
                res++;
            }
            n = org;
            queue = new LinkedList<>();
            while (n > 0) {
                queue.add((int) (n % 10));
                n /= 10;
            }
            while (!queue.isEmpty()) {
                d = queue.poll();
                if (d == 0) break;
                res2++;
            }
            while (!queue.isEmpty()) {
                d = queue.poll();
                if (d == 5 || d == 0) break;
                res2++;
            }
            out.println(Math.min(res, res2));
        }
        out.flush();
    }
}