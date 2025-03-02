import java.util.*;

public class D_Friends_and_the_Restaurant
{
    public static void solve()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            long[] x = new long[n], y = new long[n];
            Long[] d = new Long[n];

            for (int i = 0; i < n; i++)
                x[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                y[i] = sc.nextLong();
            for (int i = 0; i < n; i++)
                d[i] = y[i] - x[i];

            Arrays.sort(d, (a, b) -> Long.compare(b, a));

            int j = n - 1, c = 0;
            for (int i = 0; i < n; i++)
            {
                while (j > i && d[i] + d[j] < 0)
                    j--;
                if (j <= i)
                    break;
                c++;
                j--;
            }
            System.out.println(c);
        }
        sc.close();
    }

    public static void main(String[] args)
    {
        solve();
    }
}