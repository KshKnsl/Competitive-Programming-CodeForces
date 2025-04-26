
import java.util.Scanner;

public class B_Tenzing_and_Books {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            long target = 0;
            int n = sc.nextInt(); // Number of books per group
            long x = sc.nextLong(); // Target difficulty

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextLong();
            }

            long[] c = new long[n];
            for (int i = 0; i < n; i++) {
                c[i] = sc.nextLong();
            }

            target = check(a, n, x, target);
            if (target != x) {
                target = check(b, n, x, target);
            }
            if (target != x) {
                target = check(c, n, x, target);
            }

            if (target == x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static long check(long[] v, int n, long x, long target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 31; j++) {
                long zz = 1L << j;
                if ((x & zz) == 0 && (v[i] & zz) != 0) {
                    return target;
                }
            }
            target |= v[i];
        }
        return target;
    }
}
