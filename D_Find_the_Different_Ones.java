import java.io.*;
import java.util.*;

public class D_Find_the_Different_Ones {
    static int[] a;
    static int[] segMax, segMin;

    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            a = sc.nextArray(n);
            segMax = new int[4 * n];
            segMin = new int[4 * n];
            build(1, 0, n - 1);

            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
                int maxi = queryMax(1, 0, n - 1, l, r);
                int mini = queryMin(1, 0, n - 1, l, r);
                if (a[maxi] == a[mini])
                    out.println("-1 -1");
                else
                    out.println((mini + 1) + " " + (maxi + 1));            }
        }
        out.close();
    }

    static void build(int node, int l, int r) {
        if (l == r) {
            segMax[node] = l; 
            segMin[node] = l; 
            return;
        }
        int m = (l + r) / 2;
        build(2 * node, l, m);
        build(2 * node + 1, m + 1, r);
        segMax[node] = a[segMax[2 * node]] >= a[segMax[2 * node + 1]] ? segMax[2 * node] : segMax[2 * node + 1];
        segMin[node] = a[segMin[2 * node]] <= a[segMin[2 * node + 1]] ? segMin[2 * node] : segMin[2 * node + 1];
    }

    static int queryMax(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return -1;
        if (ql <= l && r <= qr)
            return segMax[node];
        int m = (l + r) / 2;
        int leftIdx = queryMax(2 * node, l, m, ql, qr);
        int rightIdx = queryMax(2 * node + 1, m + 1, r, ql, qr);

        if (leftIdx == -1)
            return rightIdx;
        if (rightIdx == -1)
            return leftIdx;
        return a[leftIdx] >= a[rightIdx] ? leftIdx : rightIdx;
    }

    static int queryMin(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l)
            return -1; 
        if (ql <= l && r <= qr)
            return segMin[node];
        int m = (l + r) / 2;
        int leftIdx = queryMin(2 * node, l, m, ql, qr);
        int rightIdx = queryMin(2 * node + 1, m + 1, r, ql, qr);

        if (leftIdx == -1)
            return rightIdx;
        if (rightIdx == -1)
            return leftIdx;
        return a[leftIdx] <= a[rightIdx] ? leftIdx : rightIdx;
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
