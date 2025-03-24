import java.io.*;
import java.util.*;

public class B_Serval_and_Final_MEX
{
    static class Scan
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next()
        {
            while (st == null || !st.hasMoreTokens())
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        int[] nextArray(int n)
        {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static int computeMex(int[] a, int l, int r)
    {
        boolean[] present = new boolean[4];
        Arrays.fill(present, false);

        for (int i = l; i <= r; i++)
        {
            if (a[i] < 4)
            {
                present[a[i]] = true;
            }
        }

        for (int x = 0; x < 4; x++)
        {
            if (!present[x])
            {
                return x;
            }
        }
        return 4;
    }

    public static void main(String[] args)
    {
        Scan scanner = new Scan();
        int t = scanner.nextInt();

        while (t-- > 0)
        {
            int n = scanner.nextInt();
            int[] a = scanner.nextArray(n);

            int[][] ops = new int[n][2];
            int cnt = 0;

            while (n > 3)
            {
                boolean hasZero = false;
                int pos = -1;
                for (int i = 0; i < n; i++)
                {
                    if (a[i] == 0)
                    {
                        hasZero = true;
                        pos = i;
                        break;
                    }
                }

                if (hasZero)
                {
                    if (pos == 0)
                    {
                        int m = computeMex(a, 0, 1);
                        ops[cnt++] = new int[]
                        { 1, 2 };

                        int[] newA = new int[n - 1];
                        newA[0] = m;
                        System.arraycopy(a, 2, newA, 1, n - 2);
                        a = newA;
                        n--;
                    } else
                    {
                        int m = computeMex(a, pos - 1, pos);
                        ops[cnt++] = new int[]
                        { pos, pos + 1 };

                        int[] newA = new int[n - 1];
                        System.arraycopy(a, 0, newA, 0, pos - 1);
                        newA[pos - 1] = m;
                        System.arraycopy(a, pos + 1, newA, pos, n - pos - 1);
                        a = newA;
                        n--;
                    }
                } else
                {
                    int m = computeMex(a, 0, n - 1);
                    ops[cnt++] = new int[]
                    { 1, n };
                    a = new int[]
                    { m };
                    n = 1;
                    break;
                }

                if (n == 3)
                {
                    int p = computeMex(a, 0, 1);
                    if (p != 0 && a[2] != 0)
                    {
                        ops[cnt++] = new int[]
                        { 1, 2 };
                        a = new int[]
                        { p, a[2] };
                        n = 2;
                    } else
                    {
                        int q = computeMex(a, 1, 2);
                        if (a[0] != 0 && q != 0)
                        {
                            ops[cnt++] = new int[]
                            { 2, 3 };
                            a = new int[]
                            { a[0], q };
                            n = 2;
                        } else
                        {
                            ops[cnt++] = new int[]
                            { 1, 3 };
                            int m = computeMex(a, 0, 2);
                            a = new int[]
                            { m };
                            n = 1;
                        }
                    }
                }

                if (n == 2)
                {
                    int m = computeMex(a, 0, 1);
                    ops[cnt++] = new int[]
                    { 1, 2 };
                    a = new int[]
                    { m };
                    n = 1;
                }
            }

            out.println(cnt);
            for (int i = 0; i < cnt; i++)
            {
                out.println(ops[i][0] + " " + ops[i][1]);
            }
        }
        out.close();
    }
}
