import java.util.HashMap;

public class B_Variety_is_Discouraged {
    static class Scan {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.util.StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new java.util.StringTokenizer(br.readLine());
                } catch (java.io.IOException e) {
                    throw new RuntimeException(e);
                }
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

    public static void main(String[] args) {
        Scan sc = new Scan();
        java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(System.out));
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = sc.nextArray(n);

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            Boolean[] isUnique = new Boolean[n];
            boolean anyUnique = false;
            for (int i = 0; i < n; i++) {
                isUnique[i] = map.get(arr[i]) == 1;
                if (isUnique[i]) anyUnique = true;
            }
            if (!anyUnique) {
                out.println("0");
                continue;
            }

            int max = 0;
            int start=0,end=0;
            int count = 0;
            int tempStart = 0;
            for (int i = 0; i < n; i++) {
                if (isUnique[i]) {
                    if (count == 0) {
                        tempStart = i;
                    }
                    count++;
                    if (count > max) {
                        max = count;
                        start = tempStart;
                        end = i;
                    }
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            out.println((start + 1) + " " + (end + 1));
        }

        out.flush();
    }
}
