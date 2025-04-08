import java.util.Scanner;

public class Traveling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();

            int[] x = new int[n + 1];
            int[] y = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            long directDist = Math.abs(x[s] - x[d]) + Math.abs(y[s] - y[d]);

            long miinn = Long.MAX_VALUE;
            long minTargetToSpecial = Long.MAX_VALUE;

            for (int i = 1; i <= k; i++) {
                miinn = Math.min(miinn,
                        Math.abs(x[s] - x[i]) + Math.abs(y[s] - y[i]));

                minTargetToSpecial = Math.min(minTargetToSpecial,
                        Math.abs(x[d] - x[i]) + Math.abs(y[d] - y[i]));
            }

            long minDist = Math.min(directDist, miinn + minTargetToSpecial);
            System.out.println(minDist);
        }

        sc.close();
    }
}
