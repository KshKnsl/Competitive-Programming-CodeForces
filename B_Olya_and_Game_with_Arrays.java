import java.util.*;

public class B_Olya_and_Game_with_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int gMin = Integer.MAX_VALUE;
            ArrayList<Integer> sMins = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                ArrayList<Integer> arr = new ArrayList<>();
                
                for (int j = 0; j < m; j++) {
                    arr.add(sc.nextInt());
                }
                
                int minEl = Collections.min(arr);
                gMin = Math.min(gMin, minEl);
                arr.remove(Integer.valueOf(minEl));
                sMins.add(Collections.min(arr));
            }
            
            long res = gMin;
            for (int v : sMins) {
                res += v;
            }
            res -= Collections.min(sMins);
            
            System.out.println(res);
        }
        sc.close();
    }
}
