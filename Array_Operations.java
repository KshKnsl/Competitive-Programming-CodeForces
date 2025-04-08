import java.util.*;

class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            
            int max = Collections.max(a);
            int ops = (n - 1) / 2;
            boolean odd = false;
            
            for (int j = 0; j < n; j++) {
                if (a.get(j) == max && (j % 2 == 0)) {
                    odd = true;
                    break;
                }
            }
            
            int bonus = odd ? ops : ops - 1;
            System.out.println(max + bonus);
        }
        sc.close();
    }
}
