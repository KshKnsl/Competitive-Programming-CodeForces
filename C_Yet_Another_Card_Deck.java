import java.util.*;

public class C_Yet_Another_Card_Deck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        int[] color = new int[51];
        Arrays.fill(color, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            color[x] = Math.min(color[x], i + 1);
        }
        
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            int temp = color[query];
            System.out.print(temp + " ");
            
            color[query] = 1;
            for (int j = 1; j < 51; j++) {
                if (j == query) continue;
                if (color[j] < temp) {
                    color[j]++;
                }
            }
        }
        System.out.println();
        
        sc.close();
    }
}
