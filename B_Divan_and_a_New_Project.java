import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B_Divan_and_a_New_Project
{

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
            }

            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++)
            {
                pairs[i] = new Pair(arr[i], i);
            }

            Arrays.sort(pairs, (a, b) -> Long.compare(b.value, a.value));

            long sum = 0;
            for (int x = 1, i = 0; i < n; i++)
            {
                sum += (long) x * 2 * pairs[i].value;
                x += (i & 1);
            }
            out.println(sum);

            out.print("0 ");
            long[] ans = new long[n];
            for (int x = 1, i = 0; i < n; i++)
            {
                if ((i & 1) != 0)
                    ans[pairs[i].index] = x;
                else
                    ans[pairs[i].index] = -x;
                x += (i & 1);
            }

            for (int i = 0; i < n; i++)
            {
                out.print(ans[i]);
                if (i < n - 1)
                    out.print(" ");
                else
                    out.println();
            }
        }
        out.close();
    }

    static class Pair
    {
        long value;
        int index;

        Pair(long value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }

}