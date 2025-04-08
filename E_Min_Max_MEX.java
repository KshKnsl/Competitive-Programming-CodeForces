import java.io.*;
import java.util.*;

public class E_Min_Max_MEX {
    public static void main(String[] args) {
        Scan sc = new Scan();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = sc.nextArray(n);

            int globalMex = computeGlobalMex(arr);

            int low = 0, high = globalMex, answer = 0;
            while (low <= high) 
            {
                int mid = (low + high) / 2;
                if (canPartition(arr, n, k, mid)) 
                {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(answer);
        }
    }

    static int computeGlobalMex(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        return mex;
    }

    static boolean canPartition(int[] arr, int n, int k, int x) {
        int count = 0;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < x)
                seen.add(arr[i]);
            if (seen.size() == x) 
            {
                count++;
                seen.clear();
            }
        }
        return count >= k;
    }

    static class Scan {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}