import java.io.*;
import java.util.*;

public class A_Johnny_and_Ancient_Computer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
            if (a > b) { long temp = a; a = b; b = temp; }
            if (reduce(a) != reduce(b)) {
                out.println("-1");
            } else {
                int ans = 0;
                b /= a;
                while (b > 1) { b = (b % 8 == 0) ? b / 8 : (b % 4 == 0) ? b / 4 : b / 2; ans++; }
                out.println(ans);
            }
        }
        out.close();
    }

    static long reduce(long x) {
        while (x % 2 == 0) x /= 2;
        return x;
    }
}
