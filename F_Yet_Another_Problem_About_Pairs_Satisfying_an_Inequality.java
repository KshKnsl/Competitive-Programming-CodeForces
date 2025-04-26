import java.util.*;

public class F_Yet_Another_Problem_About_Pairs_Satisfying_an_Inequality {

    // Segment Tree Template for Max with Lazy Propagation
    static class SegmentTree {
        private int[] tree, lazy;
        private int size;

        public SegmentTree(int n) {
            size = n;
            tree = new int[n * 4];
            lazy = new int[n * 4];
        }

        private void apply(int node, int val) {
            if (val > tree[node]) tree[node] = val;
            if (val > lazy[node]) lazy[node] = val;
        }

        private void push(int node) {
            if (lazy[node] != 0) {
                apply(node * 2, lazy[node]);
                apply(node * 2 + 1, lazy[node]);
                lazy[node] = 0;
            }
        }

        private void update(int node, int tl, int tr, int l, int r, int val) {
            if (l > tr || r < tl) return;
            if (l <= tl && tr <= r) {
                apply(node, val);
                return;
            }
            push(node);
            int mid = (tl + tr) / 2;
            update(node * 2, tl, mid, l, r, val);
            update(node * 2 + 1, mid + 1, tr, l, r, val);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        public void update(int l, int r, int val) {
            update(1, 0, size - 1, l, r, val);
        }

        private void collect(int node, int tl, int tr, int[] res) {
            if (tl >= size) return;
            if (tl == tr) {
                res[tl] = tree[node];
                return;
            }
            push(node);
            int mid = (tl + tr) / 2;
            collect(node * 2, tl, mid, res);
            collect(node * 2 + 1, mid + 1, tr, res);
        }

        public int[] collect() {
            int[] res = new int[size];
            collect(1, 0, size - 1, res);
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            int mask = (1 << k) - 1;
            SegmentTree seg = new SegmentTree(n);
            List<int[]> cur = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                List<int[]> nxt = new ArrayList<>();
                nxt.add(new int[]{a[r], r});

                for (int[] pair : cur) {
                    int val = pair[0], st = pair[1];
                    int nv = (~(val | a[r])) & mask;
                    boolean found = false;
                    for (int[] p : nxt) {
                        if (p[0] == nv) {
                            if (st < p[1]) p[1] = st;
                            found = true;
                            break;
                        }
                    }
                    if (!found) nxt.add(new int[]{nv, st});
                }

                for (int[] pair : nxt) {
                    seg.update(pair[1], r, pair[0]);
                }

                cur = nxt;
            }

            int[] ans = seg.collect();
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]);
                if (i < n - 1) System.out.print(" ");
                else System.out.println();
            }
        }

        sc.close();
    }
}
